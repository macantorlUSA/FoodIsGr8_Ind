package co.usa.mintic.ciclo4.foodisgr8.modelo.objetos;

import java.io.Serializable;

public class FavoriteItem implements Serializable {

    int id;
    String titulo;
    String contenido;
    byte[] image;

    public FavoriteItem(int id, String titulo, String contenido, byte[] image) {
        this.id = id;
        this.titulo = titulo;
        this.contenido = contenido;
        this.image=image;
    }

    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getContenido() {
        return contenido;
    }

    public byte[] getImage() {
        return image;
    }
}
