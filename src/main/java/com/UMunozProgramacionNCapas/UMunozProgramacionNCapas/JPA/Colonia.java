package com.UMunozProgramacionNCapas.UMunozProgramacionNCapas.JPA;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "colonia")
public class Colonia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idcolonia")
    private int IdColonia;
    
    @Column(name = "nombre", nullable = false, unique = false)
    private String Nombre;
    
    
    private String CodigoPostal;
    private Municipio municipio;
    

}
