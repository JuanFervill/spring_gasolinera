package com.gasolinera.gasolineraSpring.service;

import com.gasolinera.gasolineraSpring.model.Producto;
import com.gasolinera.gasolineraSpring.repository.IProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService implements IProductoService{
    @Autowired
    private IProductoRepository productoRepository;

    @Override
    public List<Producto> getProductos() {
        List<Producto> listaProductos = productoRepository.findAll();
        return listaProductos;
    }

    @Override
    public void saveProducto(Producto producto) { productoRepository.save(producto); }

    @Override
    public void deleteProducto(Long id) { productoRepository.deleteById(id); }

    @Override
    public Producto findProducto(Long id){
        Producto producto = productoRepository.findById(id).orElse(null);
        return producto;
    }

    @Override
    public void editProducto(Long id, String nuevoNombre, String nuevaDesc, String nuevoTipo, double nuevoPrecio) {
        Producto producto = this.findProducto(id);
        producto.setNombre(nuevoNombre);
        producto.setDescripcion(nuevaDesc);
        producto.setTipo(nuevoTipo);
        producto.setPrecio(nuevoPrecio);
        this.saveProducto(producto);
    }
}
