package com.gasolinera.gasolineraSpring.controller;

import com.gasolinera.gasolineraSpring.model.Producto;
import com.gasolinera.gasolineraSpring.model.Servicio;
import com.gasolinera.gasolineraSpring.service.ServicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/servicios")
public class ServicioController {

    @Autowired
    private ServicioService servicioService;

    // Corregir la ruta para que sea '/servicios/registrar' en lugar de '/servicios/servicios/registrar'
    @PostMapping("/registrar")
    public ResponseEntity<String> nuevoServicio(
            @RequestParam Long productoId,
            @RequestParam int litros) {

        servicioService.nuevoServicio(productoId, litros);
        return ResponseEntity.ok("Servicio registrado");
    }

    @GetMapping("/traer")
    public List<Servicio> getServicios() {
        return servicioService.getServicios();
    }

    @PostMapping("/crear")
    public String saveServicio(@RequestBody Servicio servicio) {
        servicioService.saveServicio(servicio);
        return "Servicio creado correctamente";
    }

    @DeleteMapping("/borrar/{id}")
    public String deleteServicio(@PathVariable Long id) {
        servicioService.deleteServicio(id);
        return "Servicio eliminado correctamente";
    }

    @PutMapping("/editar/{id}")
    public Servicio editServicio(
            @PathVariable Long id,
            @RequestParam(required = false, name = "litros") Integer nuevosLitros,
            @RequestParam(required = false, name = "combustible") Producto nuevoCombustible,
            @RequestParam(required = false, name = "precio") Double nuevoPrecio,
            @RequestParam(required = false, name = "fecha") LocalDate nuevaFecha,
            @RequestParam(required = false, name = "litrosRest") Integer nuevosLitrosRest) {

        servicioService.editServicio(
                id,
                (nuevosLitros != null) ? nuevosLitros : servicioService.findServicio(id).getLitros(),
                (nuevoCombustible != null) ? nuevoCombustible : servicioService.findServicio(id).getCombustible(),
                (nuevoPrecio != null) ? nuevoPrecio : servicioService.findServicio(id).getPrecio(),
                (nuevaFecha != null) ? nuevaFecha : servicioService.findServicio(id).getFecha(),
                (nuevosLitrosRest != null) ? nuevosLitrosRest : servicioService.findServicio(id).getLitrosRest()
        );

        return servicioService.findServicio(id);
    }
}