package com.example.rodrigo.smartcar;

public class Reservacion {
    
    int idUsuario;
    int idAuto;
    int idReservacion;
    String horaReservacion;
    String horaLimite;
    
    public Reservacion(int idU, int idA, int idR, String reserva, String limite){
        idUsuario = idU;
        idAuto = idA;
        idReservacion = idR;
        horaReservacion = reserva;
        horaLimite = limite;
    }
    
    public String getHoraReservacion(){
        return horaReservacion;
    }
    
    public String getHoraLimite(){
        return horaLimite;
    }
    
}