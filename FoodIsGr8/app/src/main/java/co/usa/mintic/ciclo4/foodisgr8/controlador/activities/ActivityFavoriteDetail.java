package co.usa.mintic.ciclo4.foodisgr8.controlador.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import co.usa.mintic.ciclo4.foodisgr8.R;
import co.usa.mintic.ciclo4.foodisgr8.modelo.objetos.FavoriteItem;
import co.usa.mintic.ciclo4.foodisgr8.modelo.objetos.ProductItem;

public class ActivityFavoriteDetail extends AppCompatActivity {

    FavoriteItem item;
    TextView txtName;
    TextView txtDescription;
    ImageView imgProducto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite_detail);
        item = (FavoriteItem) getIntent().getSerializableExtra("item");
        if (item != null){
            txtName = findViewById(R.id.txtFavNameDetail);
            txtDescription = findViewById(R.id.txtFavDescDetail);
            imgProducto = findViewById(R.id.imgFavDetail);
            txtName.setText(item.getTitulo());
            txtDescription.setText(item.getContenido());
            Bitmap bm = BitmapFactory.decodeByteArray(item.getImage(), 0, item.getImage().length);
            imgProducto.setImageBitmap(bm);
        }
        Button btnHome = findViewById(R.id.btnFavGoMain);
        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), MainActivity.class);
                v.getContext().startActivity(i);
            }
        });
    }
}