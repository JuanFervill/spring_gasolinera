package com.gasolinera.gasolineraSpring.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
public class Servicio {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private int litros;

    @ManyToOne
    private Producto combustible;

    private double precio;

    private LocalDate fecha;

    private int litrosRest;

    @ManyToOne
    @JoinColumn(name = "surtidor_id")
    private Surtidor surtidor;

    public Servicio() {
    }

    public Servicio(Long id, int litros, Producto combustible, double precio, LocalDate fecha, int litrosRest, Surtidor surtido) {
        this.id = id;
        this.litros = litros;
        this.combustible = combustible;
        this.precio = precio;
        this.fecha = fecha;
        this.litrosRest = litrosRest;
        this.surtidor = surtidor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getLitros() {
        return litros;
    }

    public void setLitros(int litros) {
        this.litros = litros;
    }

    public Producto getCombustible() {
        return combustible;
    }

    public void setCombustible(Producto combustible) {
        this.combustible = combustible;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public int getLitrosRest() {
        return litrosRest;
    }

    public void setLitrosRest(int litrosRest) {
        this.litrosRest = litrosRest;
    }

    public void updateLitrosRest(int cantidad){
        this.litrosRest -= cantidad;
    }

    public Surtidor getSurtidor() {
        return surtidor;
    }

    public void setSurtidor(Surtidor surtidor) {
        this.surtidor = surtidor;
    }
}
