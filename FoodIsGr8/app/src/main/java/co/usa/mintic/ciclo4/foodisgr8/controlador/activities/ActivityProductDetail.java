package co.usa.mintic.ciclo4.foodisgr8.controlador.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import co.usa.mintic.ciclo4.foodisgr8.R;
import co.usa.mintic.ciclo4.foodisgr8.modelo.objetos.ProductItem;

public class ActivityProductDetail extends AppCompatActivity {

    ProductItem item;
    TextView txtName;
    TextView txtDescription;
    ImageView imgProducto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);
        item = (ProductItem) getIntent().getSerializableExtra("item");
        if (item != null){
            txtName = findViewById(R.id.txtProdNameDetail);
            txtDescription = findViewById(R.id.txtProdDescDetail);
            imgProducto = findViewById(R.id.imgProdDetail);
            txtName.setText(item.getTitulo());
            txtDescription.setText(item.getContenido());
            imgProducto.setImageResource(item.getImagen());
        }
        Button btnHome = findViewById(R.id.btnGoMain);
        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), MainActivity.class);
                v.getContext().startActivity(i);
            }
        });
    }
}