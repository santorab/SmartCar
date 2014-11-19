package com.example.rodrigo.smartcar;

/**
 * Created by Rodrigo on 02/11/2014.
 */

public class Objeto {

    public  int  idObjeto;
    public int imagen;
    public String nomObjeto;
    public String descripcion;
    public float laObjeto;
    public float longObjeto;

    public Objeto(String nom, String desc)
    {
        nomObjeto=nom;
        descripcion=desc;

    }

    public String getNomObjeto()
    {
        return nomObjeto;
    }

    public String getDescripcion()
    {
        return descripcion;
    }

    public int getImagen ()
    {
        return imagen;
    }

}
