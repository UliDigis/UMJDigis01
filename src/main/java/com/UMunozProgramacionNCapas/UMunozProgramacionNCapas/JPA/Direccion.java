package com.UMunozProgramacionNCapas.UMunozProgramacionNCapas.JPA;

import org.springframework.data.annotation.Id;

public class Direccion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int IdDireccion;
    private String Calle;
    private String NumeroInterior;
    private String NumeroExterior;
    public Usuario usuario;
    public Colonia colonia;
    

}
