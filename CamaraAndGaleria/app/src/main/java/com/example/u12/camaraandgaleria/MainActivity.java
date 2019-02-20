package com.example.u12.camaraandgaleria;

import android.Manifest;
import android.content.ClipData;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;
import java.security.Permission;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ImageView camara;
    private ImageView galeria;
    private RecyclerView recyclerView;
    private PhotoAdapter photoAdapter;
    private ArrayList<String> photos;
    private File photoFile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        camara = findViewById(R.id.camara);
        galeria = findViewById(R.id.galeria);
        recyclerView = findViewById(R.id.reciclerViewPhotos);

        //controlar null
        photos= new ArrayList<>();

        galeria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showGaleria();
            }
        });

        camara.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showCamara();
            }
        });

        callAdapter();


    }

    private void showCamara() {
        //levantar alerta pide  los permisos
        //este caso no  lo tiene
        if(Permisos.isGrantePermissions(this, Manifest.permission.CAMERA)){
            openCamara();
        }else{
            //sele dan permisos
            String[] permissions = {Manifest.permission.WRITE_EXTERNAL_STORAGE,Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.CAMERA};
            Permisos.verifyPermissions(this, permissions);
        }
    }

    private void openCamara() {

        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        photoFile =null;

        if(takePictureIntent.resolveActivity(getPackageManager()) != null){
            try{
                photoFile=createImageFile();
            }catch (IOException io){
                Toast.makeText(this,io.getMessage(),Toast.LENGTH_LONG).show();
            }

        }

if(photoFile != null){
            Uri photoUri=FileProvider.getUriForFile(this,getPackageName(),photoFile);
    List<ResolveInfo> resolveInfosList = getPackageManager().queryIntentActivities(takePictureIntent,getPackageManager().MATCH_DEFAULT_ONLY);

    for(ResolveInfo resolveInfo: resolveInfosList){
            String packageName=resolveInfo.activityInfo.packageName;
            grantUriPermission(packageName,photoUri,Intent.FLAG_GRANT_READ_URI_PERMISSION | Intent.FLAG_GRANT_WRITE_URI_PERMISSION);
    }

    takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoUri);
    startActivityForResult(takePictureIntent, 50);
}
















    }

    private File createImageFile() throws IOException {
        String imageFileName="Imagen"+new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        File starageDir=this.getExternalFilesDir(Environment.DIRECTORY_PICTURES);

        if(starageDir != null && !starageDir.exists()){
            boolean result = starageDir.mkdir();
            if(!result){
                return null;
            }
        }

        return  File.createTempFile(imageFileName,".jpg", starageDir);
    }

    private void callAdapter() {
        photoAdapter = new PhotoAdapter();
        RecyclerView.LayoutManager layoutManager= new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false);
        recyclerView.setLayoutManager(layoutManager);
        photoAdapter.setPhotos(photos);
        recyclerView.setAdapter(photoAdapter);

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


        if(requestCode==50){
            if(photoFile != null){
                setArrayPhoto(photoFile.getPath());
            }

        }
    }

    private void resultGalleryKitKatHigher(Intent data) {
        if(null ==data){
            return;
        }

        ClipData clipData = data.getClipData();



        if (clipData != null ){
            for(int i=0 ; i< clipData.getItemCount() ; i++){
                grantUriPermission(getPackageName(), clipData.getItemAt(i).getUri(),Intent.FLAG_GRANT_READ_URI_PERMISSION);
                // se  refresca el reciclerview
                setArrayPhoto(clipData.getItemAt(i).getUri().toString());

            }
        }else {
            resultGalleryKitKaLess(data.getData());
        }
    }

    private void resultGalleryKitKaLess(Uri data) {
        grantUriPermission(getPackageName(), data,Intent.FLAG_GRANT_READ_URI_PERMISSION);
        setArrayPhoto(data.toString());


    }

    private void setArrayPhoto(String photo){

        if(!photos.contains(photo)){
            //actualizar
            photos.add(photo);
            photoAdapter.setPhotos(photos);
            photoAdapter.notifyDataSetChanged();
        }

    }
}
