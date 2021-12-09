package co.usa.mintic.ciclo4.foodisgr8.modelo.objetos;

import java.io.Serializable;

public class ServiceItem implements Serializable {

    String nombre;
    String descripcion;

    public ServiceItem(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }
}

