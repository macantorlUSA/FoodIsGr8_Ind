package co.usa.mintic.ciclo4.foodisgr8.controlador.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import co.usa.mintic.ciclo4.foodisgr8.R;

public class ActivitySplash extends AppCompatActivity implements Runnable {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ImageView logo = findViewById(R.id.imgMainLogo);
        logo.setImageDrawable(getResources().getDrawable(R.drawable.isgr8));
        new Thread(this).start();
    }

    @Override
    public void run() {
        try {
            Thread.sleep(5000);
            Intent screenChange = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(screenChange);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}