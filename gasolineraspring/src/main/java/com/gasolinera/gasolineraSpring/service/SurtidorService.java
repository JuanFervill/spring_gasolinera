package com.gasolinera.gasolineraSpring.service;

import com.gasolinera.gasolineraSpring.model.Producto;
import com.gasolinera.gasolineraSpring.model.Surtidor;
import com.gasolinera.gasolineraSpring.repository.IProductoRepository;
import com.gasolinera.gasolineraSpring.repository.ISurtidorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SurtidorService implements ISurtidorService {
    @Autowired
    private ISurtidorRepository surtiRepo;
    @Autowired
    private IProductoRepository prodRepo;

    @Override
    public List<Surtidor> getSurtidores(){
        List<Surtidor> listaSurti = surtiRepo.findAll();
        return listaSurti;
    }

    @Override
    public void saveSurtidor(Surtidor surtidor) { surtiRepo.save(surtidor); }

    @Override
    public void deleteSurtidor(Long id) { surtiRepo.deleteById(id); }

    @Override
    public Surtidor findSurtidor(Long id){
        Surtidor surtidor = surtiRepo.findById(id).orElse(null);
        return surtidor;
    }

    @Override
    public void editSurtidor(Long id, String nuevoNombre) {
        Surtidor surtidor = this.findSurtidor(id);
        surtidor.setNombre(nuevoNombre);
        this.saveSurtidor(surtidor);
    }

    @Override
    public void nuevoSurtidor(String nombre){
        List<String> nombresCombustibles = List.of("Gasolina 95", "Gasolina 98", "Diésel Normal", "Diésel Premium");
        List<Producto> productos = prodRepo.findByNombreIn(nombresCombustibles);

        Surtidor surtidor = new Surtidor();
        surtidor.setNombre(nombre);
        surtidor.setProductos(productos);
        this.saveSurtidor(surtidor);
    }
}
