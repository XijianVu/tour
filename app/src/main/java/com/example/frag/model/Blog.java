package com.example.frag.model;

public class Blog {
    String titulo,descripcion,purl;

    public Blog() {
    }

    public Blog(String titulo, String descripcion,  String purl) {
        this.titulo = titulo;
        this.descripcion = descripcion;

        this.purl = purl;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getPurl() {
        return purl;
    }

    public void setPurl(String purl) {
        this.purl = purl;
    }
}

