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
import co.usa.mintic.ciclo4.foodisgr8.controlador.ServiceListCreator;
import co.usa.mintic.ciclo4.foodisgr8.controlador.StoreListCreator;
import co.usa.mintic.ciclo4.foodisgr8.controlador.objetos.ServiceItem;
import co.usa.mintic.ciclo4.foodisgr8.controlador.objetos.StoreItem;

public class FragmentServices extends Fragment {

    public FragmentServices() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View returnValue = inflater.inflate(R.layout.fragment_services, container, false);
        ListView lstItems = returnValue.findViewById(R.id.lstServiceList);
        ServiceListCreator creator = new ServiceListCreator(loadItems(), returnValue.getContext());
        lstItems.setAdapter(creator);
        return returnValue;
    }

    private ArrayList<ServiceItem> loadItems() {
        ArrayList<ServiceItem> list = new ArrayList<ServiceItem>();
        for (int index = 1; index <= 20; index++) {
            list.add(new ServiceItem(getString(R.string.msgService) + " No. " + index, getString(R.string.msgServiceDescription)));
        }
        return list;
    }
}