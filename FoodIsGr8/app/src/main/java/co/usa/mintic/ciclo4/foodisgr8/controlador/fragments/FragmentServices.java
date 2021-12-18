package co.usa.mintic.ciclo4.foodisgr8.controlador.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import co.usa.mintic.ciclo4.foodisgr8.R;
import co.usa.mintic.ciclo4.foodisgr8.modelo.ServiceListCreator;
import co.usa.mintic.ciclo4.foodisgr8.modelo.objetos.ProductItem;
import co.usa.mintic.ciclo4.foodisgr8.modelo.objetos.ServiceItem;

public class FragmentServices extends Fragment {

    List<ServiceItem> registros;

    public FragmentServices(List<ServiceItem> source) {
        this.registros = source;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View returnValue = inflater.inflate(R.layout.fragment_services, container, false);
        ListView lstItems = returnValue.findViewById(R.id.lstServiceList);
        ServiceListCreator creator = new ServiceListCreator(registros, returnValue.getContext());
        lstItems.setAdapter(creator);
        return returnValue;
    }
}