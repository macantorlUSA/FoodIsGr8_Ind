package co.usa.mintic.ciclo4.foodisgr8.modelo.objetos;

import java.io.Serializable;

public class StoreItem implements Serializable {

    String nombre;
    String direccion;

    public StoreItem(String nombre, String direccion) {
        this.nombre = nombre;
        this.direccion = direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }
}

