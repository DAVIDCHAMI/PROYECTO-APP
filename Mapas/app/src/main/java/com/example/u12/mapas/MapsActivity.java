package com.example.u12.mapas;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.widget.Toast;

import com.directions.route.AbstractRouting;
import com.directions.route.Route;
import com.directions.route.RouteException;
import com.directions.route.Routing;
import com.directions.route.RoutingListener;
import com.example.u12.mapas.helpers.ValidarInternet;
import com.example.u12.mapas.model.Cinema;
import com.example.u12.mapas.model.Location;
import com.example.u12.mapas.model.LocationsList;
import com.example.u12.mapas.repositorys.Repository;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MapStyleOptions;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {
    private Repository repository;
    private ValidarInternet validarInternet;

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        validarInternet = new ValidarInternet(this);
        repository = new Repository();
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
        public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;


        googleMap.setMapStyle(
                MapStyleOptions.loadRawResourceStyle(this,R.raw.style_map)

        );
        /*
        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
        */
        createMarkers();


    }



    private void createMarkers() {
        //validateInternet();

        LatLng miCasa= new LatLng(6.2480569, -75.5598184);
        mMap.addMarker(new MarkerOptions().position(miCasa).title("Mi casa")
        .icon(bitmapDescriptorFromVector(this, R.drawable.ic_location_on_black_24dp))
        );



        LatLng miParche= new LatLng(6.258476, -75.5874553);
        mMap.addMarker(new MarkerOptions().position(miParche).title("Parche")
        .icon(bitmapDescriptorFromVector(this,R.drawable.ic_location_on_black_dosdp))
        );


        LatLng miBello= new LatLng(6.3471178, -75.5646677);
        mMap.addMarker(new MarkerOptions().position(miBello).title("Mirador")
                .icon(bitmapDescriptorFromVector(this,R.drawable.ic_location_on_black_tresdp))
        );

        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(miCasa, 18));
       // mMap.addPolyline(new PolylineOptions().add(miCasa, miParche).width(4).color(Color.BLUE));

        //arrays de puntos
        //centerPoints(Arrays.asList(miCasa,miParche,miBello));

          List<LatLng> points = Arrays.asList(miCasa,miParche,miBello);
            calculateRoute(points);
            centerPoints(points);
    }

    RoutingListener routingListener= new RoutingListener() {
        @Override
        public void onRoutingFailure(RouteException e) {
            Log.e("RoutingListener0" ,e.getMessage());
        }

        @Override
        public void onRoutingStart() {
            Log.i("RoutingListener0" ,"Iniciando ruta");
        }

        @Override
        public void onRoutingSuccess(ArrayList<Route> routes, int index) {
            ArrayList polyLines = new ArrayList<>();
            for (int i=0; i<routes.size(); i++){
                    PolylineOptions polylineOptions = new PolylineOptions();
                    polylineOptions.color(ContextCompat.getColor(getApplicationContext(), R.color.colorPrimary));

                    polylineOptions.width(5);
                    polylineOptions.addAll(routes.get(i).getPoints());

                Polyline polyline = mMap.addPolyline(polylineOptions);
                polyLines.add(polyline);


                int distance = routes.get(i).getDistanceValue();
                int duration=routes.get(i).getDurationValue();

                Log.i("onRoutingSuceces", distance + "");
                Log.i("onRoutingSuceces", duration + "");

            }

        }

        @Override
        public void onRoutingCancelled() {

        }
    };



    private void calculateRoute(List<LatLng> points){
        Routing routing = new Routing.Builder().travelMode(AbstractRouting.TravelMode.DRIVING)
                .waypoints(points).key(getString(R.string.google_maps_key)).optimize(true)
                .withListener(routingListener).build();


    }


    private BitmapDescriptor bitmapDescriptorFromVector(Context context, int vectorId) {

        Drawable vectorDrawable = ContextCompat.getDrawable(context,vectorId);
        vectorDrawable.setBounds(0, 0, vectorDrawable.getIntrinsicWidth(), vectorDrawable.getIntrinsicHeight());


        Bitmap bitmap = Bitmap.createBitmap(vectorDrawable.getIntrinsicWidth(), vectorDrawable.getIntrinsicHeight(),Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        vectorDrawable.draw(canvas);
        return  BitmapDescriptorFactory.fromBitmap(bitmap);

    }

    private void centerPoints(List<LatLng> points){

        LatLngBounds.Builder builder= new LatLngBounds.Builder();

        for(int i=0; i< points.size(); i++){
            builder.include(points.get(i));
        }


        LatLngBounds bounds = builder.build();
        CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngBounds(bounds,100);

        mMap.animateCamera(cameraUpdate);
    }



    private void validateInternet(){
        ValidarInternet validarInternet = new ValidarInternet(this);
        if(validarInternet.isConnected()){
            createThereadGetCines();
        }else {
            AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
            alertDialog.setTitle(R.string.title_validate_internet);
            alertDialog.setMessage(R.string.message_validate_internet);
            alertDialog.setCancelable(false);
            alertDialog.setPositiveButton(R.string.text_again, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    validateInternet();
                    dialog.dismiss();

                }
            });
        }
    }

    private void getCines() {

        try {
            final ArrayList<Cinema> ciness=repository.getCinesPeliculas();
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    loadMark(ciness);
                }
            });

        }catch (final IOException e){
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(MapsActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });

        }
    }


    private void loadMark(final ArrayList<Cinema> cines){
        List<LatLng> locations = new ArrayList<>();

       for (Cinema cinema:cines ){
           List<LocationsList> locationcine = cinema.getLocationsList();
           if(null != locationcine && !locationcine.isEmpty() ){
               for(LocationsList locationsList: locationcine){
                   Location location = locationsList.getLocation();

                   LatLng latLng= new LatLng(location.getCoordinates().get(1), location.getCoordinates().get(0));
                   mMap.addMarker(new MarkerOptions().position(latLng).title(cinema.getName() + " (" + locationsList.getName() + ") "));
                         //  .icon(bitmapDescriptorFromVector(this, R.drawable.ic_location_on_black_24dp));
                   locations.add(latLng);
               }

           }
       }

       if(!locations.isEmpty()){
           centerPoints(locations);
       }


    }

    private void createThereadGetCines(){

        Thread thread= new Thread(new Runnable() {
            @Override
            public void run() {
                getCines();
            }
        });
        thread.start();

    }

    @Override
    public void onResume() {
        super.onResume();
        validateInternet();
    }


}
