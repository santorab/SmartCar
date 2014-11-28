package com.example.rodrigo.smartcar;

public class Usuario {
    
    public int idUsuario;
    public String nombres;
    public String apellidoP;
    public String apellidoM;
    public String telefono;
    public String correo;
    public boolean esAdmin;
    public int tarjeta;
    public int tarjetaCV;
    
    public Usuario(int idU, String nom, String apellidoPa, String apellidoMa, String phone, String email, boolean admin, int card, int cardCV){
        idUsuario = idU;
        nombres = nom;
        apellidoP = apellidoPa;
        apellidoM = apellidoMa;
        telefono = phone;
        correo = email;
        esAdmin = admin;
        tarjeta = card;
        tarjetaCV = cardCV;
    }
    
    public String getNombre(){
        return nombres;
    }
    
    public String getApellidoP(){
        return apellidoP;
    }
    
    public String getApellidoM(){
        return apellidoM;
    }
    
    public String getTelefono(){
        return telefono;
    }
    
    public String getCorreo(){
        return correo;
    }
}