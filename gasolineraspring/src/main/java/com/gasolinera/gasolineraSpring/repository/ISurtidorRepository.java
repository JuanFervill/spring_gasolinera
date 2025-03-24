package com.gasolinera.gasolineraSpring.repository;

import com.gasolinera.gasolineraSpring.model.Surtidor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISurtidorRepository extends JpaRepository<Surtidor, Long> {
}
