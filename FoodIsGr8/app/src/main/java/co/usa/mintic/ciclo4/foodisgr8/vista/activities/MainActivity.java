package co.usa.mintic.ciclo4.foodisgr8.vista.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import co.usa.mintic.ciclo4.foodisgr8.vista.fragments.FragmentFavorites;
import co.usa.mintic.ciclo4.foodisgr8.vista.fragments.FragmentHome;
import co.usa.mintic.ciclo4.foodisgr8.vista.fragments.FragmentMenu;
import co.usa.mintic.ciclo4.foodisgr8.vista.fragments.FragmentServices;
import co.usa.mintic.ciclo4.foodisgr8.vista.fragments.FragmentStores;
import co.usa.mintic.ciclo4.foodisgr8.R;

/**
 * @author Miguel Cantor L.
 */
public class MainActivity extends AppCompatActivity {

    /**
     * Barra de Menú Principal
     */
    ActionBar actionBar;

    /**
     * Fragment Principal
     */
    Fragment frmHome;

    /**
     * Fragment Menú
     */
    Fragment frmMenu;

    /**
     * Fragment Servicios
     */
    Fragment frmServices;

    /**
     * Fragment Tiendas
     */
    Fragment frmStores;

    /**
     * Fragment Favoritos
     */
    Fragment frmFavorites;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setIcon(R.mipmap.logo_round);
        frmMenu = new FragmentMenu();
        frmHome = new FragmentHome();
        frmServices = new FragmentServices();
        frmStores = new FragmentStores();
        frmFavorites=new FragmentFavorites();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.btnHome) {
            Toast.makeText(this, "Cargando Pantalla Inicial...", Toast.LENGTH_SHORT).show();
            getSupportFragmentManager().beginTransaction().replace(R.id.frmContainer, frmHome).commit();
        } else if (id == R.id.itmMenu) {
            Toast.makeText(this, "Cargando Menú...", Toast.LENGTH_SHORT).show();
            getSupportFragmentManager().beginTransaction().replace(R.id.frmContainer, frmMenu).commit();
        } else if (id == R.id.itmServices) {
            Toast.makeText(this, "Cargando Servicios...", Toast.LENGTH_SHORT).show();
            getSupportFragmentManager().beginTransaction().replace(R.id.frmContainer, frmServices).commit();
        } else if (id == R.id.itmStores) {
            Toast.makeText(this, "Cargando Sucursales...", Toast.LENGTH_SHORT).show();
            getSupportFragmentManager().beginTransaction().replace(R.id.frmContainer, frmStores).commit();
        } else if (id == R.id.btnFavorites) {
            Toast.makeText(this, "Módulo FAVORITOS disponible próximamente", Toast.LENGTH_SHORT).show();
            getSupportFragmentManager().beginTransaction().replace(R.id.frmContainer, frmFavorites).commit();
        }
        return super.onOptionsItemSelected(item);
    }
}