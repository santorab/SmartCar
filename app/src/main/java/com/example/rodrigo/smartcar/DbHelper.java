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
    
    public void addUsuario(String arg0, String arg1, String arg2, String arg3, String arg4, String arg5, String arg6, String arg7, String arg8){
        sqlDataBase.execSQL("INSERT INTO Usuario (idUsuario, nombres, apellidoP, apellidoM, telefono, correo, esAdmin, tarjeta, tarjetaCV) VALUES('"+arg0+"', '"+arg1+"', '"+arg2+"', '"+arg3+"', '"+arg4+"', '"+arg5+"', '"+arg6+"', '"+arg7+"', '"+arg8+"')");
    }
    
    public void addAuto(String arg0, String arg1, String arg2, String arg3, String arg4, String arg5, String arg6){
        sqlDataBase.execSQL("INSERT INTO Usuario (idAuto, marca, modelo, placas, bateria, latitud, longitud) VALUES('"+arg0+"', '"+arg1+"', '"+arg2+"', '"+arg3+"', '"+arg4+"', '"+arg5+"', '"+arg6+"')");
    }
    
    public void addReservacion(String arg0, String arg1, String arg2, String arg3, String arg4){
        sqlDataBase.execSQL("INSERT INTO Usuario (idUsuario, idauto, idReservación, horaReservacion, horaLimite) VALUES('"+arg0+"', '"+arg1+"', '"+arg2+"', '"+arg3+"', '"+arg4+"')");
    }
    public void addRenta(String arg0, String arg1, String arg2, String arg3, String arg4){
        sqlDataBase.execSQL("INSERT INTO Usuario (idUsuario, idAuto, idRenta, tiempo, costo) VALUES('"+arg0+"', '"+arg1+"', '"+arg2+"', '"+arg3+"', '"+arg4+"')");
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
