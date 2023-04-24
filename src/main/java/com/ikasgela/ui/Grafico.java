package com.ikasgela.ui;

import com.ikasgela.Main;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeriesCollection;

import javax.swing.*;
import java.awt.*;

public class Grafico extends JFrame {


    private void initUi(){
        XYDataset dataset = createDataset();
        JFreeChart chart = createChart(dataset);

        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        chartPanel.setBackground(Color.white);
        add(chartPanel);

        pack();
        setTitle("Historial Cotizaciones");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private XYDataset createDataset(){
        TimeSeries time_Serie = new TimeSeries("Historical");

        for (int i = 0; i < Main.Cotizaciones().size(); i++) {
            time_Serie.addAndOrUpdate(new TimeSeries("Historical",String.valueOf(Main.Cotizaciones().get(i).getFecha()),
                    String.valueOf(Main.Cotizaciones().get(i).getValor())));

        }

        var dataset = new XYSeriesCollection();
        dataset.addSeries(time_Serie);


    }
}
