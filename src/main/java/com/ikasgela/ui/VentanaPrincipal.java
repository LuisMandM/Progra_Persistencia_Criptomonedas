package com.ikasgela.ui;

import com.ikasgela.Main;
import com.ikasgela.datos.Cotizacion;
import com.ikasgela.datos.GestorBD;
import com.ikasgela.datos.Moneda;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class VentanaPrincipal {
    private JPanel panel;
    private JList<Moneda> lista;
    private JTable tabla;

    private List<Moneda> monedas;

    public VentanaPrincipal() {
        GestorBD.leerDatos();
        SetMonedas();
        tabla.setModel(new ModeloTabla());
        lista.addListSelectionListener(e -> {
            Moneda selected = lista.getSelectedValue();
            List<Cotizacion> asociadas = new ArrayList<>();
            for (Cotizacion cotizacion : Main.Cotizaciones()) {
                if (cotizacion.getMoneda_Aso() == selected) asociadas.add(cotizacion);
            }
            if (asociadas.size() > 0) tabla.setModel(new ModeloTabla(asociadas));
            else {
                JOptionPane.showMessageDialog(null, "Moneda sin Cotizaciones asociadas",
                        "Sin registros", JOptionPane.INFORMATION_MESSAGE);
                tabla.setModel(new ModeloTabla());
            }
        });
    }

    public JPanel getPanel() {
        return panel;
    }

    public void SetMonedas() {
        DefaultListModel<Moneda> model = new DefaultListModel<>();
        for (Moneda moneda : Main.Monedas()) {
            model.addElement(moneda);
        }
        lista.setModel(model);
    }

    /*private static Moneda Receta_Selected(String titulo) {
        for (Moneda receta : Main.Monedas()) {
            if (receta.getTitulo().equals(titulo)) return receta;
        }
        return null;
    }*/
}
