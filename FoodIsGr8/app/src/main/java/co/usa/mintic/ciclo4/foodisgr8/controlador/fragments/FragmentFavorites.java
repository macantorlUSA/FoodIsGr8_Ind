package co.usa.mintic.ciclo4.foodisgr8.controlador.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;

import co.usa.mintic.ciclo4.foodisgr8.R;
import co.usa.mintic.ciclo4.foodisgr8.controlador.activities.MainActivity;
import co.usa.mintic.ciclo4.foodisgr8.modelo.FavoriteListCreator;
import co.usa.mintic.ciclo4.foodisgr8.modelo.objetos.FavoriteItem;

public class FragmentFavorites extends Fragment {

    private ArrayList<FavoriteItem> registros;
    MainActivity mainView;
    private FavoriteListCreator creator;

    public FragmentFavorites(ArrayList<FavoriteItem> source, MainActivity view) {
        this.setRegistros(source);
        this.mainView = view;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View returnValue = inflater.inflate(R.layout.fragment_favorites, container, false);
        ListView lstItems = returnValue.findViewById(R.id.lstFavorites);
        setCreator(new FavoriteListCreator(getRegistros(), returnValue.getContext(), mainView));
        lstItems.setAdapter(getCreator());
        return returnValue;
    }

    public FavoriteListCreator getCreator() {
        return creator;
    }

    public void setCreator(FavoriteListCreator creator) {
        this.creator = creator;
    }

    public ArrayList<FavoriteItem> getRegistros() {
        return registros;
    }

    public void setRegistros(ArrayList<FavoriteItem> registros) {
        this.registros = registros;
    }
}