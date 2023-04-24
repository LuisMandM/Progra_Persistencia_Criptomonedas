package com.ikasgela.ui;

import com.ikasgela.datos.Cotizacion;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class ModeloTabla extends AbstractTableModel {

    private final String[] columnas = {"Fecha", "Valor(€)"};
    private List<Cotizacion> cotizaciones = new ArrayList<>();

    public ModeloTabla() {
    }

    public ModeloTabla(List<Cotizacion> cotizaciones) {
        this.cotizaciones = cotizaciones;
    }

    @Override
    public int getRowCount() {
        return cotizaciones.size();
    }

    @Override
    public int getColumnCount() {
        return columnas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {

        Cotizacion cotizacion = cotizaciones.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return cotizacion.getFecha();
            case 1:
                return cotizacion.getValor();
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        return columnas[column];
    }
}
