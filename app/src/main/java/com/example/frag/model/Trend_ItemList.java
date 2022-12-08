package com.example.frag.model;

public class Trend_ItemList {
    private String titulo;
    private String descripcion;
    private int imgResource;

    public Trend_ItemList(String titulo, String descripcion, int imgResource) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.imgResource = imgResource;
    }



    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setImgResource(int imgResource) {
        this.imgResource = imgResource;
    }
    public  String getTitulo()
    {
        return titulo;
    }

    public  String getDescripcion() {

        return descripcion;
    }

    public  int getImgResource() {

        return imgResource;
    }
}
