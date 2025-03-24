package com.gasolinera.gasolineraSpring.service;

import com.gasolinera.gasolineraSpring.model.Producto;

import java.util.List;

public interface IProductoService {
    public List<Producto> getProductos();

    public void saveProducto(Producto producto);

    public void deleteProducto(Long id);

    public Producto findProducto(Long id);

    public void editProducto(Long id,
                             String nuevoNombre,
                             String nuevaDesc,
                             String nuevotipo,
                             double nuevoPrecio);

}
