package co.usa.mintic.ciclo4.foodisgr8.modelo.objetos;

import java.io.Serializable;

public class StoreItem implements Serializable {

    String nombre;
    String direccion;
    Double latitud;
    Double longitud;

    public StoreItem(String nombre, String direccion, Double latitud, Double longitud) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.latitud=latitud;
        this.longitud=longitud;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public Double getLatitud() {
        return latitud;
    }

    public Double getLongitud() {
        return longitud;
    }
}

