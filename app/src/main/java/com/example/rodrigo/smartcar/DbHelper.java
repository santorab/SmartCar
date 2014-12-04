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
    
    public void addAuto(String arg0, String arg1, String arg2, String arg3, String arg4, String arg5, String arg6, String arg7){
        sqlDataBase.execSQL("INSERT INTO Auto (idAuto, marca, modelo, placas, bateria, latitud, longitud, estado) VALUES('"+arg0+"', '"+arg1+"', '"+arg2+"', '"+arg3+"', '"+arg4+"', '"+arg5+"', '"+arg6+"', '"+arg7+"')");
    }
    
    public void addReservacion(String arg0, String arg1, String arg2, String arg3, String arg4){
        sqlDataBase.execSQL("INSERT INTO Reservacion(idUsuarioReserva, idAutoReserva, idReservacion, horaReservacion, horaLimite) VALUES('"+arg0+"', '"+arg1+"', '"+arg2+"', '"+arg3+"', '"+arg4+"')");
    }
    public void addRenta(String arg0, String arg1, String arg2, String arg3, String arg4){
        sqlDataBase.execSQL("INSERT INTO Renta (idUsuarioRenta, idAutoRenta, idRenta, tiempo, costo) VALUES('"+arg0+"', '"+arg1+"', '"+arg2+"', '"+arg3+"', '"+arg4+"')");
    }

    public List<Auto> getAllAutos(){
        List<Auto> result = new ArrayList<Auto>();
        Cursor cursor = sqlDataBase.query("auto", DbCreation.allAutoColumns, null, null, null, null, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            result.add(new Auto(cursor.getInt(1),cursor.getString(2),cursor.getString(3),cursor.getString(4),cursor.getString(5),cursor.getString(6),cursor.getString(7)));
            cursor.moveToNext();
        }
        cursor.close();
        return result;
    }


    public List<Auto> regresaAutos( )
    {
        List<Auto> result = new ArrayList<Auto>();
        String qry= "Select * from Auto";
        Cursor cursor = sqlDataBase.rawQuery(qry, null);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            result.add(new Auto(cursor.getInt(1),cursor.getString(2), cursor.getString(3),cursor.getString(4), cursor.getString(5), cursor.getString(6),cursor.getString(7)));
            cursor.moveToNext();
        }
        cursor.close();
        return result;
    }
}
