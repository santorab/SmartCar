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

/*
        dataBase.addObject(" Self-Portrait ",R.drawable.selfportrait,"Vincent moved to Paris in 1886, after hearing from his brother Theo about the new, colourful style of French painting", "52.360066","4.884618");
        dataBase.addObject(" Milk Maid ", R.drawable.milkmaid,"A maidservant pours milk, entirely absorbed in her work. Except for the stream of milk, everything else is still", "52.359987", "4.885927");
        dataBase.addObject(" Morning Ride ",R.drawable.mornigride,"As in his painting of the Morning Ride on the Beach (Gallery 1.18), Mauve shows the riders from behind", "52.35964", "4.885465");
        dataBase.addObject(" Night Watch ",R.drawable.nightwatch,"Rembrandt’s largest, most famous canvas was made for the Arquebusiers guild hall. This was one of several halls of Amsterdam’s civic guard", " 52.359895", "4.88502");
        dataBase.addObject(" Single Bridge ",R.drawable.singlebridge, "Breitner often took photographs to prepare his paint-ings, and several such studies are known for this work.","52.360567"," 4.884795");
        dataBase.addObject(" Windmill ",R.drawable.windmill,"Our country is saturated with colour. ...I repeat, our country is not grey, not even in grey weather, nor are the dunes grey,’ wrote Constant Gabriël in a letter","52.359849","4.886243");
        dataBase.addObject(" Children ",R.drawable.childrens,"This charming scene contains a message. The children of a fisherman, with their tattered rags and paltry toys, offer us a glimpse of their future", "52.359948","4.885739");
        dataBase.addObject(" Flower Pyramid ",R.drawable.flowerpyramid,"Costly cut flowers could be placed in each spout of this flower pyramid, which is built up of separate elements"," 52.359916","4.88487");
        dataBase.addObject(" Mary Stuart ",R.drawable.marystuart,"That William and Mary were eternalized in tin-glazed earthenware is highly appropriate","52.359818", "4.885348");
        dataBase.addObject(" Lidded Jar ",R.drawable.liddedjar, "The octagonal shape of this jar after a Chinese model was a technical tour de force.", "52.360257", "4.884463");
        dataBase.addObject(" Violin ",R.drawable.violin,"This tin-glazed earthenware violin cannot be played, for it is a decorative object", "52.360408", "4.884779");
        dataBase.addObject(" Shoe ",R.drawable.shoe,"This small shoe with a large bow and a square toe reflects the fashion around 1665. In contrast, the floral decorations are derived from Chinese porcelain","52.360368","4.884945");
        dataBase.addObject(" Oriental Vessel ",R.drawable.orientalvessel,"This model combines an Indonesian design with Chinese carvings. Eyes have been painted on either side of the prow.", "52.360159", "4.88523");
        dataBase.addObject(" Prins Willem ", R.drawable.prinswillem,"The real Prins Willem left the harbour of Middelburg in 1651 for its maiden voyage to the East Indies", "52.360247","4.88524");
        dataBase.addObject(" William Rex ", R.drawable.williamrex, "This model shows the appearance of a Dutch warship in the late 17th century. It was made at the dockyards of Vlissingen (Flushing)", "52.36006", "4.885675");


        dataBase.addMuseo("RijksMuseum","Amsterdam", "Netherlands");
        dataBase.addMuseo("Van Gogh Museum","Amsterdam", "Netherlands");
        dataBase.addMuseo("Stedelijk","Amsterdam", "Netherlands");

        dataBase.addRuta(" Van Gogh", "Impresionismo", "60", "5" );
        dataBase.addRuta(" Ceramica", "Contemporaneo", "60", "4" );
        dataBase.addRuta(" Barcos", "Modelos", "60", "3" );
        dataBase.addRuta(" Esculturas", "Esculturas", "60","2" );
        dataBase.addRuta(" Mi ruta", "Esculturas", "60","2");
        dataBase.addRuta(" Rembrandt", "Impresionismo", "60","1");

        dataBase.addUsuario(R.drawable.profilepic, "Santorab", "Rodrigo" ,"santorab@hotmail.com");
        dataBase.addUsuario(R.drawable.karen, "KarenMuca", "karen" ,"karen_mc11@hotmail.com");
        dataBase.addUsuario(R.drawable.mushi, "Mushi", "Eli" ,"mushi@hotmail.com");
        dataBase.addUsuario(R.drawable.lu, "Lu", "Luis" ,"silu@hotmail.com");
        dataBase.addUsuario(R.drawable.fernando, "Gallo", "Fernando" ,"gallo@hotmail.com");
        dataBase.addUsuario(R.drawable.tania, "Tain", "Tania" ,"tain@hotmail.com");

        dataBase.addExhibe(1,1);
        dataBase.addExhibe(1,2);
        dataBase.addExhibe(1,3);
        dataBase.addExhibe(1,4);
        dataBase.addExhibe(1,5);
        dataBase.addExhibe(1,6);
        dataBase.addExhibe(1,7);
        dataBase.addExhibe(1,8);
        dataBase.addExhibe(1,9);
        dataBase.addExhibe(1,10);
        dataBase.addExhibe(1,11);
        dataBase.addExhibe(1,12);
        dataBase.addExhibe(1,13);
        dataBase.addExhibe(1,14);
        dataBase.addExhibe(1,15);

        dataBase.addPertenece(1,1);
        dataBase.addPertenece(2,1);
        dataBase.addPertenece(3,2);
        dataBase.addPertenece(4,2);
        dataBase.addPertenece(5,2);
        dataBase.addPertenece(6,3);

        dataBase.addConforma(1,1,1);
        dataBase.addConforma(1,2,1);
        dataBase.addConforma(1,3,1);
        dataBase.addConforma(1,4,1);
        dataBase.addConforma(2,5,1);
        dataBase.addConforma(2,7,2);
        dataBase.addConforma(2,8,3);
        dataBase.addConforma(2,9,4);
        dataBase.addConforma(2,10,5);
        dataBase.addConforma(3,11,5);
        dataBase.addConforma(3,12,4);
        dataBase.addConforma(3,13,3);
        dataBase.addConforma(3,14,2);
        dataBase.addConforma(3,15,1);
        dataBase.addConforma(4,1,2);
        dataBase.addConforma(4,3,1);
        dataBase.addConforma(4,5,4);
        dataBase.addConforma(4,7,3);
        dataBase.addConforma(4,9,5);
        dataBase.addConforma(5,2,1);
        dataBase.addConforma(5,4,2);
        dataBase.addConforma(5,6,3);
        dataBase.addConforma(6,1,3);
        dataBase.addConforma(6,6,2);
        dataBase.addConforma(6,11,1);
        dataBase.addConforma(6,9,4);
        dataBase.addConforma(6,10,5);

        dataBase.addTiene(1,1,"Excelente");
        dataBase.addTiene(1,2,"Muy bueno");

        dataBase.addTiene(2,3,"Malo");
        dataBase.addTiene(2,4,"Excelente");
        dataBase.addTiene(2,5,"Recomendable");
        dataBase.addTiene(3,6,"Muy bueno");
        dataBase.addTiene(3,1,"Malo");
        dataBase.addTiene(4,2,"Excelente");
        dataBase.addTiene(4,3,"Muy bueno");
        dataBase.addTiene(5,4,"Excelente");
        dataBase.addTiene(5,5,"Malo");
        dataBase.addTiene(6,6,"Excelente");
        dataBase.addTiene(6,1,"Muy bueno");
        dataBase.addTiene(6,2,"Excelente");
        dataBase.addTiene(7,3,"Muy bueno");
        dataBase.addTiene(7,4,"Excelente");
        dataBase.addTiene(8,5,"Malo");
        dataBase.addTiene(8,6,"Muy bueno");
        dataBase.addTiene(9,1,"Muy bueno");
        dataBase.addTiene(9,2,"Excelente");
        dataBase.addTiene(10,3,"Recomendable");
        dataBase.addTiene(10,4,"Excelente");
        dataBase.addTiene(11,5,"Muy bueno");
        dataBase.addTiene(11,6,"Excelente");
        dataBase.addTiene(12,1,"Malo");
        dataBase.addTiene(12,2,"Muy bueno");
        dataBase.addTiene(13,3,"Excelente");
        dataBase.addTiene(13,4,"Muy bueno");
        dataBase.addTiene(14,5,"Excelente");
        dataBase.addTiene(14,6,"Recomendable");
        dataBase.addTiene(15,1,"Muy bueno");
        dataBase.addTiene(15,2,"Muy Recomendable");
        dataBase.addTiene(1,6,"NUEVO COMENTARIO");

*/

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