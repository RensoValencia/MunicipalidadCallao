package pe.edu.upc.municipalidadcallao;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class DetalleCarro extends AppCompatActivity {

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
        Carro carro =
                service.getCarros().get(getIntent().getExtras().getInt("currentPosition"));
        placaTextView.setText(carro.getPlaca());
        marcaTextView.setText(carro.getMarca());
        modeloTextView.setText(carro.getModelo());
        categoriaTextView.setText(carro.getCategoria());
        pictureImageView.setImageResource(carro.getImagen());

        btnListadoDeclaracion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent iconIntent = new Intent(DetalleCarro.this, ListadoDeclaracionesActivity.class);
                startActivity(iconIntent);
            }
        });

        btnEstadoCuenta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent iconIntent = new Intent(DetalleCarro.this, EstadoCuentaActivity.class);
                startActivity(iconIntent);
            }
        });

        btnRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }

}
