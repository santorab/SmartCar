package com.example.rodrigo.smartcar;

public class Renta {
    
    int idUsuario;
    int idAuto;
    int idReservacion;
    String tiempo;
    double costo;
    
    public Renta(int idU, int idA, int idR, String time, double cost){
        idUsuario = idU;
        idAuto = idA;
        idReservacion = idR;
        tiempo = time;
        costo = cost;
    }
    
    public String getTiempo(){
        return tiempo;
    }
    
    public double getCosto(){
        return costo;
    }
    
}