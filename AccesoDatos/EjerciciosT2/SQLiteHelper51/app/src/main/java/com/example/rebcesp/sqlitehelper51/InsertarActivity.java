package com.example.rebcesp.sqlitehelper51;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.rebcesp.sqlitehelper51.Data.DataSource;
import com.example.rebcesp.sqlitehelper51.Model.Ciudad;

public class InsertarActivity extends AppCompatActivity {

    Button btnInsertar;
    EditText Nciudad, Nprovincia, Nhabitantes;
    DataSource accesoDB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insertar);

        btnInsertar = (Button)findViewById(R.id.btnGuardar);
        Nciudad = (EditText)findViewById(R.id.nombreCiudad);
        Nprovincia = (EditText)findViewById(R.id.nombreProvincia);
        Nhabitantes = (EditText)findViewById(R.id.numeroHabitantes);

        accesoDB = new DataSource(getApplicationContext());


        btnInsertar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertarCiudad();
            }
        });
    }

    private void insertarCiudad() {

       String nombre = Nciudad.getText().toString();
       String provincia = Nprovincia.getText().toString();
       String habitantes = Nhabitantes.getText().toString();

       try{

           long numerohabitantes = Long.parseLong(habitantes);

           if (provincia.isEmpty() || nombre.isEmpty()){
               Toast.makeText(this, "Inserta el nombre y la provincia", Toast.LENGTH_SHORT).show();
           }else{

               Ciudad nuevaCiudad = new Ciudad(-1,nombre,provincia,numerohabitantes);
               accesoDB.insertar(nuevaCiudad);


           }
       }catch(NumberFormatException e){
           Toast.makeText(this, "Solo se acepta numeros", Toast.LENGTH_SHORT).show();


       }

    }
}
