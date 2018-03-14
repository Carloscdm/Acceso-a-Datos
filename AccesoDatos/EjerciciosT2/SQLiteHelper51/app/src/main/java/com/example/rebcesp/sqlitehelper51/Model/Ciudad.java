package com.example.rebcesp.sqlitehelper51.Model;

import java.io.Serializable;

/**
 * "JAVABEAN" Constructor y get and setters
 * Created by Rebcesp on 19/02/2018.
 */

public class Ciudad implements Serializable {
    private long id;
    private String nombre;
    private String provincia;
    private long habitantes;


    public Ciudad(long id, String nombre, String provincia, long habitantes) {
        this.id=id;
        this.nombre = nombre;
        this.provincia = provincia;
        this.habitantes = habitantes;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public long getHabitantes() {
        return habitantes;
    }

    public void setHabitantes(long habitantes) {
        this.habitantes = habitantes;
    }

    public long getId() {
        return id;
    }



}
