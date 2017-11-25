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

public class DeclaracionAdapter extends RecyclerView.Adapter<DeclaracionAdapter.ViewHolder>{

    List<Declaracion> declaraciones;
    public void setDeclaraciones(List<Declaracion> declaraciones) {
        this.declaraciones = declaraciones;
    }

    @Override
    public DeclaracionAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new DeclaracionAdapter.ViewHolder(
                LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.card_declaracion, parent, false));
    }
    @Override
    public void onBindViewHolder(DeclaracionAdapter.ViewHolder holder, final int position) {
        holder.pictureImageView.setImageResource(declaraciones.get(position).getImagen());
        holder.tvCarro.setText(declaraciones.get(position).getCarro());
        holder.tvUsuario.setText(declaraciones.get(position).getUsuario());
        holder.tvPorcentaje.setText(declaraciones.get(position).getPorcentaje());
        holder.tvBaseImponible.setText(declaraciones.get(position).getBaseImponible());
        holder.tvImpuesto.setText(declaraciones.get(position).getImpuesto());
        holder.tvFechaDeclaracion.setText(declaraciones.get(position).getFechaDeclaracion());
        holder.tvAfectoDesde.setText(declaraciones.get(position).getAfectoDesde());
        holder.personCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putInt("currentPosition", position);
                Intent iconIntent = new Intent(view.getContext(), DetalleDeclaracionActivity.class);
                iconIntent.putExtras(bundle);
                view.getContext().startActivity(iconIntent);
            }
        });
    }
    @Override
    public int getItemCount() {
        return declaraciones.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        CardView personCardView;
        ImageView pictureImageView;
        TextView tvCarro;
        TextView tvUsuario;
        TextView tvPorcentaje;
        TextView tvBaseImponible;
        TextView tvImpuesto;
        TextView tvFechaDeclaracion;
        TextView tvAfectoDesde;

        public ViewHolder(View itemView) {
            super(itemView);
            personCardView = (CardView) itemView.findViewById(R.id.declaracionCardView);
            pictureImageView = (ImageView) itemView.findViewById(R.id.pictureImageView);
            tvCarro = (TextView) itemView.findViewById(R.id.tvCarro);
            tvUsuario = (TextView) itemView.findViewById(R.id.tvUsuario);
            tvPorcentaje = (TextView) itemView.findViewById(R.id.tvPorcentaje);
            tvBaseImponible = (TextView) itemView.findViewById(R.id.tvBaseImponible);
            tvImpuesto = (TextView) itemView.findViewById(R.id.tvImpuesto);
            tvFechaDeclaracion = (TextView) itemView.findViewById(R.id.tvFechaDeclaracion);
            tvAfectoDesde = (TextView) itemView.findViewById(R.id.tvAfectoDesde);
        }
    }
}