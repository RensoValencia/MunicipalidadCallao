package pe.edu.upc.municipalidadcallao.activity;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONObject;

import pe.edu.upc.municipalidadcallao.R;
import pe.edu.upc.municipalidadcallao.devazt.networking.HttpClient;
import pe.edu.upc.municipalidadcallao.devazt.networking.OnHttpRequestComplete;
import pe.edu.upc.municipalidadcallao.devazt.networking.Response;
import pe.edu.upc.municipalidadcallao.serviciorestFull.Persona;
import pe.edu.upc.municipalidadcallao.utils.CustomDialog;

public class RegistroActivity extends AppCompatActivity /*implements OnHttpRequestComplete*/{

    EditText txtDni;
    EditText txtNombre;
    EditText txtApePaterno;
    EditText txtApeMaterno;

    EditText txtCorreo;
    EditText txtClave;

    Spinner distrito;
    Button btnSalir;
    Button btnRegistrarse;

    private FirebaseAuth mAuth;
    String TAG = "Logs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        mAuth = FirebaseAuth.getInstance();

        txtDni = (EditText) findViewById(R.id.txtDni);
        txtNombre = (EditText) findViewById(R.id.txtNombre);
        txtApePaterno = (EditText) findViewById(R.id.txtApePaterno);
        txtApeMaterno = (EditText) findViewById(R.id.txtApeMaterno);

        txtCorreo = (EditText) findViewById(R.id.txtCorreo);
        txtClave = (EditText) findViewById(R.id.txtClave);

        distrito = (Spinner) findViewById(R.id.spDistrito);
        btnRegistrarse = (Button) findViewById(R.id.btnRegistrarse);
        btnSalir = (Button) findViewById(R.id.btnSalir);

        txtDni.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {


            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                if(txtDni.getText().toString().length() == 8) {

                    HttpClient client = new HttpClient(new OnHttpRequestComplete() {
                        @Override
                        public void onComplete(Response status) {
                            if(status.isSuccess()) {
                                Gson gson = new GsonBuilder().create();
                                try {
                                    JSONObject json = new JSONObject(status.getResult());
                                    Persona persona = gson.fromJson(status.getResult(), Persona.class);

                                    Toast.makeText(RegistroActivity.this, "456 - >" + persona, Toast.LENGTH_SHORT).show();

                                    txtNombre.setText(persona.getNombres());
                                    txtApePaterno.setText(persona.getApellidoPaterno());
                                    txtApeMaterno.setText(persona.getApellidoMaterno());

                                    Toast.makeText(RegistroActivity.this, status.getResult(), Toast.LENGTH_SHORT).show();
                                } catch(Exception ex) {
                                    Toast.makeText(RegistroActivity.this, "No se encontro el DNI", Toast.LENGTH_SHORT).show();
                                }

                            } else {
                                Toast.makeText(RegistroActivity.this, "No se encontro el DNI 2", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                    client.excecute("http://192.168.230.1:8080/Reniec/webresources/consultarReniec/" + txtDni.getText().toString());
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this, R.array.distritos, android.R.layout.simple_spinner_item);

        distrito.setAdapter(adapter);

        btnRegistrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registrarUsuario(view);
            }
        });

        btnSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void registrarUsuario(View v) {

        if(txtCorreo.getText().toString().isEmpty()) {
            CustomDialog.ShowCustomAlert("Ingrese el correo", this);
            txtCorreo.requestFocus();
            return;
        }

        if(txtClave.getText().toString().isEmpty()) {
            CustomDialog.ShowCustomAlert("Ingrese la clave", this);
            txtClave.requestFocus();
            return;
        }

        String email = txtCorreo.getText().toString();
        String password = txtClave.getText().toString();

        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "createUserWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "createUserWithEmail:failure", task.getException());
                            Toast.makeText(RegistroActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                            updateUI(null);
                        }
                    }
                });
    }

    private void updateUI(FirebaseUser user) {
        if(user != null) {
            Intent iconIntent = new Intent(this, MainActivity.class);
            this.startActivity(iconIntent);
        }
    }
}