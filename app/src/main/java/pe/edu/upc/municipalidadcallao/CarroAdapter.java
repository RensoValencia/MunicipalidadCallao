package pe.edu.upc.municipalidadcallao;

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

/**
 * Created by RENSO on 12/11/2017.
 */

public class CarroAdapter extends RecyclerView.Adapter<CarroAdapter.ViewHolder> {

    List<Carro> carros;
    public void setPeople(List<Carro> carros) {
        this.carros = carros;
    }

    @Override
    public CarroAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(
                LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.card_person, parent, false));
    }
    @Override
    public void onBindViewHolder(CarroAdapter.ViewHolder holder, final int position) {
        holder.pictureImageView.setImageResource(carros.get(position).getImagen());
        holder.tvPlaca.setText(carros.get(position).getPlaca());
        holder.tvMarca.setText(carros.get(position).getMarca());
        holder.tvModelo.setText(carros.get(position).getModelo());
        holder.personCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putInt("currentPosition", position);
                Intent iconIntent = new Intent(view.getContext(), DetalleCarro.class);
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
