package com.example.foodisgr8;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ActionBar actionBar;
    Button Boton1;
    TextView Texto1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //------------------------------------------------------------------------------------------

        actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setIcon(R.mipmap.logo_foreground);

        //------------------------------------------------------------------------------------------

        Resources res = getResources();
        Drawable drawable = res.getDrawable(R.drawable.isgr8, getTheme());

        ImageView Imagen1 = (ImageView) findViewById(R.id.imageView2);
        Imagen1.setImageDrawable(drawable);

        Boton1 = (Button) findViewById(R.id.Boton1);
        Boton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Seleccione una opción en el menu!", Toast.LENGTH_LONG).show();
            }
        });

        Texto1 = (TextView) findViewById(R.id.Texto1);
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
        if (id==R.id.itemMenu){
            Toast.makeText(this,"Módulo MENÚ disponible próximamente", Toast.LENGTH_LONG).show();
            Intent pantallaMenu = new Intent(this, MainActivity2.class);
            startActivity(pantallaMenu);
        }
        if (id==R.id.itemServicios){
            Toast.makeText(this,"Módulo SERVICIOS disponible próximamente", Toast.LENGTH_LONG).show();
            Intent pantallaServicios = new Intent(this, MainActivity3.class);
            startActivity(pantallaServicios);
        }
        if (id==R.id.itemUbicanos){
            Toast.makeText(this,"Módulo SUCURSALES disponible próximamente", Toast.LENGTH_LONG).show();
            Intent pantallaSucursales = new Intent(this, MainActivity4.class);
            startActivity(pantallaSucursales);
        }
        if (id==R.id.favorite){
            Toast.makeText(this,"Módulo FAVORITOS disponible próximamente", Toast.LENGTH_LONG).show();
        }
        return super.onOptionsItemSelected(item);
    }
}