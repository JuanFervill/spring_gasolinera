package com.gasolinera.gasolineraSpring.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Surtidor {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    private String nombre;

    @ManyToMany
    @JoinTable(
            name = "surtidor_producto", // Nombre de la tabla intermedia
            joinColumns = @JoinColumn(name = "surtidor_id"), // Clave foránea de Surtidor
            inverseJoinColumns = @JoinColumn(name = "producto_id") // Clave foránea de Producto
    )
    private List<Producto> productos;

    public Surtidor(long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    public Surtidor() {
    }
}
