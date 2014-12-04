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
    private List<Auto> values;
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



            values = dataBase.getAllAutos();
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
