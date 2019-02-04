package com.example.u12.arquitecturamvp;

import android.app.Application;

import com.example.u12.arquitecturamvp.helps.Database;

public class App  extends Application {
    public  static Database  mDb;

    @Override
    public void onCreate() {
        super.onCreate();

        createDatabase();
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
}
