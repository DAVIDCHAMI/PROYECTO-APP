package com.example.u12.notificacionespp;

import android.app.Application;
import android.util.Log;

import com.onesignal.OSNotification;
import com.onesignal.OSNotificationAction;
import com.onesignal.OSNotificationOpenResult;
import com.onesignal.OneSignal;

import org.json.JSONObject;

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        OneSignal.startInit(this).autoPromptLocation(false).setNotificationReceivedHandler(new AnotherNotificationReceivedHandler())
                  .setNotificationOpenedHandler(new AnotherNotificationOpenedHandler())
                   .inFocusDisplaying(OneSignal.OSInFocusDisplayOption.Notification)
                   .unsubscribeWhenNotificationsAreDisabled(true)
                   .init();
    }

    private class AnotherNotificationReceivedHandler implements OneSignal.NotificationReceivedHandler {
        @Override
        public void notificationReceived(OSNotification notification) {
            JSONObject  data= notification.payload.additionalData;
            String notificationId = notification.payload.notificationID;

            Log.i("OneSignal", "notificacion id"+ notificationId);
            if(data != null){
              String  customKey=data.optString("customkey", null);
            }

        }
    }

    private class AnotherNotificationOpenedHandler implements OneSignal.NotificationOpenedHandler {
        @Override
        public void notificationOpened(OSNotificationOpenResult result) {
            OSNotificationAction.ActionType actionType = result.action.type;
            JSONObject data = result.notification.payload.additionalData;
            String id = result.notification.payload.notificationID;
            Log.i("OneSignal", "notificacion Id" + id);
        }
    }
}
