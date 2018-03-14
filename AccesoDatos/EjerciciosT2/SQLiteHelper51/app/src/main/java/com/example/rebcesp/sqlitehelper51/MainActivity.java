package com.example.rebcesp.sqlitehelper51;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button addCiudad;
    Button listaCiudades;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        addCiudad = findViewById(R.id.btnAdd);
        listaCiudades = findViewById(R.id.btnLista);

        addCiudad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                irInsertarActivity();
            }
        });

        listaCiudades.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verCiudades();
            }
        });
    }

    private void verCiudades() {

        Intent i = new Intent(MainActivity.this,ListaCiudades.class);
        startActivity(i);
    }

    private void irInsertarActivity() {
        Intent i = new Intent(MainActivity.this,InsertarActivity.class);
        startActivity(i);
    }


}
