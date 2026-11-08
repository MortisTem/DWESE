package com.daw.crudapi.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private BigDecimal precio;

    private String descripcion;

    @Column(nullable = false)
    private Integer stock;

    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "proveedor_id", nullable = false)
    private Proveedor proveedor;

    @ToString.Exclude
    @OneToMany(mappedBy = "producto")
    private List<Valoracion> valoraciones = new ArrayList<>();

    @ToString.Exclude
    @ManyToMany(mappedBy = "productos")
    private List<Pedido> pedidos = new ArrayList<>();

    @ToString.Exclude
    @ManyToMany
    @JoinTable(
        name = "producto_categoria",
        joinColumns = @JoinColumn(name = "producto_id"),
        inverseJoinColumns = @JoinColumn(name = "categoria_id")
    )
    private List<Categoria> categorias = new ArrayList<>();

    public void addValoracion(Valoracion valoracion) {
        valoracion.setProducto(this);
        valoraciones.add(valoracion);
    }

    public void addCategoria(Categoria categoria) {
        categorias.add(categoria);
        categoria.getProductos().add(this);
    }
}