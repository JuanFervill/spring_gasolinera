package com.gasolinera.gasolineraSpring.controller;

import com.gasolinera.gasolineraSpring.model.Producto;
import com.gasolinera.gasolineraSpring.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @GetMapping("/productos/traer")
    public List<Producto> getProductos(){
        return productoService.getProductos();
    }

    @PostMapping("/productos/crear")
    public String saveProducto(@RequestBody Producto producto){
        productoService.saveProducto(producto);

        return "Producto creado";
    }

    @DeleteMapping("/productos/borrar/{id}")
    public String deleteProducto(@PathVariable Long id){
        productoService.deleteProducto(id);
        return "Producto borrado";
    }

    @PutMapping("/productos/editar/{id}")
    public Producto editProducto(
            @PathVariable Long id,
            @RequestParam(required = false, name = "nombre") String nuevoNombre,
            @RequestParam(required = false, name = "descripcion") String nuevaDesc,
            @RequestParam(required = false, name = "tipo") String nuevoTipo,
            @RequestParam(required = false, name = "precio") int nuevoPrecio) {

        productoService.editProducto(id, nuevoNombre, nuevaDesc, nuevoTipo, nuevoPrecio);

        Producto prod = productoService.findProducto(id);
        return prod;
    }

}
