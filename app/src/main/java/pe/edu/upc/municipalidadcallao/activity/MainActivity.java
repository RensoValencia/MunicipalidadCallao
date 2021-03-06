package pe.edu.upc.municipalidadcallao.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.google.firebase.auth.FirebaseAuth;

import pe.edu.upc.municipalidadcallao.R;
import pe.edu.upc.municipalidadcallao.fragment.CambiarClaveFragment;
import pe.edu.upc.municipalidadcallao.fragment.DeclaracionFragment;
import pe.edu.upc.municipalidadcallao.fragment.EditarDatosFragment;
import pe.edu.upc.municipalidadcallao.fragment.ListadoCarrosFragment;
import pe.edu.upc.municipalidadcallao.fragment.ManualUsuarioFragment;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, EditarDatosFragment.OnFragmentInteractionListener,
        ListadoCarrosFragment.OnFragmentInteractionListener, ManualUsuarioFragment.OnFragmentInteractionListener,
        CambiarClaveFragment.OnFragmentInteractionListener, DeclaracionFragment.OnFragmentInteractionListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        Fragment fragment = null;
        Boolean fragmentSeleccionado = false;

        if (id == R.id.navEditarUsuario) {
            fragment = new EditarDatosFragment();
            fragmentSeleccionado = true;
        } else if (id == R.id.navCrearDeclaracion) {
            fragment = new DeclaracionFragment();
            fragmentSeleccionado = true;
        } else if (id == R.id.navCarros) {
            fragment = new ListadoCarrosFragment();
            fragmentSeleccionado = true;
        } else if (id == R.id.navCompartir) {

        } else if(id == R.id.navManual) {
            fragment = new ManualUsuarioFragment();
            fragmentSeleccionado = true;
        } else if(id == R.id.navCambiarClave) {
            fragment = new CambiarClaveFragment();
            fragmentSeleccionado = true;
        } else if(id == R.id.navSalir) {
            FirebaseAuth.getInstance().signOut();
            cerrarSesion();
        }

        if(fragmentSeleccionado) {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction().replace(R.id.contenedor, fragment);
            transaction.commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void cerrarSesion() {
        Intent iconIntent = new Intent(this, LoginActivity.class);
        this.startActivity(iconIntent);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}