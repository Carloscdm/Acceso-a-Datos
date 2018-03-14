package com.example.rebcesp.sqlitehelper51;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.rebcesp.sqlitehelper51.Data.DataSource;
import com.example.rebcesp.sqlitehelper51.Model.Ciudad;

public class DatosCiudad extends AppCompatActivity {

    EditText ciudad, provincia, habitantes;
    Button guardar, eliminar, volverAtras;

    private Ciudad datosCiudad;
    DataSource dataSource;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos_ciudad);

        dataSource = new DataSource(getApplicationContext());

        ciudad = findViewById(R.id.nombreCiudad);
        provincia = findViewById(R.id.nombreProvincia);
        habitantes = findViewById(R.id.numeroHabitantes);

        guardar = findViewById(R.id.btnGuardar);
        eliminar = findViewById(R.id.btnEliminar);
        volverAtras = findViewById(R.id.btnVolver);

        Intent i = getIntent();

        if (i != null) {

            datosCiudad = (Ciudad) i.getSerializableExtra("ciudad"); //Aqui sacamos el objeto Ciudad que llega desde el Adapter

            ciudad.setText(datosCiudad.getNombre());
            provincia.setText(datosCiudad.getProvincia());
            habitantes.setText(String.valueOf(datosCiudad.getHabitantes()));

        }

        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                guardarCiudad();
            }
        });

        eliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eliminarCiudad();

            }
        });

        volverAtras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                irAtras();

            }
        });

    }

    private void irAtras() {

        finish();
    }


    private void eliminarCiudad() {

        dataSource.borrar(datosCiudad);
        finish();


    }


    private void guardarCiudad() {
        String nombreCiudad = ciudad.getText().toString();
        String nombreProvincia = provincia.getText().toString();
        String numeroHabitantes = habitantes.getText().toString();

        try {

            long numerohabitantes = Long.parseLong(numeroHabitantes);

            if (nombreProvincia.isEmpty() || nombreCiudad.isEmpty()) {
                Toast.makeText(this, "Inserta el nombre y la provincia", Toast.LENGTH_SHORT).show();
            } else {

                datosCiudad.setNombre(nombreCiudad);
                datosCiudad.setProvincia(nombreProvincia);
                datosCiudad.setHabitantes(numerohabitantes);

                dataSource.actualizar(datosCiudad);


            }


        } catch (NumberFormatException e) {
            Toast.makeText(this, "Solo se acepta numeros", Toast.LENGTH_SHORT).show();


        }
    }
}
