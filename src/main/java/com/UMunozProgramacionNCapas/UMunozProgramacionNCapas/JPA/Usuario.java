package com.UMunozProgramacionNCapas.UMunozProgramacionNCapas.JPA;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "usuario")
public class Usuario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "isuduario")
    private int IdUsuario;
    
    @Column(name = "username", nullable = false, unique = true, length = 50)
    private String UserName;
    
    @Column(name = "nombre", nullable = false, unique = false, length = 50)
    private String Nombre;
    
    @Column(name = "apelidopaterno", nullable = false, unique = false, length = 50)
    private String ApellidoPaterno;
    
    @Column(name = "apellidomaterno", nullable = true, unique = false, length = 50)
    private String ApellidoMaterno;
    
    @Column(name = "email", nullable = false, unique = true, length = 254)
    private String Email;
    
    @Column(name = "password", nullable = false, unique = false, length = 50)
    private String Password;
    
    @Column(name = "fehcanacimiento", nullable = false, unique = false)
    private Date FehcaNacimiento;
    
    @Column(name = "sexo", nullable = false, unique = false, length = 2)
    private char Sexo;
    
    @Column(name = "telefono", nullable = false, unique = false, length = 20)
    private String Telefono;
    
    @Column(name = "celular", nullable = true, unique = false, length = 20)
    private String Celular;
    
    @Column(name = "curp", nullable = false, unique = true, length = 30)
    private String CURP;
    
    @Column(name = "imagen", nullable = true, unique = false)
    private String Imagen;
    
    @JoinColumn(name = "idrol", nullable = false)
    public Rol rol;
    
//    @JoinColumn(name = "idusuario", nullable = false)
//    public List<Dirreciones> Direcciones;
    
}
