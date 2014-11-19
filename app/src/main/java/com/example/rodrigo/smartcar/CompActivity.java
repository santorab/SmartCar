package com.example.rodrigo.smartcar;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.List;

/**
 * Created by Rodrigo on 02/11/2014.
 */

public class CompActivity extends Activity implements AdapterView.OnItemClickListener{


    private ListView lv;
    private CustomAdapter ca;
    private List<Objeto> values;
    private DbHelper dataBase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comp);
        getActionBar().hide();
        String marker = getIntent().getExtras().getString("marker");
        init();
        //Asumiendo que existe la base de dartos: Database myDatabase;
        //myDatabase.getMarker(marker);
    }

    private void init ()
    {
        try {
            dataBase = new DbHelper(getApplicationContext());
            dataBase.open();

            dataBase.addObject(" Self-Portrait ","Vincent moved to Paris in 1886, after hearing from his brother Theo about the new, colourful style of French painting");
            dataBase.addObject(" Milk Maid ","A maidservant pours milk, entirely absorbed in her work. Except for the stream of milk, everything else is still");
            dataBase.addObject(" Morning Ride ","As in his painting of the Morning Ride on the Beach (Gallery 1.18), Mauve shows the riders from behind");
            dataBase.addObject(" Night Watch ","Rembrandt’s largest, most famous canvas was made for the Arquebusiers guild hall. This was one of several halls of Amsterdam’s civic guard");
            dataBase.addObject(" Single Bridge ","Breitner often took photographs to prepare his paint-ings, and several such studies are known for this work.");
            dataBase.addObject(" Windmill ","Our country is saturated with colour. ...I repeat, our country is not grey, not even in grey weather, nor are the dunes grey,’ wrote Constant Gabriël in a letter");
            dataBase.addObject(" Childrens ","This charming scene contains a message. The children of a fisherman, with their tattered rags and paltry toys, offer us a glimpse of their future");
            dataBase.addObject(" Flower Pyramid ","Costly cut flowers could be placed in each spout of this flower pyramid, which is built up of separate elements");
            dataBase.addObject(" Mary Stuart ","That William and Mary were eternalized in tin-glazed earthenware is highly appropriate");
            dataBase.addObject(" Lidded Jar ","The octagonal shape of this jar after a Chinese model was a technical tour de force.");
            dataBase.addObject(" Violin ","This tin-glazed earthenware violin cannot be played, for it is a decorative object");
            dataBase.addObject(" Shoe ","This small shoe with a large bow and a square toe reflects the fashion around 1665. In contrast, the floral decorations are derived from Chinese porcelain");
            dataBase.addObject(" Oriental Vessel ","This model combines an Indonesian design with Chinese carvings. Eyes have been painted on either side of the prow.");
            dataBase.addObject(" Prins Willem ","The real Prins Willem left the harbour of Middelburg in 1651 for its maiden voyage to the East Indies");
            dataBase.addObject(" William Rex ","This model shows the appearance of a Dutch warship in the late 17th century. It was made at the dockyards of Vlissingen (Flushing)");


            values = dataBase.getAllObjects();
            dataBase.close();
            lv = (ListView)findViewById(R.id. listView);
            lv.setOnItemClickListener(this);
            ca = new CustomAdapter(getApplicationContext(), values);
            lv.setAdapter(ca);
        }catch(Exception e){
            Log.e("Error", e.toString());
        }


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.comp, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }
}
