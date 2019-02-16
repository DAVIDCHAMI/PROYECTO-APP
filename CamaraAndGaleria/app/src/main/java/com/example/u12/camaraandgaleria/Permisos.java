package com.example.u12.camaraandgaleria;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;

public class Permisos {


    public static boolean isGrantePermissions(Context context,String permissionType){
        int permission=ActivityCompat.checkSelfPermission(context,permissionType);

        return permission == PackageManager.PERMISSION_GRANTED;
    }


    public static void verifyPermissions(Activity activity, String[] permissionType){
        ActivityCompat.requestPermissions(activity,permissionType ,3);
    }
}
