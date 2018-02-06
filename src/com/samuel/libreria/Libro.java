package com.samuel.libreria;

public class Libro implements Comparable {
    
    private String titulo, autor, ISBN;
    private float precio;
    private int cantidad;
    
    // Constructores

    public Libro(String titulo, String autor, String ISBN, float precio) {
        this.titulo = titulo;
        this.autor = autor;
        this.ISBN = ISBN;
        this.precio = precio;
        this.cantidad = 0;
    }

    public Libro(String titulo, String autor, String ISBN, float precio, int cantidad) {
        this.titulo = titulo;
        this.autor = autor;
        this.ISBN = ISBN;
        this.precio = precio;
        this.cantidad = cantidad;
    }
    
    // Set's y Get's

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    // Metodo CompareTo para ordenador con Collections.sort
    
    @Override public int compareTo(Object objeto) {
        
        Libro libro = (Libro) objeto;
        
        if(titulo.compareToIgnoreCase(libro.getTitulo()) > 0)
            return 1;
        else if(titulo.compareToIgnoreCase(libro.getTitulo()) == 0)
            return 0;
        else
            return -1;
    }
}
