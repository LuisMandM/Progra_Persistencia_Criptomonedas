package com.ikasgela.datos;

import java.util.ArrayList;
import java.util.List;

public class Moneda {
    private long id;
    private String codigo;
    private String nombre;

    private List<Cotizacion> cotizaciones = new ArrayList<>();

    public Moneda(long id, String codigo, String nombre, List<Cotizacion> cotizaciones) {
        this.id = id;
        this.codigo = codigo;
        this.nombre = nombre;
        this.cotizaciones = cotizaciones;
    }

    public Moneda(long id, String codigo, String nombre) {
        this.id = id;
        this.codigo = codigo;
        this.nombre = nombre;
    }

    public Moneda() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Cotizacion> getCotizaciones() {
        return cotizaciones;
    }

    public void AddCotizaciones(Cotizacion cotizacion) {
        this.cotizaciones.add(cotizacion);
    }

    @Override
    public String toString() {
        return codigo + "(" + nombre + ")";
    }
}
