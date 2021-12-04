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

public class MainActivity4 extends AppCompatActivity {

    private ActionBar actionBar;
    Drawable drawable1, drawable2, drawable3;
    ImageView imagen1, imagen2, imagen3;
    Button back2;
    Intent pasarPantalla2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        //------------------------------------------------------------------------------------------

        actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setIcon(R.mipmap.logo_foreground);
        actionBar.setTitle("Sucursales");

        //------------------------------------------------------------------------------------------

        Resources res1 = getResources();
        drawable1 = res1.getDrawable(R.drawable.iconlugar, getTheme());

        imagen1 = (ImageView) findViewById(R.id.imageSucur1);
        imagen1.setImageDrawable(drawable1);

        //------------------------------------------------------------------------------------------

        Resources res2 = getResources();
        drawable2 = res2.getDrawable(R.drawable.iconlugar, getTheme());

        imagen2 = (ImageView) findViewById(R.id.imageSucur2);
        imagen2.setImageDrawable(drawable2);

        //------------------------------------------------------------------------------------------

        Resources res3 = getResources();
        drawable3 = res3.getDrawable(R.drawable.iconlugar, getTheme());

        imagen3 = (ImageView) findViewById(R.id.imageSucur3);
        imagen3.setImageDrawable(drawable3);


        //------------------------------------------------------------------------------------------
        back2 = (Button) findViewById(R.id.back2);
        back2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pasarPantalla2 = new Intent(getApplicationContext(), MainActivity.class);

                startActivity(pasarPantalla2);
            }
        });
    }
}