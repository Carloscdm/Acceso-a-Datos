package com.example.rebcesp.sqlitehelper51.Data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static com.example.rebcesp.sqlitehelper51.Data.CiudadesContract.NOM_DB;
import static com.example.rebcesp.sqlitehelper51.Data.CiudadesContract.VERSION_DB;

/**
 * Created by Rebcesp on 19/02/2018.
 * Esta clase es la que nos permite crear la base de datos al heredar de SQLiteOpenHelper
 * Creamoss la tabla en en Oncreate extendeiendo de SQLiteOpenHelper
 */

public class CiudadesDB extends SQLiteOpenHelper {

    public CiudadesDB(Context context) {
        //Parametros que necesito para hacer la conexion
        super(context, NOM_DB, null, VERSION_DB); //Siempre el nombre y la version estan en las constantes
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE "+CiudadesContract.NOM_TABLA+" (" +
                CiudadesContract.COL_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, " +
                CiudadesContract.COL_NOMBRE+" TEXT NOT NULL, "+
                CiudadesContract.COL_PROVINCIA+" TEXT NOT NULL, "+
                CiudadesContract.COL_HABITANTES+" LONG NOT NULL)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
//        db.execSQL("DROP TABLE "+CiudadesContract.NOM_TABLA);
//        onCreate(db);

    }
}
