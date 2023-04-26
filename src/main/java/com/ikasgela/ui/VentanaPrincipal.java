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

    //private List<Moneda> monedas;
    private Grafico grafico = null;
    private Moneda last_Selected;

    public VentanaPrincipal() {
        GestorBD.leerDatos();
        SetMonedas();
        tabla.setModel(new ModeloTabla());
        lista.addListSelectionListener(e -> {
            Moneda selected = lista.getSelectedValue();
            if (selected != last_Selected) grafico = null;
            List<Cotizacion> asociadas = new ArrayList<>();
            for (Cotizacion cotizacion : Main.Cotizaciones()) {
                if (cotizacion.getMoneda_Aso() == selected) asociadas.add(cotizacion);
            }
            if (asociadas.size() > 0) {
                tabla.setModel(new ModeloTabla(asociadas));
                if (grafico == null) grafico = new Grafico(selected);
            } else {
                JOptionPane.showMessageDialog(null, "Moneda sin Cotizaciones asociadas",
                        "Sin registros", JOptionPane.INFORMATION_MESSAGE);
                tabla.setModel(new ModeloTabla());
            }
            last_Selected = selected;
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
}
