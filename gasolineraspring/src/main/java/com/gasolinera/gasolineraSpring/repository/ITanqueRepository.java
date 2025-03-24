package com.gasolinera.gasolineraSpring.repository;

import com.gasolinera.gasolineraSpring.model.Producto;
import com.gasolinera.gasolineraSpring.model.Tanque;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ITanqueRepository extends JpaRepository<Tanque, Long> {
    Optional<Tanque> findByCombustible(Producto combustible);
}
