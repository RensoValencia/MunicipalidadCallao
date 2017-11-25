package pe.edu.upc.municipalidadcallao;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class DetalleDeclaracionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_declaracion);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ImageView pictureImageView;
        TextView carroTextView;
        TextView usuarioTextView;
        TextView porcentajeTextView;
        TextView baseImponible;

        TextView impuesto;
        TextView fechaDeclaracion;
        TextView afectoDesde;

        Button btnListadoDeclaracion;

        carroTextView = (TextView) findViewById(R.id.tvCarro);
        usuarioTextView = (TextView) findViewById(R.id.tvUsuario);
        porcentajeTextView = (TextView) findViewById(R.id.tvPorcentaje);
        baseImponible = (TextView) findViewById(R.id.tvBaseImponible);

        impuesto = (TextView) findViewById(R.id.tvImpuesto);
        fechaDeclaracion = (TextView) findViewById(R.id.tvFechaDeclaracion);
        afectoDesde = (TextView) findViewById(R.id.tvAfectoDesde);


        pictureImageView = (ImageView) findViewById(R.id.pictureImageView);
        btnListadoDeclaracion = (Button) findViewById(R.id.btnListadoDeclaracion);

        DeclaracionService service = new DeclaracionService(this);
        Declaracion declaracion =
                service.getDeclaraciones().get(getIntent().getExtras().getInt("currentPosition"));
        carroTextView.setText(declaracion.getCarro());
        usuarioTextView.setText(declaracion.getUsuario());
        porcentajeTextView.setText(declaracion.getPorcentaje());
        baseImponible.setText(declaracion.getBaseImponible());

        impuesto.setText(declaracion.getImpuesto());
        fechaDeclaracion.setText(declaracion.getFechaDeclaracion());
        afectoDesde.setText(declaracion.getAfectoDesde());

        pictureImageView.setImageResource(declaracion.getImagen());

    }

}
