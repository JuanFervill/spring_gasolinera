package com.gasolinera.gasolineraSpring.service;

import com.gasolinera.gasolineraSpring.model.Surtidor;

import java.util.List;

public interface ISurtidorService {
    public List<Surtidor> getSurtidores();

    public void saveSurtidor(Surtidor surtidor);

    public void deleteSurtidor(Long id);

    public Surtidor findSurtidor(Long id);

    public void editSurtidor(Long id, String nuevoNombre);

    public void nuevoSurtidor(String nombre);
}
