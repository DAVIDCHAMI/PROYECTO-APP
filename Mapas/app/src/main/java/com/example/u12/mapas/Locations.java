package com.example.u12.mapas;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.pm.PackageManager;
import android.location.Location;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

public class Locations extends AppCompatActivity {

    private static final int REQUEST_PERMISSION_CODE = 34;
    private TextView mLatitudText, mLongitudTex;
    protected Location mLastLocation;
    private FusedLocationProviderClient mFusedLocationProviderClient;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);


        mLatitudText= findViewById(R.id.latitud_tv);
        mLongitudTex =findViewById(R.id.longitud_tv);
        mFusedLocationProviderClient= LocationServices.getFusedLocationProviderClient(this);

    }


    @Override
    protected void onStart() {
        super.onStart();
        if(!checkPermissions()){
            requestPermission();
        }else{
            getLastLocation();
        }
    }




    private void requestPermission() {
        boolean shouldProviderRationale=ActivityCompat.shouldShowRequestPermissionRationale(this,Manifest.permission.ACCESS_COARSE_LOCATION);
        if(shouldProviderRationale){
            //TODO
            Log.i("Location", "Mensaje para el usuario de que encienda el gps");

        }else{
            starLocationPermissionRequest();

        }
    }

    private void starLocationPermissionRequest() {

        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_COARSE_LOCATION}, REQUEST_PERMISSION_CODE);
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode == REQUEST_PERMISSION_CODE){
            if(grantResults.length <=0){
                Log.i("Location", "usuario no acepta permiso");
            }else if(grantResults[0]== PackageManager.PERMISSION_GRANTED){
                getLastLocation();
            }else{
                Log.i("Location", "usuario no acepta permiso");
            }
        }
    }

    @SuppressLint("MissingPermission")
    private void getLastLocation() {
                mFusedLocationProviderClient.getLastLocation().addOnCompleteListener(this, new OnCompleteListener<Location>() {
                    @Override
                    public void onComplete(@NonNull Task<Location> task) {
                        if(task.isSuccessful() && task.getResult() !=null){
                            mLastLocation=task.getResult();

                            mLatitudText.setText(String.valueOf(mLastLocation.getLatitude()));
                            mLongitudTex.setText(String.valueOf(mLastLocation.getLongitude()));
                        }else{
                            Toast.makeText(Locations.this,"Localización no encontrada",Toast.LENGTH_LONG).show();
                        }
                    }
                });


    }

    private boolean checkPermissions() {
        int permissionState=ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION);

        return  permissionState== PackageManager.PERMISSION_GRANTED;
    }
}
