package com.daw.crud_api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.OneToMany;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter 
@Setter 
@ToString 
@AllArgsConstructor 
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

    //En mappedBy va el nombre del campo de la otra entidad que sirve para mapear esta.
    @OneToMany(mappedBy = "cliente")
    private List<Direccion> direcciones;

    public void addDireccion(Direccion direccion)
    {
        //Añadimos la direccion a la lista de direcciones del cliente.
        direcciones.add(direccion);
        //Le decimos que la dirección pertenece a este cliente.
        direccion.setCliente(this);
    }
    
}
