package com.gasolinera.gasolineraSpring.service;

import com.gasolinera.gasolineraSpring.model.Producto;
import com.gasolinera.gasolineraSpring.model.Servicio;

import java.time.LocalDate;
import java.util.List;

public interface IServicioService {
    public List<Servicio> getServicios();

    public void saveServicio(Servicio servicio);

    public void nuevoServicio(Long producto, int litros);

    public void deleteServicio(Long id);

    public Servicio findServicio(Long id);

    public void editServicio(Long id,
                             int nuevosLitros,
                             Producto nuevoCombustible,
                             double nuevoPrecio,
                             LocalDate nuevaFecha,
                             int nuevosLitrosRest);
}