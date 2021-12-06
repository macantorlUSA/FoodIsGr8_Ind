package co.usa.mintic.ciclo4.foodisgr8.vista.fragments;

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
import co.usa.mintic.ciclo4.foodisgr8.controlador.ProductListCreator;
import co.usa.mintic.ciclo4.foodisgr8.controlador.StoreListCreator;
import co.usa.mintic.ciclo4.foodisgr8.controlador.objetos.ProductItem;
import co.usa.mintic.ciclo4.foodisgr8.controlador.objetos.StoreItem;

public class FragmentStores extends Fragment {

    public FragmentStores() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View returnValue = inflater.inflate(R.layout.fragment_stores, container, false);
        ImageView imgCode = returnValue.findViewById(R.id.imgMap);
        Drawable drawable = getResources().getDrawable(R.drawable.map);
        imgCode.setImageDrawable(drawable);
        ListView lstItems = returnValue.findViewById(R.id.lstStoreList);
        StoreListCreator creator = new StoreListCreator(loadItems(), returnValue.getContext());
        lstItems.setAdapter(creator);
        return returnValue;
    }

    private ArrayList<StoreItem> loadItems() {
        ArrayList<StoreItem> list = new ArrayList<StoreItem>();
        for (int index = 1; index <= 10; index++) {
            list.add(new StoreItem(getString(R.string.msgStoreName) + " No. " + index, getString(R.string.msgStoreDescription)));
        }
        return list;
    }
}