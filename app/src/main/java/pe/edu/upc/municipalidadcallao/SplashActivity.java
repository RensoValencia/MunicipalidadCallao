package pe.edu.upc.municipalidadcallao;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import pe.edu.upc.municipalidadcallao.activity.LoginActivity;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        startActivity(new Intent(SplashActivity.this, LoginActivity.class));
    }
}
