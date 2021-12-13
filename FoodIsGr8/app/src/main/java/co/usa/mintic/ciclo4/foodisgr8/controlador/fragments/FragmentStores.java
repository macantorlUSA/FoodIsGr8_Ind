package co.usa.mintic.ciclo4.foodisgr8.controlador.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import org.osmdroid.config.Configuration;
import org.osmdroid.library.BuildConfig;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.CustomZoomButtonsController;
import org.osmdroid.views.MapController;
import org.osmdroid.views.MapView;
import org.osmdroid.views.overlay.mylocation.GpsMyLocationProvider;
import org.osmdroid.views.overlay.mylocation.MyLocationNewOverlay;

import java.util.ArrayList;

import co.usa.mintic.ciclo4.foodisgr8.R;
import co.usa.mintic.ciclo4.foodisgr8.modelo.StoreListCreator;
import co.usa.mintic.ciclo4.foodisgr8.modelo.objetos.StoreItem;

public class FragmentStores extends Fragment {

    MapView mapView;
    MapController mapController;

    ArrayList<StoreItem> registros;

    public FragmentStores(ArrayList<StoreItem> source) {
        this.registros = source;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View returnValue = inflater.inflate(R.layout.fragment_stores, container, false);
        ListView lstItems = returnValue.findViewById(R.id.lstStoreList);
        StoreListCreator creator = new StoreListCreator(registros, returnValue.getContext(), returnValue);
        lstItems.setAdapter(creator);
        Configuration.getInstance().setUserAgentValue(BuildConfig.APPLICATION_ID);
        GeoPoint Bogota = new GeoPoint(4.6351, -74.0703);
        mapView = (MapView) returnValue.findViewById(R.id.mapStores);
        mapView.getZoomController().setVisibility(CustomZoomButtonsController.Visibility.SHOW_AND_FADEOUT);
        mapController = (MapController) mapView.getController();
        mapController.setCenter(Bogota);
        mapController.setZoom(18);
        mapView.setMultiTouchControls(true);
        final MyLocationNewOverlay myLocationoverlay = new MyLocationNewOverlay(new GpsMyLocationProvider(returnValue.getContext().getApplicationContext()), mapView);
        mapView.getOverlays().add(myLocationoverlay); //No añadir si no quieres una marca
        myLocationoverlay.enableMyLocation();
        myLocationoverlay.runOnFirstFix(new Runnable() {
            public void run() {
                mapController.animateTo(myLocationoverlay.getMyLocation());
            }
        });
        return returnValue;
    }
}