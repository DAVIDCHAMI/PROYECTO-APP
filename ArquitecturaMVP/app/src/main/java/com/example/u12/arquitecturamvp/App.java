package com.example.u12.arquitecturamvp;

import android.app.Application;
import android.content.IntentFilter;
import android.util.Log;

import com.example.u12.arquitecturamvp.helps.Database;
import com.example.u12.arquitecturamvp.receivers.NetworkStateReceiver;

public class App  extends Application {
    public  static Database  mDb;

    private final NetworkStateReceiver NETWORK_STATE_RECEIVER =new NetworkStateReceiver();

    @Override
    public void onCreate() {
        super.onCreate();

        createDatabase();
        registerNetworkStateReciver();
    }

    private void registerNetworkStateReciver() {
        IntentFilter filter = new IntentFilter();
        /// se  define  la acción
        filter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        registerReceiver(NETWORK_STATE_RECEIVER,filter);

    }

    private void createDatabase() {
        mDb= new Database(this);
        mDb.open();
    }

    @Override
    public void onTerminate() {
        mDb.close();
        super.onTerminate();
    }

    public void onNetworkStateChanged(boolean isConnection) {
        String msg= isConnection ? "conectado": "desconectado";
        Log.i("CONNECTION_STATE",msg);

    }
}
