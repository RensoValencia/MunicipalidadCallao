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

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONException;
import org.json.JSONObject;

import pe.edu.upc.municipalidadcallao.R;
import pe.edu.upc.municipalidadcallao.devazt.networking.HttpClient;
import pe.edu.upc.municipalidadcallao.devazt.networking.OnHttpRequestComplete;
import pe.edu.upc.municipalidadcallao.devazt.networking.Response;
import pe.edu.upc.municipalidadcallao.serviciorestFull.Persona;
import pe.edu.upc.municipalidadcallao.utils.CustomDialog;
import pe.edu.upc.municipalidadcallao.utils.ToaskCustom;

public class RegistroActivity extends AppCompatActivity implements View.OnClickListener{

    EditText txtDni;
    EditText txtNombre;
    EditText txtApePaterno;
    EditText txtApeMaterno;
    EditText txtDireccion;

    EditText txtCorreo;
    EditText txtTelefono;
    EditText txtClave;

    Spinner distrito;
    Button btnSalir;
    Button btnRegistrarse;

    private FirebaseAuth mAuth;
    String TAG = "Logs";
    Gson gson = new GsonBuilder().create();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        final RequestQueue que = Volley.newRequestQueue(this);
        final String URL = "http://192.168.200.1:8080/ReniecNuevo/webresources/consultarReniec/";

        mAuth = FirebaseAuth.getInstance();

        txtDni = (EditText) findViewById(R.id.txtDni);
        txtNombre = (EditText) findViewById(R.id.txtNombre);
        txtApePaterno = (EditText) findViewById(R.id.txtApePaterno);
        txtApeMaterno = (EditText) findViewById(R.id.txtApeMaterno);
        txtCorreo = (EditText) findViewById(R.id.txtCorreo);
        txtClave = (EditText) findViewById(R.id.txtClave);
        distrito = (Spinner) findViewById(R.id.spDistrito);
        txtDireccion = (EditText) findViewById(R.id.txtDireccion);
        txtTelefono = (EditText) findViewById(R.id.txtTelefono);
        btnRegistrarse = (Button) findViewById(R.id.btnRegistrarse);
        btnSalir = (Button) findViewById(R.id.btnSalir);

        txtDni.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                if(txtDni.getText().toString().length() == 8) {
                    StringRequest stringRequest = new StringRequest(Request.Method.GET, URL + txtDni.getText().toString(),
                            new com.android.volley.Response.Listener<String>() {
                                @Override
                                public void onResponse(String response) {
                                    try {
                                        JSONObject jsonObject = new JSONObject(response.toString());
                                        Persona persona = gson.fromJson(response, Persona.class);
                                        txtNombre.setText(persona.getNombres());
                                        txtApePaterno.setText(persona.getApellidoPaterno());
                                        txtApeMaterno.setText(persona.getApellidoMaterno());

                                        if(persona.getDistrito().equals("CALLAO")) {
                                            distrito.setSelection(0);
                                        } else if(persona.getDistrito().equals("SAN MIGUEL")) {
                                            distrito.setSelection(1);
                                        } else if(persona.getDistrito().equals("LA PERLA")) {
                                            distrito.setSelection(2);
                                        }

                                        txtDireccion.setText(persona.getDireccion());
                                        txtCorreo.requestFocus();

                                    } catch(JSONException ex) {
                                        ex.printStackTrace();
                                        ToaskCustom.msg(RegistroActivity.this,
                                                "Hubo un error al obtener el JSON");
                                    }
                                }
                            }, new com.android.volley.Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            ToaskCustom.msg(RegistroActivity.this, "Hubo un error al obtener los datos");
                        }
                    });
                    que.add(stringRequest);
                }
            }

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this, R.array.distritos, android.R.layout.simple_spinner_item);

        distrito.setAdapter(adapter);

        btnRegistrarse.setOnClickListener(this);
        btnSalir.setOnClickListener(this);
    }

    private void registrarUsuario(View v) {

        if(txtDni.getText().toString().isEmpty()) {

            CustomDialog.ShowCustomAlert(getString(R.string.app_msg_dni_vacio), this);
            txtDni.requestFocus();
            return;
        }

        if(txtNombre.getText().toString().isEmpty()) {
            CustomDialog.ShowCustomAlert("Ingrese su Nombre", this);
            txtNombre.requestFocus();
            return;
        }

        if(txtApePaterno.getText().toString().isEmpty()) {
            CustomDialog.ShowCustomAlert("Ingrese su Apellido paterno", this);
            txtApePaterno.requestFocus();
            return;
        }

        if(txtApeMaterno.getText().toString().isEmpty()) {
            CustomDialog.ShowCustomAlert("Ingrese su Apellido materno", this);
            txtApeMaterno.requestFocus();
            return;
        }

        if(txtDireccion.getText().toString().isEmpty()) {
            CustomDialog.ShowCustomAlert("Ingrese su Direccion", this);
            txtDireccion.requestFocus();
            return;
        }

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

        CustomDialog.ShowCustomAlert("DNI: " + txtDni.getText().toString() + "\n"+
                                               "Nombres: " + txtNombre.getText().toString() + "\n" +
                                                "Apellido paterno" + txtApePaterno.getText().toString() + "\n" +
                                                "Apellido materno: " + txtApeMaterno.getText().toString() + "\n" +
                                                "Distrito: " + distrito.getSelectedItem().toString() + "\n" +
                                                "Direccion" + txtDireccion.getText().toString() + "\n" +
                                                "Email: " + txtCorreo.getText().toString() + "\n" +
                                                "Telefono: " + txtTelefono.getText().toString() + "\n" +
                                                "Clave: " + txtClave.getText().toString(), RegistroActivity.this);

        /*
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
                });*/
    }

    private void updateUI(FirebaseUser user) {
        if(user != null) {
            Intent iconIntent = new Intent(this, MainActivity.class);
            this.startActivity(iconIntent);
        }
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.btnRegistrarse:
                registrarUsuario(view);
                break;
            case R.id.btnSalir:
                finish();
                break;
        }
    }
}