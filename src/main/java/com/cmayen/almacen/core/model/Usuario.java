package com.cmayen.almacen.core.model;
public class Usuario {
    
    private Long id;
    private String userName;
    private String password;
    private Boolean enabled;
    private String nombre;
    private String apellido;
    private String correo;

    public Usuario() {
    }

    public Usuario(Long id, String userName, String password, Boolean enabled, String nombre, String apellido, String correo) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.enabled = enabled;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
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

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
    
    
    
}
