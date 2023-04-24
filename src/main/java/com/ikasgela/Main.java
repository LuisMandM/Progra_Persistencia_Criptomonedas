package com.ikasgela;

import com.ikasgela.datos.Cotizacion;
import com.ikasgela.datos.GestorBD;
import com.ikasgela.datos.Moneda;
import com.ikasgela.ui.VentanaPrincipal;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private static List<Moneda> monedas = new ArrayList<>();
    private static List<Cotizacion> cotizaciones = new ArrayList<>();

    public static void main(String[] args) {
        JFrame frame = new JFrame("Criptomonedas");
        frame.setContentPane(new VentanaPrincipal().getPanel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static List<Moneda> Monedas() {
        return monedas;
    }

    public static void setMonedas(List<Moneda> monedas) {
        Main.monedas = monedas;
    }

    public static List<Cotizacion> Cotizaciones() {
        return cotizaciones;
    }

    public static void setCotizaciones(List<Cotizacion> cotizaciones) {
        Main.cotizaciones = cotizaciones;
    }
}
