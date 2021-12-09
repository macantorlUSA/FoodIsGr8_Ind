package co.usa.mintic.ciclo4.foodisgr8.controlador.fragments;

import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import co.usa.mintic.ciclo4.foodisgr8.R;

public class FragmentHome extends Fragment {

    public FragmentHome() {
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View returnValue=inflater.inflate(R.layout.fragment_home, container, false);
        Drawable drawable = getResources().getDrawable(R.drawable.isgr8);
        ImageView imgLogoCode = returnValue.findViewById(R.id.imgLogo);
        imgLogoCode.setImageDrawable(drawable);
        Button btnWelcomeCode = returnValue.findViewById(R.id.btnWelcome);
        btnWelcomeCode.setOnClickListener(v -> Toast.makeText(returnValue.getContext(), "Hola! Las opciones de encuentran en la esquina superior derecha!", Toast.LENGTH_SHORT).show());
        return returnValue;
    }
}