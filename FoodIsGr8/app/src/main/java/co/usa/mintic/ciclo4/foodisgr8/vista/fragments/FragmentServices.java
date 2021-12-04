package co.usa.mintic.ciclo4.foodisgr8.vista.fragments;

import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import co.usa.mintic.ciclo4.foodisgr8.R;

public class FragmentServices extends Fragment {

    public FragmentServices() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View returnValue = inflater.inflate(R.layout.fragment_services, container, false);
        Drawable drawable = getResources().getDrawable(R.drawable.services);
        ImageView imgLogoCode = returnValue.findViewById(R.id.imgServ1);
        imgLogoCode.setImageDrawable(drawable);
        imgLogoCode = returnValue.findViewById(R.id.imgServ2);
        imgLogoCode.setImageDrawable(drawable);
        imgLogoCode = returnValue.findViewById(R.id.imgServ3);
        imgLogoCode.setImageDrawable(drawable);
        imgLogoCode = returnValue.findViewById(R.id.imgServ4);
        imgLogoCode.setImageDrawable(drawable);
        return returnValue;
    }
}