package com.daw.crud_api.controller;
 
import java.util.List;
 
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
 
import com.daw.crud_api.model.Producto;
import com.daw.crud_api.repository.ProductoRepository;
 
@RestController                    //Las respuestas se devuelven como JSON.
@RequestMapping("/api/productos")  //Prefijo común de todas las URL.
public class ProductoController {
    private final ProductoRepository productoRepository;
 
    // Spring inyecta el repositorio a través del constructor
    public ProductoController(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }
 
    // GET /api/productos -> lista todos los productos
    @GetMapping
    public List<Producto> getAllProductos() {
        return productoRepository.findAll();
    }
 
    // GET /api/productos/1 -> devuelve el producto con id 1
    @GetMapping("/{id}")
    public ResponseEntity<Producto> getProductoById(@PathVariable Long id) {
        return productoRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
 
    // POST /api/productos -> crea un producto nuevo
    @PostMapping
    public Producto createProducto(@RequestBody Producto producto) {
        return productoRepository.save(producto);
    }
 
    // PUT /api/productos/1 -> actualiza el producto con id 1
    @PutMapping("/{id}")
    public ResponseEntity<Producto> updateProducto(
            @PathVariable Long id, @RequestBody Producto detalles) {
        return productoRepository.findById(id)
                .map(producto -> {
                    producto.setNombre(detalles.getNombre());
                    producto.setPrecio(detalles.getPrecio());
                    return ResponseEntity.ok(productoRepository.save(producto));
                })
                .orElse(ResponseEntity.notFound().build());
    }
 
    // DELETE /api/productos/1 -> borra el producto con id 1
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProducto(@PathVariable Long id) {
        if (!productoRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        productoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
