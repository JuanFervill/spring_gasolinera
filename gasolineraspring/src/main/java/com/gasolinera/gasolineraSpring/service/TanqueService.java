package com.gasolinera.gasolineraSpring.service;

import com.gasolinera.gasolineraSpring.model.Tanque;
import com.gasolinera.gasolineraSpring.repository.ITanqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TanqueService implements ITanqueService {
    @Autowired
    private ITanqueRepository tanqueRepository;

    @Override
    public List<Tanque> getTanques() {
        return tanqueRepository.findAll();
    }

    @Override
    public void saveTanque(Tanque tanque) {
        tanqueRepository.save(tanque);
    }

    @Override
    public void deleteTanque(Long id) {
        tanqueRepository.deleteById(id);
    }

    @Override
    public Tanque findTanque(Long id) {
        return tanqueRepository.findById(id).orElse(null);
    }

    @Override
    public void editTanque(Long id, int nuevosLitros) {
        Tanque tanque = this.findTanque(id);
        if (tanque != null) {
            tanque.setLitros(nuevosLitros);
            this.saveTanque(tanque);
        }
    }
}
