package com.gasolinera.gasolineraSpring.controller;

import com.gasolinera.gasolineraSpring.model.Tanque;
import com.gasolinera.gasolineraSpring.service.TanqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TanqueController {
    @Autowired
    private TanqueService tanqueService;

    @GetMapping("/tanques/traer")
    public List<Tanque> getTanques() {
        return tanqueService.getTanques();
    }

    @PostMapping("/tanques/crear")
    public String saveTanque(@RequestBody Tanque tanque) {
        tanqueService.saveTanque(tanque);
        return "Tanque creado";
    }

    @DeleteMapping("/tanques/borrar/{id}")
    public String deleteTanque(@PathVariable Long id) {
        tanqueService.deleteTanque(id);
        return "Tanque eliminado";
    }

    @PutMapping("/tanques/editar/{id}")
    public Tanque editTanque(
            @PathVariable Long id,
            @RequestParam(required = false, name = "litros") Integer nuevosLitros) {

        tanqueService.editTanque(id, nuevosLitros);
        return tanqueService.findTanque(id);
    }
}
