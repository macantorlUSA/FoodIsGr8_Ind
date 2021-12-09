package co.usa.mintic.ciclo4.foodisgr8.controlador.fragments;

import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;

import co.usa.mintic.ciclo4.foodisgr8.R;
import co.usa.mintic.ciclo4.foodisgr8.modelo.StoreListCreator;
import co.usa.mintic.ciclo4.foodisgr8.modelo.objetos.ProductItem;
import co.usa.mintic.ciclo4.foodisgr8.modelo.objetos.StoreItem;

public class FragmentStores extends Fragment {

    ArrayList<StoreItem> registros;

    public FragmentStores(ArrayList<StoreItem> source) {
        this.registros = source;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View returnValue = inflater.inflate(R.layout.fragment_stores, container, false);
        ImageView imgCode = returnValue.findViewById(R.id.imgMap);
        Drawable drawable = getResources().getDrawable(R.drawable.map);
        imgCode.setImageDrawable(drawable);
        ListView lstItems = returnValue.findViewById(R.id.lstStoreList);
        StoreListCreator creator = new StoreListCreator(registros, returnValue.getContext());
        lstItems.setAdapter(creator);
        return returnValue;
    }
}