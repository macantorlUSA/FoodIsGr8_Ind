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

public class MainActivity3 extends AppCompatActivity {

    private ActionBar actionBar;
    Drawable drawable1, drawable2, drawable3, drawable4;
    ImageView imagen1, imagen2, imagen3, imagen4;
    Button boton2,back1;
    Intent pasarPantalla1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        //------------------------------------------------------------------------------------------

        actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setIcon(R.mipmap.logo_foreground);
        actionBar.setTitle("Servicios");

        //------------------------------------------------------------------------------------------

        Resources res1 = getResources();
        drawable1 = res1.getDrawable(R.drawable.domicilo, getTheme());

        imagen1 = (ImageView) findViewById(R.id.imageServ1);
        imagen1.setImageDrawable(drawable1);

        //------------------------------------------------------------------------------------------

        Resources res2 = getResources();
        drawable2 = res2.getDrawable(R.drawable.horas, getTheme());

        imagen2 = (ImageView) findViewById(R.id.imageServ2);
        imagen2.setImageDrawable(drawable2);

        //------------------------------------------------------------------------------------------

        Resources res3 = getResources();
        drawable3 = res3.getDrawable(R.drawable.calendar, getTheme());

        imagen3 = (ImageView) findViewById(R.id.imageServ3);
        imagen3.setImageDrawable(drawable3);

        //------------------------------------------------------------------------------------------

        Resources res4 = getResources();
        drawable4 = res4.getDrawable(R.drawable.atencion, getTheme());

        imagen4 = (ImageView) findViewById(R.id.imageServ4);
        imagen4.setImageDrawable(drawable4);
    }
}