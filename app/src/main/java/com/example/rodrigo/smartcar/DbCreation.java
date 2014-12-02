import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
/**
 * Created by Rodrigo on 26/10/2014.
 */
public class DbCreation extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "SmartCar.db";
    
    public static final String Usuario = "usuario";
    public static final String idUsuario = "idUsuario";
    public static final String nombres = "nombres";
    public static final String apellidoP = "apellidoP";
    public static final String apellidoM = "apellidoM";
    public static final String telefono = "telefono";
    public static final String correo = "correo";
    public static final String tarjeta = "tarjeta";
    public static final String tarjetaCV = "tarjetaCV";
    public static final String esAdmin = "esAdmin";
    
    public static final String Auto = "auto";
    public static final String idAuto = "idAuto";
    public static final String marca = "marca";
    public static final String modelo = "modelo";
    public static final String placas = "placas";
    public static final String bateria = "bateria";
    public static final String latitud = "latitud";
    public static final String longitud = "longitud";
    public static final String estado = "estado";
    
    public static final String Reservacion = "Reservacion";
    public static final String idUsuarioReserva = "idUsiarioReserva";
    public static final String idAutoReserva = "idAutoReserva";
    public static final String idReservacion = "idReservacion";
    public static final String horaReservacion = "horaReservacion";
    public static final String horaLimite = "horaLimite";
    
    public static final String Renta = "Renta";
    public static final String idUsuarioRenta = "idUsuarioRenta";
    public static final String idAutoRenta = "idAutoRenta";
    public static final String idRenta = "idRenta";
    public static final String tiempo = "tiempo";
    public static final String costo = "costo";
    //public static String[] allObjetoColumns = {ID_OBJETO,NOM_OBJETO,DESCRIPCION,LAT_OBJETO,LONG_OBJETO};
    private static final String  CREATE_TABLE_USUARIO= 
            "create table " +
                    Usuario + " (" +
                    idUsuario + " integer not null, " +
                    nombres + " text not null, " +
                    apellidoP + " text not null, " +
                    apellidoM + " text not null, " +
                    telefono + " text not null, " +
                    correo + " text not null, " +
                    esAdmin + " bit, " + //Binario
                    tarjeta + " int not null, " +
                    tarjetaCV + " int not null)" ;
    
    private static final String CREATE_TABLE_AUTO =
            "create table " +
                    Auto + " (" +
                    idAuto + " integer not null, " +
                    marca + " text not null, " +
                    modelo + " text not null, " +
                    placas + " text not null, " +
                    bateria + " text not null, " +
                    latitud + " text not null, " +
                    longitud + " text not null, " +
                    estado + " text not null ";
    
    private static final String CREATE_TABLE_RESERVACION =
            "create table " +
                    Reservacion + " (" +
                    idUsuarioReserva + " integer not null, " +
                    idAutoReserva + " integer not null, " +
                    idReservacion + " integer not null, " +
                    horaReservacion + " text not null, " + //Fecha y hora
                    horaLimite + " text not null, "; //Fecha y hora
    
    private static final String CREATE_TABLE_RENTA =
            "create table " +
                    Renta + " (" +
                    idUsuarioRenta + " integer not null, " +
                    idAutoRenta + " integer not null, " +
                    idRenta + " integer not null, " +
                    tiempo + " text not null, " +
                    costo + " text not null, ";
    
    
    public DbCreation(Context context){
        super(context, DATABASE_NAME, null, 1);
    }
    public void onCreate(SQLiteDatabase arg0) {
		  //arg0.execSQL(CREATE_TABLE_USUARIO);
        //arg0.execSQL(CREATE_TABLE_AUTO);
        //arg0.execSQL(CREATE_TABLE_RENTA);
       // arg0.execSQL(CREATE_TABLE_RESERVACION);
        
    }
    public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
        // TODO Auto-generated method stub
    }
}