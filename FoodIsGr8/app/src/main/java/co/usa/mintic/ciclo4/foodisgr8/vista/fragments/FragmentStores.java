package co.usa.mintic.ciclo4.foodisgr8.vista.fragments;

import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import co.usa.mintic.ciclo4.foodisgr8.R;

public class FragmentStores extends Fragment {

    public FragmentStores() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View returnValue = inflater.inflate(R.layout.fragment_stores, container, false);
        Drawable drawable = getResources().getDrawable(R.drawable.stores);
        ImageView imgLogoCode = returnValue.findViewById(R.id.imgStore1);
        imgLogoCode.setImageDrawable(drawable);
        imgLogoCode = returnValue.findViewById(R.id.imgStore2);
        imgLogoCode.setImageDrawable(drawable);
        imgLogoCode = returnValue.findViewById(R.id.imgStore3);
        imgLogoCode.setImageDrawable(drawable);
        return returnValue;
    }
}