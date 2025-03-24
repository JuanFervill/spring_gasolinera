package com.gasolinera.gasolineraSpring.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Tanque {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    private int litros;
    @OneToOne
    private Producto combustible;

    public Tanque() {
    }

    public Tanque(Producto combustible, int litros, long id) {
        this.combustible = combustible;
        this.litros = litros;
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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
}
