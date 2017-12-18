package pe.edu.upc.municipalidadcallao.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

import pe.edu.upc.municipalidadcallao.R;
import pe.edu.upc.municipalidadcallao.adapter.DeclaracionAdapter;
import pe.edu.upc.municipalidadcallao.model.MunicipalidadDbHelper;
import pe.edu.upc.municipalidadcallao.servicioRestFullMuniErp.Declaracion;

public class ListadoDeclaracionesActivity extends AppCompatActivity {

    List<Declaracion> declaraciones;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado_declaraciones);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        RecyclerView.LayoutManager peopleLayoutManager;
        RecyclerView peopleRecyclerView;
        DeclaracionAdapter peopleAdapter;

        declaraciones = new ArrayList<>();

        FillDeclaraciones();

        peopleRecyclerView = (RecyclerView) findViewById(R.id.declaracionRecyclerView);
        peopleRecyclerView.setHasFixedSize(true);

        // Usar un administrador para LinearLayout
        peopleLayoutManager = new LinearLayoutManager(ListadoDeclaracionesActivity.this);
        peopleRecyclerView.setLayoutManager(peopleLayoutManager);

        peopleAdapter = new DeclaracionAdapter(declaraciones);
        peopleRecyclerView.setAdapter(peopleAdapter);

    }

    private void FillDeclaraciones(){
        MunicipalidadDbHelper db = new MunicipalidadDbHelper(ListadoDeclaracionesActivity.this);
        declaraciones = db.getLstDeclaracion();
    }
}