package com.example.rodrigo.smartcar;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rodrigo on 02/11/2014.
 */
public class DbHelper {

    private DbCreation db;
    private SQLiteDatabase sqlDataBase;

    public DbHelper(Context context){
        db = new DbCreation(context);
    }

    public void open() throws SQLException {
        sqlDataBase = db.getWritableDatabase();
    }

    public void close(){
        sqlDataBase.close();
    }

    public void addObject(String arg0, String arg2){
        sqlDataBase.execSQL("INSERT INTO objeto (nom_objeto, descripcion) VALUES ('"+arg0+"', '"+arg2+"')");
    }

    public List<Objeto> getAllObjects(){
        List<Objeto> result = new ArrayList<Objeto>();
        Cursor cursor = sqlDataBase.query("objeto", DbCreation.allObjetoColumns, null, null, null, null, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            result.add(new Objeto(cursor.getString(1),cursor.getString(2)));
            cursor.moveToNext();
        }
        cursor.close();
        return result;
    }



}
