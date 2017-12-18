package pe.edu.upc.municipalidadcallao.adapter;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import pe.edu.upc.municipalidadcallao.activity.DetalleCarroActivity;
import pe.edu.upc.municipalidadcallao.R;
import pe.edu.upc.municipalidadcallao.pojos.Carro;
import pe.edu.upc.municipalidadcallao.serviciorestFull.Vehiculo;

/**
 * Created by RENSO on 12/11/2017.
 */

public class CarroAdapter extends RecyclerView.Adapter<CarroAdapter.ViewHolder> {



    List<pe.edu.upc.municipalidadcallao.servicioRestFullMuniErp.Vehiculo> carros;
    public void setPeople(List<pe.edu.upc.municipalidadcallao.servicioRestFullMuniErp.Vehiculo> carros) {
        this.carros = carros;
    }

    public CarroAdapter(List<pe.edu.upc.municipalidadcallao.servicioRestFullMuniErp.Vehiculo> items) {
        this.carros = items;
    }

    @Override
    public CarroAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(
                LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.card_person, parent, false));
    }
    @Override
    public void onBindViewHolder(CarroAdapter.ViewHolder holder, final int i) {
        //holder.pictureImageView.setImageResource(carros.get(position).getImagen());
        holder.tvPlaca.setText(carros.get(i).getPlaca());
        holder.tvMarca.setText(carros.get(i).getMarca());
        holder.tvModelo.setText(carros.get(i).getModelo());
        holder.personCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putString("placa", carros.get(i).getPlaca());
                bundle.putString("marca", carros.get(i).getMarca());
                bundle.putString("modelo", carros.get(i).getModelo());
                bundle.putString("categoria", carros.get(i).getCategoria());
                bundle.putString("anioFabricacion", carros.get(i).getAnioFabricacion());
                bundle.putString("fecRegPub", carros.get(i).getFechaRegistroPublico());
                bundle.putString("provincia", carros.get(i).getProvincia());

                Intent iconIntent = new Intent(view.getContext(), DetalleCarroActivity.class);
                iconIntent.putExtras(bundle);
                view.getContext().startActivity(iconIntent);
            }
        });
    }
    @Override
    public int getItemCount() {
        return carros.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        CardView personCardView;
        ImageView pictureImageView;
        TextView tvPlaca;
        TextView tvMarca;
        TextView tvModelo;
        public ViewHolder(View itemView) {
            super(itemView);
            personCardView = (CardView) itemView.findViewById(R.id.personCardView);
            pictureImageView = (ImageView) itemView.findViewById(R.id.pictureImageView);
            tvPlaca = (TextView) itemView.findViewById(R.id.tvPlaca);
            tvMarca = (TextView) itemView.findViewById(R.id.tvMarca);
            tvModelo = (TextView) itemView.findViewById(R.id.tvModelo);
        }
    }
}