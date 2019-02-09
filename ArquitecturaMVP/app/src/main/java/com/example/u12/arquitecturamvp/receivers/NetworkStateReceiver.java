package com.example.u12.arquitecturamvp.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;

import com.example.u12.arquitecturamvp.App;



public class NetworkStateReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        boolean isConnected;
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo= connectivityManager.getActiveNetworkInfo();
        if(networkInfo== null || networkInfo.getState() != NetworkInfo.State.CONNECTED){
            isConnected=false;
        }else {
            isConnected=networkInfo.isConnected();
        }
        waitAndCheckConnetion(isConnected, context);

    }

    private void waitAndCheckConnetion(final boolean isConnection, final Context context){
    Runnable runnable= new Runnable() {
        @Override
        public void run() {

            App application =(App) context.getApplicationContext();
            if(application != null ){
                application.onNetworkStateChanged(isConnection);
            }
        }
    };
    new Handler().postDelayed(runnable,2000 );
    }

}


