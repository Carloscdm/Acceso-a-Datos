package com.example.rebcesp.sqlitehelper51;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.rebcesp.sqlitehelper51.Data.DataSource;
import com.example.rebcesp.sqlitehelper51.Model.Ciudad;

import java.util.ArrayList;
import java.util.List;

public class ListaCiudades extends AppCompatActivity {

    RecyclerView recyclerView;
    DataSource dataSource;
    private List<Ciudad> listaciudades;
    private CiudadesAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_ciudades);

        recyclerView = findViewById(R.id.recyclerView);

        dataSource = new DataSource(getApplicationContext());

        listaciudades = new ArrayList<>();

        recyclerView.setLayoutManager(new LinearLayoutManager(this));



    }

    @Override
    protected void onResume() {
        super.onResume();
        if(adapter == null) {
            adapter = new CiudadesAdapter(listaciudades, this);
            recyclerView.setAdapter(adapter);
        }
        else {
            listaciudades.clear();

        }
        listaciudades.addAll(dataSource.leerCiudades());
        adapter.notifyDataSetChanged();


    }
}
