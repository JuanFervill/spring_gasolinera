package com.gasolinera.gasolineraSpring.controller;

import com.gasolinera.gasolineraSpring.model.Surtidor;
import com.gasolinera.gasolineraSpring.service.SurtidorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SurtidorController {

    @Autowired
    private SurtidorService surtidorService;

    @GetMapping("/surtidores/traer")
    public List<Surtidor> getSurtidores() {
        return surtidorService.getSurtidores();
    }

    @PostMapping("/surtidores/crear")
    public String saveSurtidor(@RequestBody Surtidor surtidor) {
        surtidorService.saveSurtidor(surtidor);
        return "Surtidor creado";
    }

    @DeleteMapping("/surtidores/borrar/{id}")
    public String deleteSurtidor(@PathVariable Long id) {
        surtidorService.deleteSurtidor(id);
        return "Surtidor borrado";
    }

    @PutMapping("/surtidores/editar/{id}")
    public Surtidor editSurtidor(
            @PathVariable Long id,
            @RequestParam(required = false, name = "nombre") String nuevoNombre) {

        surtidorService.editSurtidor(id, nuevoNombre);
        Surtidor surti = surtidorService.findSurtidor(id);
        return surti;
    }

    @PostMapping("/surtidores/registrar")
    public ResponseEntity<String> nuevoSurtidor(@RequestParam String nombre) {
        surtidorService.nuevoSurtidor(nombre);
        return ResponseEntity.ok("Surtidor registrado");
    }

}
