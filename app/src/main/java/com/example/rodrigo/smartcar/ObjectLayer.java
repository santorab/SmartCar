package com.example.rodrigo.smartcar;

/**
 * Created by Rodrigo on 02/12/2014.
 */
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rodrigo on 08/11/2014.
 */
public class ObjectLayer {

    public List<Auto> values;
    public String snippet;

    public ObjectLayer(){
        values = new ArrayList<Auto>();
    }

    public ObjectLayer(List<Auto> args, String snippet){
        this.values = args;
        this.snippet = snippet;
    }

    public int getSize(){
        return values.size();
    }

    public void addObjeto(Auto obj){
        values.add(obj);
    }

    public Auto getObjeto(int i){
        return this.values.get(i);
    }

    public List<Auto> getAllObjects(){
        return this.values;
    }


}

