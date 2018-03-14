package com.example.rebcesp.sqlitehelper51;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.rebcesp.sqlitehelper51.Model.Ciudad;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by Rebcesp on 26/02/2018.
 */

public class CiudadesAdapter extends RecyclerView.Adapter<CiudadesAdapter.CiudadesViewholder> {

    private List<Ciudad> ciudades;

    private ListaCiudades activityListaCiudades;


    public CiudadesAdapter(List<Ciudad> ciudades, ListaCiudades activityListaCiudades) {
        this.ciudades = ciudades;
        this.activityListaCiudades=activityListaCiudades;

    }

    @Override
    public CiudadesViewholder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());


        //Transformar XML a JAVA
        View vistaCiudad = inflater.inflate(R.layout.ciudaditem,parent,false);
        //Cada uno de los contenedores de la vista
        CiudadesViewholder vh = new CiudadesViewholder(vistaCiudad);
        return vh;
    }

    @Override
    //Rellenamos los viewHolders
    public void onBindViewHolder(CiudadesViewholder holder, int position) {

        final Ciudad ciudadActual = ciudades.get(position);
        holder.nombreCiudad.setText(ciudadActual.getNombre());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(activityListaCiudades,DatosCiudad.class);
                i.putExtra("ciudad",ciudadActual);
                activityListaCiudades.startActivity(i);
            }
        });

    }

    @Override
    public int getItemCount() {
     //ESTE EL NUMERO DE ITEMS QUE TENGO DE CIUDADES
        return ciudades.size();
    }

    static class CiudadesViewholder extends RecyclerView.ViewHolder{

        TextView nombreCiudad;


        public CiudadesViewholder(View itemView) {

            super(itemView);
            nombreCiudad=itemView.findViewById(R.id.nombreCiudad);

        }
    }


}

