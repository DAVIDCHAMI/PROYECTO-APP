package com.example.u12.camaraandgaleria;

import android.Manifest;
import android.content.ClipData;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import java.security.Permission;

public class MainActivity extends AppCompatActivity {

    private ImageView camara;
    private ImageView galeria;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        camara = findViewById(R.id.camara);
        galeria = findViewById(R.id.galeria);
        recyclerView = findViewById(R.id.reciclerViewPhotos);

        galeria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showGaleria();
            }
        });



    }

    private void showGaleria() {
        //levantar alerta pide  los permisos
        //este caso no  lo tiene
        if(Permisos.isGrantePermissions(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)){
            openGaleria();
        }else{
            //sele dan permisos
            String[] permissions = {Manifest.permission.WRITE_EXTERNAL_STORAGE,Manifest.permission.READ_EXTERNAL_STORAGE};
            Permisos.verifyPermissions(this, permissions);
        }
    }

    private void openGaleria() {
        //inten  para  galeria api 19 para arriba
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);


        if(Build.VERSION.SDK_INT < Build.VERSION_CODES.KITKAT ){
            // el request puede  tener cualquier  entero
           startActivityForResult(intent, Build.VERSION_CODES.KITKAT);
        }else{
            String[] type ={"image/*"};
            intent.putExtra(intent.EXTRA_MIME_TYPES,type);
            intent.putExtra(intent.EXTRA_ALLOW_MULTIPLE, true );
            // el request puede  tener cualquier  entero
            startActivityForResult(intent,Constants.GALLERY);
        }
    }

    //regresar el objeto seleccionado  regrese

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==  Build.VERSION_CODES.KITKAT){
            resultGalleryKitKaLess(data.getData());
        }

        if(requestCode ==Constants.GALLERY){
            resultGalleryKitKatHigher(data);
        }
    }

    private void resultGalleryKitKatHigher(Intent data) {
        ClipData clipData = data.getClipData();
        if (clipData != null ){
            for(int i=0 ; i< clipData.getItemCount() ; i++){
                grantUriPermission(getPackageName(), clipData.getItemAt(i).getUri(),Intent.FLAG_GRANT_READ_URI_PERMISSION);
                clipData.getItemAt(i).getUri();
            }
        }
    }

    private void resultGalleryKitKaLess(Uri data) {
        grantUriPermission(getPackageName(), data,Intent.FLAG_GRANT_READ_URI_PERMISSION);
        data.toString();


    }
}
