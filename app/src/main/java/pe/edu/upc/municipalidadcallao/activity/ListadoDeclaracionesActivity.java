package pe.edu.upc.municipalidadcallao.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import java.util.List;

import pe.edu.upc.municipalidadcallao.R;
import pe.edu.upc.municipalidadcallao.adapter.DeclaracionAdapter;
import pe.edu.upc.municipalidadcallao.pojos.Declaracion;
import pe.edu.upc.municipalidadcallao.service.DeclaracionService;

public class ListadoDeclaracionesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado_declaraciones);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        List<Declaracion> declaraciones;
        RecyclerView.LayoutManager peopleLayoutManager;
        RecyclerView peopleRecyclerView;
        DeclaracionAdapter peopleAdapter;

        DeclaracionService service = new DeclaracionService(this);
        declaraciones = service.getDeclaraciones();
        peopleLayoutManager = new LinearLayoutManager(this);
        peopleAdapter = new DeclaracionAdapter();
        peopleAdapter.setDeclaraciones(declaraciones);
        peopleRecyclerView = (RecyclerView) findViewById(R.id.declaracionRecyclerView);
        peopleRecyclerView.setLayoutManager(peopleLayoutManager);
        peopleRecyclerView.setAdapter(peopleAdapter);

    }
}