package com.gasolinera.gasolineraSpring.service;

import com.gasolinera.gasolineraSpring.model.Tanque;

import java.util.List;

public interface ITanqueService {
    List<Tanque> getTanques();
    void saveTanque(Tanque tanque);
    void deleteTanque(Long id);
    Tanque findTanque(Long id);
    void editTanque(Long id, int nuevosLitros);
}
