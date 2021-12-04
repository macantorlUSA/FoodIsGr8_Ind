package co.usa.mintic.ciclo4.foodisgr8.controlador.objetos;

import java.io.Serializable;

public class ProductItem implements Serializable {

    int imagen;
    String titulo;
    String contenido;

    public ProductItem(int imagen, String titulo, String contenido) {
        this.imagen = imagen;
        this.titulo = titulo;
        this.contenido = contenido;

    }

    public int getImagen() {
        return imagen;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getContenido() {
        return contenido;
    }
}
