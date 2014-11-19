package com.example.rodrigo.smartcar;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Rodrigo on 02/11/2014.
 */
public class DbCreation extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "rutas.db";

    public static final String MUSEO = "museo";
    public static final String ID_MUSEO = "id_museo";
    public static final String NOM_MUSEO= "nom_museo";
    public static final String CIU_MUSEO = "ciu_museo";
    public static final String PAIS_MUSEO = "pais_museo";

    public static final String OBJETO = "objeto";
    public static final String ID_OBJETO = "id_objeto";
    public static final String NOM_OBJETO = "nom_objeto";
    public static final String DESCRIPCION = "descripcion";
    public static final String LAT_OBJETO = "lat_objeto";
    public static final String LONG_OBJETO = "long_objeto";

    public static String[] allObjetoColumns = {ID_OBJETO,NOM_OBJETO,DESCRIPCION,LAT_OBJETO,LONG_OBJETO};

    public static final String EXHIBE = "exhibe";
    public static final String Id_Museo = "id_museo";
    public static final String Id_Objeto = "id_ objeto";

    public static final String USUARIO = "usuario";
    public static final String ID_USUARIO = "id_usuario";
    public static final String NOM_PERFIL= "nom_perfil";
    public static final String NOM_USUARIO = "nom_usuario";
    public static final String EMAIL= "email";

    public static final String RUTA = "ruta";
    public static final String ID_RUTA = "id_ruta";
    public static final String TEMA= "tema";
    public static final String TIEMPO = "tiempo";
    public static final String RANK= "rank";

    public static final String PERTENECE = "pertenece";
    public static final String Id_Usuario = "id_usuario";
    public static final String Id_Ruta= "id_ ruta";

    public static final String CONFORMA = "conforma";
    public static final String IdObjeto = "id_usuario";
    public static final String IdRuta= "id_ ruta";




    private static final String CREATE_TABLE_MUSEO =
            "create table " +
                    MUSEO + " (" +
                    ID_MUSEO + " integer not null, " +
                    NOM_MUSEO + " text not null, " +
                    PAIS_MUSEO + " text not null, " +
                    CIU_MUSEO + " text not null)" ;


    private static final String CREATE_TABLE_OBJETO =
            "create table " +
                    OBJETO + " (" +
                    ID_OBJETO + " integer primary key autoincrement, " +
                    NOM_OBJETO + " text, " +
                    DESCRIPCION + " text, " +
                    LAT_OBJETO + " float, " +
                    LONG_OBJETO + " float)" ;

    private static final String CREATE_TABLE_EXHIBE =
            "create table " +
                    EXHIBE + " (" +
                    Id_Museo + " integer not null, " +
                    Id_Objeto+ " integer not null)" ;

    private static final String CREATE_TABLE_USUARIO =
            "create table " +
                    USUARIO + " (" +
                    ID_USUARIO + " integer not null, " +
                    NOM_PERFIL + " text not null, " +
                    NOM_USUARIO + " text not null, " +
                    EMAIL + " text not null)" ;

    private static final String CREATE_TABLE_RUTA=
            "create table " +
                    RUTA + " (" +
                    ID_RUTA + " integer not null, " +
                    TEMA + " text not null, " +
                    TIEMPO + " text not null, " +
                    RANK+ " text not null)" ;

    private static final String CREATE_TABLE_PERTENECE =
            "create table " +
                    PERTENECE + " (" +
                    Id_Usuario + " integer not null, " +
                    Id_Ruta+ " integer not null)" ;

    private static final String CREATE_TABLE_CONFORMA =
            "create table " +
                    CONFORMA + " (" +
                    IdObjeto + " integer not null, " +
                    IdRuta + " integer not null)" ;



    public DbCreation(Context context){
        super(context, DATABASE_NAME, null, 1);
    }

    public void onCreate(SQLiteDatabase arg0) {
        //arg0.execSQL(CREATE_TABLE_MUSEO);
        arg0.execSQL(CREATE_TABLE_OBJETO);
       /* arg0.execSQL(CREATE_TABLE_EXHIBE);
        arg0.execSQL(CREATE_TABLE_USUARIO);
        arg0.execSQL(CREATE_TABLE_RUTA);
        arg0.execSQL(CREATE_TABLE_PERTENECE);
        arg0.execSQL(CREATE_TABLE_CONFORMA);*/

    }


    public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
        // TODO Auto-generated method stub

    }
}
