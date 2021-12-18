package co.usa.mintic.ciclo4.foodisgr8.modelo.bd;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import co.usa.mintic.ciclo4.foodisgr8.R;
import co.usa.mintic.ciclo4.foodisgr8.modelo.objetos.ProductItem;
import co.usa.mintic.ciclo4.foodisgr8.modelo.objetos.ServiceItem;
import co.usa.mintic.ciclo4.foodisgr8.modelo.objetos.StoreItem;

public class ConectorBD extends SQLiteOpenHelper {

    Context context;

    public ConectorBD(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        createTables(db);
    }

    private void createTables(SQLiteDatabase db) {
       db.execSQL("CREATE TABLE tblFavorites(id INT, titulo TEXT,descripcion TEXT, image BLOB)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table tblFavorites");
        onCreate(db);
    }
}
