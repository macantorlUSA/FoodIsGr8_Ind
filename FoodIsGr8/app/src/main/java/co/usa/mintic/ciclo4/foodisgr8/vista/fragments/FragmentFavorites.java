package co.usa.mintic.ciclo4.foodisgr8.vista.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import co.usa.mintic.ciclo4.foodisgr8.R;

public class FragmentFavorites extends Fragment {

    public FragmentFavorites() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_favorites, container, false);
    }
}