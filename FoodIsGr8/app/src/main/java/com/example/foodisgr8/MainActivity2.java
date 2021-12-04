package com.example.foodisgr8;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    private ActionBar actionBar;
    Drawable drawable1, drawable2, drawable3, drawable4, drawable5;
    ImageView imagen1, imagen2, imagen3, imagen4, imagen5;
    Button boton1,back;
    Intent pasarPantalla;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        //------------------------------------------------------------------------------------------

        actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setIcon(R.mipmap.logo_foreground);
        actionBar.setTitle("Productos");

        //------------------------------------------------------------------------------------------
        Resources res1 = getResources();
        drawable1 = res1.getDrawable(R.drawable.isgr8, getTheme());

        imagen1 = (ImageView) findViewById(R.id.imageProd1);
        imagen1.setImageDrawable(drawable1);

        //------------------------------------------------------------------------------------------

        Resources res2 = getResources();
        drawable2 = res2.getDrawable(R.drawable.isgr8, getTheme());

        imagen2 = (ImageView) findViewById(R.id.imageProd2);
        imagen2.setImageDrawable(drawable2);

        //------------------------------------------------------------------------------------------

        Resources res3 = getResources();
        drawable3 = res3.getDrawable(R.drawable.isgr8, getTheme());

        imagen3 = (ImageView) findViewById(R.id.imageProd3);
        imagen3.setImageDrawable(drawable3);

        //------------------------------------------------------------------------------------------

        Resources res4 = getResources();
        drawable4 = res4.getDrawable(R.drawable.isgr8, getTheme());

        imagen4 = (ImageView) findViewById(R.id.imageProd4);
        imagen4.setImageDrawable(drawable4);

        //------------------------------------------------------------------------------------------

        Resources res5 = getResources();
        drawable5 = res5.getDrawable(R.drawable.isgr8, getTheme());

        imagen5 = (ImageView) findViewById(R.id.imageProd5);
        imagen5.setImageDrawable(drawable5);

        //------------------------------------------------------------------------------------------
        boton1 = (Button) findViewById(R.id.boton1);
        boton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Proximamente podrá deslizarse por el menú de productos", Toast.LENGTH_LONG).show();
            }
        });

        //------------------------------------------------------------------------------------------
        back = (Button) findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pasarPantalla = new Intent(getApplicationContext(), MainActivity.class);

                startActivity(pasarPantalla);
            }
        });
    }
}