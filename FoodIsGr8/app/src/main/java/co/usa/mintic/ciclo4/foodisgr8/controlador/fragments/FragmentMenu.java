package co.usa.mintic.ciclo4.foodisgr8.controlador.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

import co.usa.mintic.ciclo4.foodisgr8.R;
import co.usa.mintic.ciclo4.foodisgr8.modelo.ProductListCreator;
import co.usa.mintic.ciclo4.foodisgr8.modelo.objetos.ProductItem;

public class FragmentMenu extends Fragment {

    ArrayList<ProductItem> registros;

    public FragmentMenu(ArrayList<ProductItem> source) {
        this.registros = source;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View returnValue = inflater.inflate(R.layout.fragment_menu, container, false);
        ListView lstItems = returnValue.findViewById(R.id.lstProductList);
        ProductListCreator creator = new ProductListCreator(registros, returnValue.getContext());
        lstItems.setAdapter(creator);
        return returnValue;
    }
}