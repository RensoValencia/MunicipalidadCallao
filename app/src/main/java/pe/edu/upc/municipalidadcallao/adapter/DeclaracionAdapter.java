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

import pe.edu.upc.municipalidadcallao.activity.DetalleDeclaracionActivity;
import pe.edu.upc.municipalidadcallao.R;
import pe.edu.upc.municipalidadcallao.pojos.Declaracion;

/**
 * Created by RENSO on 12/11/2017.
 */

public class DeclaracionAdapter extends RecyclerView.Adapter<DeclaracionAdapter.ViewHolder>{

    List<pe.edu.upc.municipalidadcallao.servicioRestFullMuniErp.Declaracion> declaraciones;
    public void setDeclaraciones(List<pe.edu.upc.municipalidadcallao.servicioRestFullMuniErp.Declaracion> declaraciones) {
        this.declaraciones = declaraciones;
    }

    public DeclaracionAdapter(List<pe.edu.upc.municipalidadcallao.servicioRestFullMuniErp.Declaracion> declaraciones) {
        this.declaraciones = declaraciones;
    }

    @Override
    public DeclaracionAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new DeclaracionAdapter.ViewHolder(
                LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.card_declaracion, parent, false));
    }
    @Override
    public void onBindViewHolder(DeclaracionAdapter.ViewHolder holder, final int i) {
        //holder.pictureImageView.setImageResource(declaraciones.get(position).getImagen());
       // holder.tvCarro.setText(declaraciones.get(position).getCarro());
       // holder.tvUsuario.setText(declaraciones.get(position).getUsuario());
        holder.tvPorcentaje.setText(declaraciones.get(i).getPorcentaje());
        holder.tvBaseImponible.setText(declaraciones.get(i).getBaseImponible());
        holder.tvImpuesto.setText(declaraciones.get(i).getImpuesto());
        holder.tvFechaDeclaracion.setText(declaraciones.get(i).getFechaDeclaracion());
        holder.tvAfectoDesde.setText(declaraciones.get(i).getAfectoDesde());
        holder.personCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putString("carro", "ABC123, MODELO, MARCA");
                bundle.putString("usuario", "Renso Valencia Ventura");
                bundle.putString("porcentaje", declaraciones.get(i).getPorcentaje());
                bundle.putString("baseImponible", declaraciones.get(i).getBaseImponible());
                bundle.putString("impuesto", declaraciones.get(i).getImpuesto());
                bundle.putString("fechaDeclaracion", declaraciones.get(i).getFechaDeclaracion());
                bundle.putString("afectoDesde", declaraciones.get(i).getAfectoDesde());


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