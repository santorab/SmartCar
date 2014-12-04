package com.example.rodrigo.smartcar;

public class Auto {
    
    public int idAuto;
    public String marca;
    public String modelo;
    public String placas;
    public String bateria;
    public String latitud;
    public String longitud;
    public String estado;
    
    public Auto(int idCar, String brand, String model, String plates, String energy, String lat, String longi){
        idAuto = idCar;
        marca = brand;
        modelo = model;
        placas = plates;
        bateria = energy;
        latitud = lat;
        longitud = longi;

    }



    public String getMarca(){
        return marca;
    }
    
    public String getModelo(){
        return modelo;
    }
    
    public String getPlacas(){
        return placas;
    }
    
    public String getBateria(){
        return bateria;
    }
    
    public String getLatitud(){
        return latitud;
    }
    
    public String getLongitud(){
        return longitud;
    }
}