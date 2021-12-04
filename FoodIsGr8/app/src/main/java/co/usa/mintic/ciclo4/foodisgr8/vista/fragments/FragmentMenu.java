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
import co.usa.mintic.ciclo4.foodisgr8.controlador.ListCreator;
import co.usa.mintic.ciclo4.foodisgr8.controlador.objetos.ProductItem;

public class FragmentMenu extends Fragment {

    public FragmentMenu() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View returnValue = inflater.inflate(R.layout.fragment_menu, container, false);
        ListView lstItems = returnValue.findViewById(R.id.lstProductList);
        ListCreator creator = new ListCreator(loadItems(), returnValue.getContext());
        lstItems.setAdapter(creator);
        return returnValue;
    }

    private ArrayList<ProductItem> loadItems() {
        ArrayList<ProductItem> list = new ArrayList<ProductItem>();
        for (int index = 1; index <= 16; index++) {
            list.add(new ProductItem(R.drawable.isgr8, getString(R.string.msgProductName) + " No. " + index, getString(R.string.msgProductDescription) + " No. " + index));
        }
        return list;
    }
}