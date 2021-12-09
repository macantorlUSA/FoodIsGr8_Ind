package co.usa.mintic.ciclo4.foodisgr8.controlador.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import androidx.fragment.app.Fragment;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;

import co.usa.mintic.ciclo4.foodisgr8.controlador.fragments.FragmentFavorites;
import co.usa.mintic.ciclo4.foodisgr8.controlador.fragments.FragmentHome;
import co.usa.mintic.ciclo4.foodisgr8.controlador.fragments.FragmentMenu;
import co.usa.mintic.ciclo4.foodisgr8.controlador.fragments.FragmentServices;
import co.usa.mintic.ciclo4.foodisgr8.controlador.fragments.FragmentStores;
import co.usa.mintic.ciclo4.foodisgr8.R;
import co.usa.mintic.ciclo4.foodisgr8.modelo.bd.ConectorBD;
import co.usa.mintic.ciclo4.foodisgr8.modelo.objetos.ProductItem;
import co.usa.mintic.ciclo4.foodisgr8.modelo.objetos.ServiceItem;
import co.usa.mintic.ciclo4.foodisgr8.modelo.objetos.StoreItem;

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

    /**
     * Conector a la Base de Datos SQLite
     */
    ConectorBD conector;

    /**
     * Permite consultar la Base de Datos
     */
    SQLiteDatabase consultor;

    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_main);
        actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setIcon(R.mipmap.logo_round);
        conector = new ConectorBD(this, "DBFoodIsGr8", null, 1);
        consultor = conector.getReadableDatabase();
        frmMenu = new FragmentMenu(obtenerProductos());
        frmHome = new FragmentHome();
        frmServices = new FragmentServices(obtenerServicios());
        frmStores = new FragmentStores(obtenerTiendas());
        frmFavorites = new FragmentFavorites();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();
        if (itemId == R.id.btnHome) {
            Toast.makeText(this, "Cargando Pantalla Inicial...", Toast.LENGTH_SHORT).show();
            getSupportFragmentManager().beginTransaction().replace(R.id.frmContainer, frmHome).commit();
        } else if (itemId == R.id.itmMenu) {
            Toast.makeText(this, "Cargando Menú...", Toast.LENGTH_SHORT).show();
            getSupportFragmentManager().beginTransaction().replace(R.id.frmContainer, frmMenu).commit();
        } else if (itemId == R.id.itmServices) {
            Toast.makeText(this, "Cargando Servicios...", Toast.LENGTH_SHORT).show();
            getSupportFragmentManager().beginTransaction().replace(R.id.frmContainer, frmServices).commit();
        } else if (itemId == R.id.itmStores) {
            Toast.makeText(this, "Cargando Sucursales...", Toast.LENGTH_SHORT).show();
            getSupportFragmentManager().beginTransaction().replace(R.id.frmContainer, frmStores).commit();
        } else if (itemId == R.id.btnFavorites) {
            Toast.makeText(this, "Módulo FAVORITOS disponible próximamente", Toast.LENGTH_SHORT).show();
            getSupportFragmentManager().beginTransaction().replace(R.id.frmContainer, frmFavorites).commit();
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * Consulta la Base de Datos para obtener los productos disponibles
     *
     * @return Lista de registros en la Base de Datos
     */
    private ArrayList<ProductItem> obtenerProductos() {
        ArrayList<ProductItem> returnValue = new ArrayList<ProductItem>();
        Cursor cursor = consultor.rawQuery("SELECT * FROM tblProducts", null);
        while (cursor.moveToNext()) {
            returnValue.add(new ProductItem(cursor.getInt(0), cursor.getString(1), cursor.getString(2)));
        }
        return returnValue;
    }

    /**
     * Consulta la Base de Datos para obtener los servicios disponibles
     *
     * @return Lista de registros en la Base de Datos
     */
    private ArrayList<ServiceItem> obtenerServicios() {
        ArrayList<ServiceItem> returnValue = new ArrayList<ServiceItem>();
        Cursor cursor = consultor.rawQuery("SELECT * FROM tblServices", null);
        while (cursor.moveToNext()) {
            returnValue.add(new ServiceItem(cursor.getString(0), cursor.getString(1)));
        }
        return returnValue;
    }

    /**
     * Consulta la Base de Datos para obtener las tiendas disponibles
     *
     * @return Lista de registros en la Base de Datos
     */
    private ArrayList<StoreItem> obtenerTiendas() {
        ArrayList<StoreItem> returnValue = new ArrayList<StoreItem>();
        Cursor cursor = consultor.rawQuery("SELECT * FROM tblStores", null);
        while (cursor.moveToNext()) {
            returnValue.add(new StoreItem(cursor.getString(0), cursor.getString(1)));
        }
        return returnValue;
    }
}