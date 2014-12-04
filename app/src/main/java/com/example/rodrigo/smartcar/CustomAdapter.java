package com.example.rodrigo.smartcar;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Rodrigo on 02/11/2014.
 */

public class CustomAdapter extends BaseAdapter {


    private final Context context;
    private List<Auto> values;
    /**
     * instancia un nuevo objeto
     * @param context el contexto de la aplicacion
     * @param values lista generica en selector con el contenido de todos los elementos que se pintaran
     */
    public CustomAdapter(Context context, List<Auto> values){
        this.context = context;
        this.values = values;
    }

    @Override
    public int getCount() {
        return values.size();
    }

    @Override
    public Object getItem(int arg0) {
        return values.get(arg0);
    }

    @Override
    public long getItemId(int arg0) {
        return arg0;
    }



    @Override
    public View getView(int arg0, View arg1, ViewGroup arg2) {
        if (arg1 == null){
            LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            arg1 = inflater.inflate(R.layout.custom_list_element, null);
        }
        TextView title = (TextView)arg1.findViewById(R.id.titulo);
        ImageView icon = (ImageView)arg1.findViewById(R.id.iconito);
        title.setText(values.get(arg0).getPlacas());
        icon.setImageDrawable(context.getResources().getDrawable(R.drawable.icono));
        return arg1;
    }

}
