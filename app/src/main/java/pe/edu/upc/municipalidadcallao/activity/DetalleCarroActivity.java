package pe.edu.upc.municipalidadcallao.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import pe.edu.upc.municipalidadcallao.R;
import pe.edu.upc.municipalidadcallao.pojos.Carro;
import pe.edu.upc.municipalidadcallao.service.CarroService;
import pe.edu.upc.municipalidadcallao.servicioRestFullMuniErp.Vehiculo;

public class DetalleCarroActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_carro);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ImageView pictureImageView;
        TextView placaTextView;
        TextView marcaTextView;
        TextView modeloTextView;
        TextView categoriaTextView;
        Button btnListadoDeclaracion;
        Button btnEstadoCuenta;
        Button btnRegresar;

        placaTextView = (TextView) findViewById(R.id.tvPlaca);
        marcaTextView = (TextView) findViewById(R.id.tvMarca);
        modeloTextView = (TextView) findViewById(R.id.tvModelo);
        categoriaTextView = (TextView) findViewById(R.id.tvCategoria);
        pictureImageView = (ImageView) findViewById(R.id.pictureImageView);
        btnListadoDeclaracion = (Button) findViewById(R.id.btnListadoDeclaracion);
        btnEstadoCuenta = (Button) findViewById(R.id.btnEstadoCuenta);
        btnRegresar = (Button) findViewById(R.id.btnRegresar);

        CarroService service = new CarroService(this);
        /*Vehiculo carro =
                service.getCarros().get(getIntent().getExtras().getInt("currentPosition"));*/
        placaTextView.setText(getIntent().getExtras().getString("placa"));
        marcaTextView.setText(getIntent().getExtras().getString("marca"));
        modeloTextView.setText(getIntent().getExtras().getString("modelo"));
        categoriaTextView.setText(getIntent().getExtras().getString("categoria"));
        //categoriaTextView.setText(getIntent().getExtras().getString("categoria"));
        //pictureImageView.setImageResource(carro.getImagen());

        btnListadoDeclaracion.setOnClickListener(this);
        btnEstadoCuenta.setOnClickListener(this);
        btnRegresar.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        Intent iconIntent = null;

        switch (view.getId()) {
            case R.id.btnListadoDeclaracion:
                iconIntent = new Intent(DetalleCarroActivity.this, ListadoDeclaracionesActivity.class);
                startActivity(iconIntent);
                break;
            case R.id.btnEstadoCuenta:
                 iconIntent = new Intent(DetalleCarroActivity.this, EstadoCuentaActivity.class);
                startActivity(iconIntent);
                break;
            case R.id.btnRegresar:
                onBackPressed();
                break;
        }
    }
}