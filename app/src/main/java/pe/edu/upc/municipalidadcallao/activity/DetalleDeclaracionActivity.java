package pe.edu.upc.municipalidadcallao.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import pe.edu.upc.municipalidadcallao.R;
import pe.edu.upc.municipalidadcallao.pojos.Declaracion;
import pe.edu.upc.municipalidadcallao.service.DeclaracionService;

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
        /*Declaracion declaracion =
                service.getDeclaraciones().get(getIntent().getExtras().getInt("currentPosition"));*/
        carroTextView.setText(getIntent().getExtras().getString("carro"));
        usuarioTextView.setText(getIntent().getExtras().getString("usuario"));
        porcentajeTextView.setText(getIntent().getExtras().getString("porcentaje"));
        baseImponible.setText(getIntent().getExtras().getString("baseImponible"));
        impuesto.setText(getIntent().getExtras().getString("impuesto"));
        fechaDeclaracion.setText(getIntent().getExtras().getString("fechaDeclaracion"));
        afectoDesde.setText(getIntent().getExtras().getString("afectoDesde"));

        //pictureImageView.setImageResource(declaracion.getImagen());

    }
}