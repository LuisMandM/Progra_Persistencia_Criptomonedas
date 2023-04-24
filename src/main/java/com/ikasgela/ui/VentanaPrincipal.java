package com.ikasgela.ui;

import com.ikasgela.datos.GestorBD;
import com.ikasgela.datos.Moneda;

import javax.swing.*;
import java.util.List;

public class VentanaPrincipal {
    private JPanel panel;
    private JList<Moneda> lista;
    private JTable tabla;

    private List<Moneda> monedas;

    public VentanaPrincipal() {
        monedas = GestorBD.leerDatos();
    }

    public JPanel getPanel() {
        return panel;
    }
}
