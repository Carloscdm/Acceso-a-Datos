package com.example.rebcesp.sqlitehelper51.Data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.rebcesp.sqlitehelper51.Model.Ciudad;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rebcesp on 19/02/2018.
 * DATASOURCE . Es la clase donde estan los métodos de operaciones sobre la DB
 * Aqui HAREMOS LA OPERACIONES DE CRUD (INSERT,DELETE.UPDATE,READ)
 */

public class DataSource {

    private CiudadesDB db;

    public DataSource(Context contexto){

        this.db= new CiudadesDB(contexto);

    }

    public long insertar(Ciudad c){ //Long porque en la base de datos el ID tiene que soportar infinitos registros

        SQLiteDatabase dbEscritura = db.getWritableDatabase();

        ContentValues v = new ContentValues();
        //El contenedor de datos de la fila que vamos a INSERTAR

        v.put(CiudadesContract.COL_NOMBRE,c.getNombre());
        v.put(CiudadesContract.COL_PROVINCIA,c.getProvincia());
        v.put(CiudadesContract.COL_HABITANTES,c.getHabitantes());

        //Devolvemos la id que se ha generado al insertar


        long idInsertar = dbEscritura.insert(CiudadesContract.NOM_TABLA,null,v);

        return idInsertar;


    }

    public boolean actualizar(Ciudad c){

        SQLiteDatabase dbEscritura = db.getWritableDatabase();

        ContentValues v = new ContentValues();

        v.put(CiudadesContract.COL_NOMBRE,c.getNombre());
        v.put(CiudadesContract.COL_PROVINCIA,c.getProvincia());
        v.put(CiudadesContract.COL_HABITANTES,c.getHabitantes());


        int filasActualizadas = dbEscritura.update(CiudadesContract.NOM_TABLA,v,CiudadesContract.COL_ID+"="+c.getId(),null);

        if(filasActualizadas>0){ //Si es mas de 0 se han actualizado las ciudades
            return true;



        }else{

            return false;
        }



    }
    public boolean borrar(Ciudad c){

        SQLiteDatabase dbEscritura = db.getWritableDatabase();


        int filasBorradas = dbEscritura.delete(CiudadesContract.NOM_TABLA,CiudadesContract.COL_ID+"="+c.getId(),null);

        if(filasBorradas>0){
            return true;
        }else{
            return false;

        }

    }

    public List<Ciudad> leerCiudades(){

        SQLiteDatabase dbLectura = db.getReadableDatabase();

        //Consulta select para leer la tabla
        Cursor resultados = dbLectura.rawQuery("SELECT * FROM  "+CiudadesContract.NOM_TABLA,null);

        ArrayList<Ciudad>Ciudades = new ArrayList<>();


        while (resultados.moveToNext()){

            long id = resultados.getLong(resultados.getColumnIndex(CiudadesContract.COL_ID));
            String nombre = resultados.getString(resultados.getColumnIndex(CiudadesContract.COL_NOMBRE));
            String provincia = resultados.getString(resultados.getColumnIndex(CiudadesContract.COL_PROVINCIA));
            long habitantes = resultados.getLong(resultados.getColumnIndex(CiudadesContract.COL_HABITANTES));


            Ciudad ciudadRecuperada = new Ciudad(id,nombre,provincia,habitantes);

            Ciudades.add(ciudadRecuperada);


        }

        resultados.close();

        return Ciudades;


    }


    }

