package com.gasolinera.gasolineraSpring.repository;

import com.gasolinera.gasolineraSpring.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProductoRepository extends JpaRepository<Producto, Long> {
    List<Producto> findByNombreIn(List<String> nombres);
}
