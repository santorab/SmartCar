package com.example.rodrigo.smartcar;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity  {

    private GoogleMap mMap; // Might be null if Google Play services APK is not available.
    private CameraUpdate mCamera;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_conteiner);
        setUpMapIfNeeded();
        //getActionBar().hide();
    }

    @Override
    protected void onResume() {
        super.onResume();
        setUpMapIfNeeded();
    }

    /**
     * Sets up the map if it is possible to do so (i.e., the Google Play services APK is correctly
     * installed) and the map has not already been instantiated.. This will ensure that we only ever
     * call {@link #setUpMap()} once when {@link #mMap} is not null.
     * <p>
     * If it isn't installed {@link SupportMapFragment} (and
     * {@link com.google.android.gms.maps.MapView MapView}) will show a prompt for the user to
     * install/update the Google Play services APK on their device.
     * <p>
     * A user can return to this FragmentActivity after following the prompt and correctly
     * installing/updating/enabling the Google Play services. Since the FragmentActivity may not
     * have been completely destroyed during this process (it is likely that it would only be
     * stopped or paused), {@link #onCreate(Bundle)} may not be called again so we should call this
     * method in {@link #onResume()} to guarantee that it will be called.
     */
    private void setUpMapIfNeeded() {
        // Do a null check to confirm that we have not already instantiated the map.
        if (mMap == null) {
            // Try to obtain the map from the SupportMapFragment.
            mMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map))
                    .getMap();
            // Check if we were successful in obtaining the map.
            if (mMap != null) {
                mMap.setMyLocationEnabled(true);
                setUpMap();
            }
        }
    }

    /**
     * This is where we can add markers or lines, add listeners or move the camera. In this case, we
     * just add a marker near Africa.
     * <p>
     * This should only be called once and when we are sure that {@link #mMap} is not null.
     */
    private void setUpMap() {
        mMap.addMarker(new MarkerOptions().position(new LatLng(19.055552, -98.284318)).title("1").icon(BitmapDescriptorFactory.fromResource(R.drawable.marker)).snippet("90%"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(19.051060, -98.284232)).title("2").icon(BitmapDescriptorFactory.fromResource(R.drawable.marker)).snippet("70%"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(19.051851, -98.284361)).title("3").icon(BitmapDescriptorFactory.fromResource(R.drawable.marker)).snippet("86%"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(19.053879, -98.290530)).title("4").icon(BitmapDescriptorFactory.fromResource(R.drawable.marker)).snippet("56%"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(19.056597, -98.288191)).title("5").icon(BitmapDescriptorFactory.fromResource(R.drawable.marker)).snippet("28%"));
        mCamera= CameraUpdateFactory.newLatLngZoom(new LatLng(19.054345, -98.283620), 15);
        mMap.animateCamera(mCamera);
        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                if (marker.getTitle().equals("1")){
                    changeActivity(marker);
                }
                return true;
            }
        });
    }

    private void changeActivity(Marker marker){
        Intent intent = new Intent(MapsActivity.this, CompActivity.class);
        intent.putExtra("marker", marker.getTitle());
        startActivity(intent);
    }
}
