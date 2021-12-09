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
        createProductsRecords(db);
        createServicesRecords(db);
        createStoresRecords(db);
    }

    private void createStoresRecords(SQLiteDatabase db) {
        for (int index = 1; index <= 10; index++) {
            db.execSQL("insert into tblStores values('" + context.getString(R.string.msgStoreName) + " No. " + index + "', '" + context.getString(R.string.msgStoreDescription) + "')");
        }
    }

    private void createServicesRecords(SQLiteDatabase db) {
        for (int index = 1; index <= 20; index++) {
            db.execSQL("insert into tblServices values('" + context.getString(R.string.msgService) + " No. " + index + "', '" + context.getString(R.string.msgServiceDescription) + "')");
        }
    }

    private void createProductsRecords(SQLiteDatabase db) {
        db.execSQL("insert into tblProducts values(" + R.drawable.prod1 + ", 'Churrasco 500 gr.','Corte grueso de chata acompañado de ensalada, pure de papa y copa de vino. Ideal para un aluerzo especial!')");
        db.execSQL("insert into tblProducts values(" + R.drawable.prod2 + ", 'Hamburguesa', 'Clásico de la comida rápida. Acompañado por papitas y gaseosa.')");
        db.execSQL("insert into tblProducts values(" + R.drawable.prod3 + ", 'Burrito', 'De mexico para el mundo, una explosión de sabores imperdible!')");
        db.execSQL("insert into tblProducts values(" + R.drawable.prod4 + ", 'Pizza de Pepperoni', 'Plan de amigos sin pizza, no es plan. No te pierdas su inigualable sabor!')");
        db.execSQL("insert into tblProducts values(" + R.drawable.prod5 + ", 'Wild HotDog', 'El perro caliente que conoces pero a un nuevo nivel!')");
        db.execSQL("insert into tblProducts values(" + R.drawable.prod6 + ", 'Pinchos', 'Simples en la presentación, pero poderosos en sazon!')");
        db.execSQL("insert into tblProducts values(" + R.drawable.prod7 + ", 'Tarta de Fresa', 'Nada mejor que terminar el día con una deliciosa tarta de fresa recién hecha por nuestro personal.')");
        db.execSQL("insert into tblProducts values(" + R.drawable.prod8 + ", 'Empanadas', 'Corte grueso de chata acompañado de ensalada, pure de papa y copa de vino. Ideal para un aluerzo especial!')");
        db.execSQL("insert into tblProducts values(" + R.drawable.prod9 + ", 'Taco', 'Corte grueso de chata acompañado de ensalada, pure de papa y copa de vino. Ideal para un aluerzo especial!')");
        db.execSQL("insert into tblProducts values(" + R.drawable.prod10 + ", 'Filet Mignon', 'Corte grueso de chata acompañado de ensalada, pure de papa y copa de vino. Ideal para un aluerzo especial!')");
        db.execSQL("insert into tblProducts values(" + R.drawable.prod11 + ", 'Cheesecake', 'Corte grueso de chata acompañado de ensalada, pure de papa y copa de vino. Ideal para un aluerzo especial!')");
        db.execSQL("insert into tblProducts values(" + R.drawable.prod12 + ", 'Limonada', 'Tenemos una amplia gama de limonadas para que pruebes y disfrutes!')");
        db.execSQL("insert into tblProducts values(" + R.drawable.prod13 + ", 'Cerveza', 'En FoodisGr8, contamos con un amplio catálogo de cervezas: Nacionales, importadas, artesanales... Para todos!')");
        db.execSQL("insert into tblProducts values(" + R.drawable.prod14 + ", 'Vinos', 'Nunca es temprano o tarde para acompañar tus comidas con una buena opa de vino.')");
        db.execSQL("insert into tblProducts values(" + R.drawable.prod15 + ", 'Sopa', 'Algo ligero? Se le tiene! Sopas hechas con receta de la abuela!')");
    }

    private void createTables(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE tblProducts(id INT, titulo TEXT,descripcion TEXT)");
        db.execSQL("CREATE TABLE tblServices(titulo TEXT,descripcion TEXT)");
        db.execSQL("CREATE TABLE tblStores(titulo TEXT,descripcion TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table tblProducts");
        db.execSQL("drop table tblServices");
        db.execSQL("drop table tblStores");
        onCreate(db);
    }
}
