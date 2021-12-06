package co.usa.mintic.ciclo4.foodisgr8.vista.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

import co.usa.mintic.ciclo4.foodisgr8.R;
import co.usa.mintic.ciclo4.foodisgr8.controlador.ProductListCreator;
import co.usa.mintic.ciclo4.foodisgr8.controlador.objetos.ProductItem;

public class FragmentMenu extends Fragment {

    public FragmentMenu() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View returnValue = inflater.inflate(R.layout.fragment_menu, container, false);
        ListView lstItems = returnValue.findViewById(R.id.lstProductList);
        ProductListCreator creator = new ProductListCreator(loadItems(), returnValue.getContext());
        lstItems.setAdapter(creator);
        return returnValue;
    }

    private ArrayList<ProductItem> loadItems() {
        ArrayList<ProductItem> list = new ArrayList<ProductItem>();
        list.add(new ProductItem(R.drawable.prod1, "Churrasco 500 gr.", "Corte grueso de chata acompañado de ensalada, pure de papa y copa de vino. Ideal para un aluerzo especial!"));
        list.add(new ProductItem(R.drawable.prod2, "Hamburguesa", "Clásico de la comida rápida. Acompañado por papitas y gaseosa."));
        list.add(new ProductItem(R.drawable.prod3, "Burrito", "De mexico para el mundo, una explosión de sabores imperdible!"));
        list.add(new ProductItem(R.drawable.prod4, "Pizza de Pepperoni", "Plan de amigos sin pizza, no es plan. No te pierdas su inigualable sabor!"));
        list.add(new ProductItem(R.drawable.prod5, "Wild HotDog", "El perro caliente que conoces pero a un nuevo nivel!"));
        list.add(new ProductItem(R.drawable.prod6, "Pinchos", "Simples en la presentación, pero poderosos en sazon!"));
        list.add(new ProductItem(R.drawable.prod7, "Tarta de Fresa", "Nada mejor que terminar el día con una deliciosa tarta de fresa recién hecha por nuestro personal."));
        list.add(new ProductItem(R.drawable.prod8, "Empanadas", "Corte grueso de chata acompañado de ensalada, pure de papa y copa de vino. Ideal para un aluerzo especial!"));
        list.add(new ProductItem(R.drawable.prod9, "Taco", "Corte grueso de chata acompañado de ensalada, pure de papa y copa de vino. Ideal para un aluerzo especial!"));
        list.add(new ProductItem(R.drawable.prod10, "Filet Mignon", "Corte grueso de chata acompañado de ensalada, pure de papa y copa de vino. Ideal para un aluerzo especial!"));
        list.add(new ProductItem(R.drawable.prod11, "Cheesecake", "Corte grueso de chata acompañado de ensalada, pure de papa y copa de vino. Ideal para un aluerzo especial!"));
        list.add(new ProductItem(R.drawable.prod12, "Limonada", "Tenemos una amplia gama de limonadas para que pruebes y disfrutes!"));
        list.add(new ProductItem(R.drawable.prod13, "Cerveza", "En FoodisGr8, contamos con un amplio catálogo de cervezas: Nacionales, importadas, artesanales... Para todos!"));
        list.add(new ProductItem(R.drawable.prod14, "Vinos", "Nunca es temprano o tarde para acompañar tus comidas con una buena opa de vino."));
        list.add(new ProductItem(R.drawable.prod15, "Sopa", "Algo ligero? Se le tiene! Sopas hechas con receta de la abuela!"));
        return list;
    }
}