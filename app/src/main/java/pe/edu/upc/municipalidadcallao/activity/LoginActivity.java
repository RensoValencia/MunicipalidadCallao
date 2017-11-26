package pe.edu.upc.municipalidadcallao.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import pe.edu.upc.municipalidadcallao.R;

public class LoginActivity extends AppCompatActivity {

    Button btnLogin;
    Button btnRegistrarse;
    Button btnSalir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnLogin = (Button) findViewById(R.id.btnLogin);
        btnRegistrarse = (Button) findViewById(R.id.btnRegistrarse);
        btnSalir = (Button) findViewById(R.id.btnSalir);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent iconIntent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(iconIntent);
            }
        });

        btnRegistrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent iconIntent = new Intent(LoginActivity.this, RegistroActivity.class);
                startActivity(iconIntent);
            }
        });

        btnSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
