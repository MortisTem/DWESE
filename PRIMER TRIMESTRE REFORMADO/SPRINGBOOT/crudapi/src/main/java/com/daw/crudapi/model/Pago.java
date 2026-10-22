package com.daw.crudapi.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Pago {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //Cuánto se pagó.
    @Column(nullable = false)
    private BigDecimal importe;

    //Cuándo se pagó.
    @Column(nullable = false)
    private LocalDateTime fecha;

    //Método de oago elegido.
    @Column(nullable = false)
    private String metodo;
}