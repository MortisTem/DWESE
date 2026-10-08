package com.daw.crud_api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.Column;
import jakarta.persistence.Table;

@Entity
@Table(indexes = @Index(name = "idx_email", columnList = "email"))
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String apellidos;

    @Column(nullable = false,unique = true)
    private String email;
    
    @Column(nullable = false)
    private String telefono;
}
