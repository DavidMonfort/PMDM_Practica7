package com.example.a6_dashboard.model;

import java.io.Serializable;

public class Disco implements Serializable {

    private String artista;
    private String titulo;
    private String urlPortada;
    private int anyo;
    private int num_canciones;

    /**
     * Constructor del disco
     * @param artista String
     * @param urlPortada String
     * @param anyo Int
     * @param num_canciones Int
     */
    public Disco(String titulo,String artista, String urlPortada, int anyo, int num_canciones) {
        this.artista = artista;
        this.urlPortada = urlPortada;
        this.anyo = anyo;
        this.num_canciones = num_canciones;
        this.titulo = titulo;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public String getUrlPortada() {
        return urlPortada;
    }

    public void setUrlPortada(String urlPortada) {
        this.urlPortada = urlPortada;
    }

    public int getAnyo() {
        return anyo;
    }

    public void setAnyo(int anyo) {
        this.anyo = anyo;
    }

    public int getNum_canciones() {
        return num_canciones;
    }

    public void setNum_canciones(int num_canciones) {
        this.num_canciones = num_canciones;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
}
