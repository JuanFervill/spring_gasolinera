package com.gasolinera.gasolineraSpring.service;

import com.gasolinera.gasolineraSpring.model.Producto;
import com.gasolinera.gasolineraSpring.model.Servicio;
import com.gasolinera.gasolineraSpring.model.Tanque;
import com.gasolinera.gasolineraSpring.repository.IProductoRepository;
import com.gasolinera.gasolineraSpring.repository.IServicioRepository;
import com.gasolinera.gasolineraSpring.repository.ITanqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ServicioService implements IServicioService {
    @Autowired
    IServicioRepository serviRepo;

    @Autowired
    IProductoRepository prodRepo;

    @Autowired
    ITanqueRepository tanRepo;

    @Override
    public List<Servicio> getServicios() {
        return serviRepo.findAll();
    }

    @Override
    public void saveServicio(Servicio servicio) {
        serviRepo.save(servicio);
    }

    @Override
    public void nuevoServicio(Long productoid, int litros){
        Producto producto = prodRepo.findById(productoid).orElse(null);

        Tanque tanque = tanRepo.findByCombustible(producto).orElse(null);

        double total = producto.getPrecio() * litros;
        tanque.setLitros(tanque.getLitros() - litros);
        tanRepo.save(tanque);

        Servicio servicio = new Servicio();
        servicio.setLitros(litros);
        servicio.setCombustible(producto);
        servicio.setPrecio(total);
        servicio.setFecha(LocalDate.now());
        servicio.setLitrosRest(tanque.getLitros());
        serviRepo.save(servicio);
    }

    @Override
    public void deleteServicio(Long id) {
        serviRepo.deleteById(id);
    }

    @Override
    public Servicio findServicio(Long id) {
        return serviRepo.findById(id).orElse(null);
    }

    @Override
    public void editServicio(Long id,
                             int nuevosLitros,
                             Producto nuevoCombustible,
                             double nuevoPrecio,
                             LocalDate nuevaFecha,
                             int nuevosLitrosRest) {
        Servicio servicio = findServicio(id);
        if (servicio != null) {
            servicio.setLitros(nuevosLitros);
            servicio.setCombustible(nuevoCombustible);
            servicio.setPrecio(nuevoPrecio);
            servicio.setFecha(nuevaFecha);
            servicio.setLitrosRest(nuevosLitrosRest);
            saveServicio(servicio);
        }
    }
}
