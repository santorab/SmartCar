package com.example.rodrigo.smartcar;

import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import org.w3c.dom.Document;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MapsActivity extends FragmentActivity  {

    private GoogleMap mMap; // Might be null if Google Play services APK is not available.
    private CameraUpdate mCamera;
    private ObjectLayer ruta1;
    private ObjectLayer ruta2;
    private ObjectLayer ruta3;
    private List<ObjectLayer> layerManager;
    private DbHelper dataBase;

    private int[] markersStyles = {R.drawable.carrochico, R.drawable.carrochico, R.drawable.carrochico};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_conteiner);
        try {
            init();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        setUpMapIfNeeded();
        getActionBar().hide();
    }

    private void init() throws SQLException {
        layerManager = new ArrayList<ObjectLayer>();
        dataBase = new DbHelper(this);
        dataBase.open();
        
        dataBase.addAuto(1, "BMW", "Mini", "TTA2529", "100", "19.052137", "-98.285880", "1");
        dataBase.addAuto(2, "BMW", "Mini", "TAY1069", "95", "19.052218", "-98.279743", "1");
        dataBase.addAuto(3, "BMW", "Mini", "TMM9901", "97", "19.057207", "-98.283820", "1");
        dataBase.addAuto(4, "BMW", "Mini", "TTT5555", "98", "19.052482", "-98.284399", "1");
        dataBase.addAuto(5, "BMW", "Mini", "TYE4820", "100", "19.054104", "-98.290107", "1");
        
        dataBase.addUsuario(1, "Erick", "Lopez", "Guajardo", "2222009988", "eirkc@gmail.com", "1", "0000111122223333", "000");
        dataBase.addUsuario(1, "Rodrigo", "Santoyo", "Rabadan", "2222112233", "rodrigo@gmail.com", "0", "1111222233334444", "111");
        dataBase.addUsuario(1, "Samuel", "Quiroz", "Garcia", "2222334455", "samuel@gmail.com", "0", "2222333344445555", "222");
        
        dataBase.addReservacion(2, 4, 1, "14:00", "14:15");
        
        database.addRenta(2, 4, 1, "34", "119")

        ruta1 = new ObjectLayer(dataBase.regresaRuta(1), "1");
        ruta2 = new ObjectLayer(dataBase.regresaRuta(2), "2");
        ruta3 = new ObjectLayer(dataBase.regresaRuta(3), "3");

        layerManager.add(ruta1);
        layerManager.add(ruta2);
        //Log.e("SIZE:", String.valueOf(ruta2.getSize()));
        layerManager.add(ruta3);
        //Log.e("SIZE:", String.valueOf(ruta3.getSize()));

        dataBase.close();

    }

    @Override
    protected void onResume() {
        super.onResume();
        setUpMapIfNeeded();
    }

        private void setUpMapIfNeeded() {
        // Do a null check to confirm that we have not already instantiated the map.
        if (mMap == null) {
            // Try to obtain the map from the SupportMapFragment.
            mMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map))
                    .getMap();
            // Check if we were successful in obtaining the map.
            if (mMap != null) {
                mMap.setMyLocationEnabled(true);
                mMap.setIndoorEnabled(true);
                mMap.setOnCameraChangeListener(new GoogleMap.OnCameraChangeListener() {
                    @Override
                    public void onCameraChange(CameraPosition cameraPosition) {
                        Log.d("ZOOM", String.valueOf(cameraPosition.zoom));
                        if (cameraPosition.zoom > 16.5){
                            drawMakers();
                        }
                        if (cameraPosition.zoom < 16){
                            eraseMakers();
                        }
                    }
                });
                setUpMap();
            }
        }
    }

    /**
     * This is where we can add markers or lines, add listeners or move the camera. In this case, we
     * just add a marker near Africa.
     *
     * This should only be called once and when we are sure that {@link #mMap} is not null.
     */

    private void drawMakers(){

        for (int i=0; i<layerManager.size(); i++) {
            for(int j=0; j<layerManager.get(i).getSize(); j++){

                LatLng objectLatLng = new LatLng(Double.valueOf(layerManager.get(i).getObjeto(j).latitud), Double.valueOf(layerManager.get(i).getObjeto(j).longitud));
                //mMap.addMarker(new MarkerOptions().position(objectLatLng).title("Ruta:" + i).icon(BitmapDescriptorFactory.fromResource(markersStyles[i])).snippet(layerManager.get(i).snippet)).showInfoWindow();
                mMap.addMarker(new MarkerOptions().position(objectLatLng).icon(BitmapDescriptorFactory.fromResource(markersStyles[i])).snippet(layerManager.get(i).snippet));
            }
        }
    }

    private void eraseMakers(){
        mMap.clear();
    }

    private void setUpMap() {




        //mMap.addMarker(new MarkerOptions().position(new LatLng(52.360021, 4.885174)).title("Rijksmuseum").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_CYAN)).snippet("Rijksmuseum"));

        mCamera= CameraUpdateFactory.newLatLngZoom(new LatLng(52.357322, 4.881612),15);
        mMap.animateCamera(mCamera);
        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                //Toast.makeText(getApplicationContext(), marker.getSnippet(), Toast.LENGTH_LONG).show();
                //if(marker.getSnippet().equals(ruta1))
                changeActivity(marker);
                return true;

            }
        });

    }

    private void changeActivity(Marker marker){
        Intent intent = new Intent(MapsActivity.this, CompActivity.class);
        intent.putExtra("ruta", marker.getSnippet());
        startActivity(intent);
    }

}