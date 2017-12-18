package pe.edu.upc.municipalidadcallao.activity;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;
import java.util.List;

import pe.edu.upc.municipalidadcallao.R;
import pe.edu.upc.municipalidadcallao.model.MunicipalidadDbHelper;
import pe.edu.upc.municipalidadcallao.servicioRestFullMuniErp.CuentaCte;
import pe.edu.upc.municipalidadcallao.serviciorestFull.GetHttpReniec;
import pe.edu.upc.municipalidadcallao.serviciorestFull.GetHttpUsuario;
import pe.edu.upc.municipalidadcallao.utils.CustomDialog;
import pe.edu.upc.municipalidadcallao.utils.CustomInternet;
import pe.edu.upc.municipalidadcallao.utils.ToaskCustom;
import pe.edu.upc.municipalidadcallao.utils.UtilDate;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    EditText txtUsuario;
    EditText txtClave;
    Button btnLogin;
    Button btnRegistrarse;
    Button btnSalir;

    private FirebaseAuth mAuth;
    String TAG = "Logs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mAuth = FirebaseAuth.getInstance();

        MunicipalidadDbHelper db = new MunicipalidadDbHelper(LoginActivity.this);
        db.getLstCuentaCte();
        db.getLstDeclaracion();
        db.getLstUsuario();
        db.getLstVehiculo();

        txtUsuario = (EditText) findViewById(R.id.txtUsuario);
        txtClave = (EditText) findViewById(R.id.txtClave);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        btnRegistrarse = (Button) findViewById(R.id.btnRegistrarse);
        btnSalir = (Button) findViewById(R.id.btnSalir);

        btnLogin.setOnClickListener(this);
        btnRegistrarse.setOnClickListener(this);
        btnSalir.setOnClickListener(this);
    }

    private void validarAcceso() {

        /*
        String IP = "http://192.168.89.2:8080/MunicipalidadERP/webresources/";
        String INSERT = IP + "consultarUsuario";
        GetHttpUsuario reniec = new GetHttpUsuario(LoginActivity.this);
        reniec.execute(INSERT, "99998888", "gggg", "dddd", "eeee", "wwwww", "22222", "dsdsfdssd", "159159");
*/
        if(txtUsuario.getText().toString().isEmpty()) {
            CustomDialog.ShowCustomAlert("Ingrese su usuario " + UtilDate.getTotalFecha(), this);
            txtUsuario.requestFocus();
            return;
        }

        if(txtClave.getText().toString().isEmpty()) {
            CustomDialog.ShowCustomAlert("Ingrese su clave ", this);
            txtClave.requestFocus();
            return;
        }

        String email = txtUsuario.getText().toString();
        String password = txtClave.getText().toString();

        if(CustomInternet.isNetworkAvaliable(LoginActivity.this)) {
            mAuth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                Log.d(TAG, "Se ha autenticado correctamente");
                                FirebaseUser user = mAuth.getCurrentUser();
                                updateUI(user);
                            } else {
                                Log.w(TAG, "signInWithEmail:failure", task.getException());
                                Toast.makeText(LoginActivity.this, "Ha Ocurrido un error en el servicio de autenticado.",
                                        Toast.LENGTH_SHORT).show();
                                updateUI(null);
                            }
                    }
                });
        } else {
            ToaskCustom.msg(LoginActivity.this, "Entonces se loguea desde el proyect inicial");
        }

        Intent iconIntent = new Intent(this, MainActivity.class);
        this.startActivity(iconIntent);
    }

    private void updateUI(FirebaseUser user) {
        if(user != null) {
            Intent iconIntent = new Intent(this, MainActivity.class);
            this.startActivity(iconIntent);
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        updateUI(currentUser);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.btnLogin:
                validarAcceso();
                break;
            case R.id.btnRegistrarse:
                Intent iconIntent = new Intent(LoginActivity.this, RegistroActivity.class);
                startActivity(iconIntent);
                break;
            case R.id.btnSalir:
                finish();
                break;
        }
    }
}