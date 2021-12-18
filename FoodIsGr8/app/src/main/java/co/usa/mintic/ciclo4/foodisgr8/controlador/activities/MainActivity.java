package co.usa.mintic.ciclo4.foodisgr8.controlador.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import androidx.fragment.app.Fragment;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.os.Bundle;
import android.util.Base64;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import co.usa.mintic.ciclo4.foodisgr8.controlador.fragments.FragmentFavorites;
import co.usa.mintic.ciclo4.foodisgr8.controlador.fragments.FragmentHome;
import co.usa.mintic.ciclo4.foodisgr8.controlador.fragments.FragmentMenu;
import co.usa.mintic.ciclo4.foodisgr8.controlador.fragments.FragmentServices;
import co.usa.mintic.ciclo4.foodisgr8.controlador.fragments.FragmentStores;
import co.usa.mintic.ciclo4.foodisgr8.R;
import co.usa.mintic.ciclo4.foodisgr8.modelo.bd.ConectorBD;
import co.usa.mintic.ciclo4.foodisgr8.modelo.objetos.FavoriteItem;
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
    FragmentFavorites frmFavorites;

    /**
     * Conector a la Base de Datos SQLite
     */
    ConectorBD conector;

    /**
     * Permite consultar la Base de Datos
     */
    SQLiteDatabase consultor;

    /**
     * Permite modificar la Base de Datos
     */
    SQLiteDatabase editor;

    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_main);
        actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setIcon(R.mipmap.logo_round);
        conector = new ConectorBD(this, "DBFoodIsGr8", null, 1);
        consultor = conector.getReadableDatabase();
        editor = conector.getWritableDatabase();
        frmMenu = new FragmentMenu(obtenerProductos(), this);
        frmHome = new FragmentHome();
        frmServices = new FragmentServices(obtenerServicios());
        frmStores = new FragmentStores(obtenerTiendas());
        frmFavorites = new FragmentFavorites(obtenerFavoritos(), this);
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
            getSupportFragmentManager().beginTransaction().replace(R.id.frmContainer, frmHome).commit();
        } else if (itemId == R.id.itmMenu) {
            getSupportFragmentManager().beginTransaction().replace(R.id.frmContainer, frmMenu).commit();
        } else if (itemId == R.id.itmServices) {
            getSupportFragmentManager().beginTransaction().replace(R.id.frmContainer, frmServices).commit();
        } else if (itemId == R.id.itmStores) {
            getSupportFragmentManager().beginTransaction().replace(R.id.frmContainer, frmStores).commit();
        } else if (itemId == R.id.btnFavorites) {
            getSupportFragmentManager().beginTransaction().replace(R.id.frmContainer, frmFavorites).commit();
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * Consulta la Base de Datos para obtener los productos disponibles
     *
     * @return Lista de registros en la Base de Datos
     */
    private List<ProductItem> obtenerProductos() {
        ArrayList<ProductItem> returnValue = new ArrayList<ProductItem>();
        String url = "https://g83f1de06147000-foodisgr8.adb.sa-santiago-1.oraclecloudapps.com/ords/admin/foodIsGr8/products";
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray jsonArray = response.getJSONArray("items");
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        byte[] img = Base64.decode(jsonObject.getString("image"), Base64.DEFAULT);
                        returnValue.add(new ProductItem(jsonObject.getInt("id"), jsonObject.getString("name"), jsonObject.getString("description"), img));
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
        requestQueue.add(jsonObjectRequest);
        return returnValue;
    }

    /**
     * Consulta la Base de Datos para obtener los servicios disponibles
     *
     * @return Lista de registros en la Base de Datos
     */
    private List<ServiceItem> obtenerServicios() {
        ArrayList<ServiceItem> returnValue = new ArrayList<ServiceItem>();
        String url = "https://g83f1de06147000-foodisgr8.adb.sa-santiago-1.oraclecloudapps.com/ords/admin/foodIsGr8/services";
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray jsonArray = response.getJSONArray("items");
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        returnValue.add(new ServiceItem(jsonObject.getString("name"), jsonObject.getString("description")));
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
        requestQueue.add(jsonObjectRequest);
        return returnValue;
    }

    /**
     * Consulta la Base de Datos para obtener las tiendas disponibles
     *
     * @return Lista de registros en la Base de Datos
     */
    private List<StoreItem> obtenerTiendas() {
        ArrayList<StoreItem> returnValue = new ArrayList<StoreItem>();
        String url = "https://g83f1de06147000-foodisgr8.adb.sa-santiago-1.oraclecloudapps.com/ords/admin/foodIsGr8/stores";
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray jsonArray = response.getJSONArray("items");
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        returnValue.add(new StoreItem(jsonObject.getString("name"), jsonObject.getString("description"), jsonObject.getDouble("lat"), jsonObject.getDouble("lon")));
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
        requestQueue.add(jsonObjectRequest);
        return returnValue;
    }

    /**
     * Consulta la Base de Datos para obtener las favoritos del usuario
     *
     * @return Lista de registros en la Base de Datos
     */
    public List<FavoriteItem> obtenerFavoritos() {
        ArrayList<FavoriteItem> returnValue = new ArrayList<FavoriteItem>();
        Cursor cursor = consultor.rawQuery("SELECT * FROM tblFavorites", null);
        while (cursor.moveToNext()) {
            returnValue.add(new FavoriteItem(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getBlob(3)));
        }
        return returnValue;
    }

    /**
     * Elimina un favorito del usuario
     *
     * @return Proceso completado con éxito.
     */
    public void eliminarFavoritos(Integer favoriteId) {
        editor.delete("tblFavorites", "id =" + favoriteId.toString(), null);
        frmFavorites.setRegistros(obtenerFavoritos());
        frmFavorites.getCreator().notifyDataSetChanged();
    }

    /**
     * Agrega un favorito del usuario
     *
     * @return Proceso completado con éxito.
     */
    public void agregarFavoritos(ProductItem item) {
        Cursor cursor = consultor.rawQuery("SELECT * FROM tblFavorites where id=" + item.getId(), null);
        if (cursor.moveToFirst()) {
            Toast.makeText(getApplicationContext(), "El producto ya esta agregado en favoritos.", Toast.LENGTH_SHORT).show();
        } else {
            String sql = "INSERT INTO tblFavorites VALUES(?,?,?,?)";
            SQLiteStatement insertQuery = editor.compileStatement(sql);
            insertQuery.clearBindings();
            insertQuery.bindLong(1, item.getId());
            insertQuery.bindString(2, item.getTitulo());
            insertQuery.bindString(3, item.getContenido());
            insertQuery.bindBlob(4, item.getImage());
            insertQuery.executeInsert();
            frmFavorites.setRegistros(obtenerFavoritos());
            frmFavorites.getCreator().notifyDataSetChanged();
        }
    }
}