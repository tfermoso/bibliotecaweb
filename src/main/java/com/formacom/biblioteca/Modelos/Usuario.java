package com.formacom.biblioteca.Modelos;

public class Usuario {
    private  int idusuario;
    private String dni;
    private String nombre;
    private String apellidos;
    private String domicilio;
    private String telefono;
    private String email;

    public Usuario() {
    }

    public Usuario(int idusuario, String dni, String nombre, String apellidos, String domicilio, String telefono, String email) {
        this.idusuario = idusuario;
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.domicilio = domicilio;
        this.telefono = telefono;
        this.email = email;
    }

    public int getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
