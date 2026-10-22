package com.daw.crud_api.repository;
 
import org.springframework.data.jpa.repository.JpaRepository;
 
import com.daw.crud_api.model.Producto;
 
public interface ProductoRepository extends JpaRepository<Producto, Long> {
    // No hace falta código adicional: JpaRepository ya ofrece findAll(),
    // findById(), save(), deleteById(), existsById(), etc.
}