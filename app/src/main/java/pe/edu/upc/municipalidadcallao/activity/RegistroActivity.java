package pe.edu.upc.municipalidadcallao.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import pe.edu.upc.municipalidadcallao.R;

public class RegistroActivity extends AppCompatActivity {

    Spinner distrito;
    Button btnSalir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        distrito = (Spinner) findViewById(R.id.spDistrito);
        btnSalir = (Button) findViewById(R.id.btnSalir);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this, R.array.distritos, android.R.layout.simple_spinner_item);

        distrito.setAdapter(adapter);

        btnSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
