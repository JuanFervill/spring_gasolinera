package com.gasolinera.gasolineraSpring.repository;

import com.gasolinera.gasolineraSpring.model.Servicio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IServicioRepository extends JpaRepository<Servicio, Long> {

}
