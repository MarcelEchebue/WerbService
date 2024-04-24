package com.example.formulaire;

public class Persona {
    private int id;
    private String nombre;
    private String apellido;
    private int edad;
    private String nombre_padre;
    private String nombre_madre;

    // Constructeur
    public Persona(int id, String nombre, String apellido, int edad, String nombre_padre, String nombre_madre) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.nombre_padre = nombre_padre;
        this.nombre_madre = nombre_madre;
    }

    // Getters et Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getNombrePadre() {
        return nombre_padre;
    }

    public void setNombrePadre(String nombre_padre) {
        this.nombre_padre = nombre_padre;
    }

    public String getNombreMadre() {
        return nombre_madre;
    }

    public void setNombreMadre(String nombre_madre) {
        this.nombre_madre = nombre_madre;
    }
}
