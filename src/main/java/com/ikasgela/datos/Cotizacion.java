package com.ikasgela.datos;

import java.time.LocalDate;

public class Cotizacion {
    private long id;
    private LocalDate fecha;
    private double valor;

    private Moneda moneda_Aso;

    public Cotizacion(long id, LocalDate fecha, double valor, Moneda moneda_Aso) {
        this.id = id;
        this.fecha = fecha;
        this.valor = valor;
        this.moneda_Aso = moneda_Aso;
    }

    public Cotizacion() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Moneda getMoneda_Aso() {
        return moneda_Aso;
    }

    public void setMoneda_Aso(Moneda moneda_Aso) {
        this.moneda_Aso = moneda_Aso;
    }
}
