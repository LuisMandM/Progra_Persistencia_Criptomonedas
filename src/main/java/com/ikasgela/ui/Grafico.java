package com.ikasgela.ui;

import com.ikasgela.datos.Cotizacion;
import com.ikasgela.datos.Moneda;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.block.BlockBorder;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.time.Day;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

public class Grafico extends JFrame {

    private final Moneda current;

    public Grafico(Moneda current) throws HeadlessException {
        this.current = current;
        initUi();
    }

    public void initUi() {
        XYDataset dataset = createDataset();
        JFreeChart chart = createChart(dataset);

        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        chartPanel.setBackground(Color.white);
        add(chartPanel);


        pack();
        setTitle("Historial Cotizaciones");
        setLocationRelativeTo(null);
        this.setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    private XYDataset createDataset() {
        TimeSeries time_Serie = new TimeSeries(current.getCodigo());

        for (int i = 0; i < current.getCotizaciones().size(); i++) {
            Cotizacion actual = current.getCotizaciones().get(i);
            LocalDate fecha_raw = actual.getFecha();
            Day fecha_set = new Day(fecha_raw.getDayOfMonth(), fecha_raw.getMonthValue(), fecha_raw.getYear());
            time_Serie.add(fecha_set, actual.getValor());
        }
        TimeSeriesCollection dataset = new TimeSeriesCollection();
        dataset.addSeries(time_Serie);
        return dataset;
    }

    private JFreeChart createChart(XYDataset dataset) {

        JFreeChart chart = ChartFactory.createXYLineChart("Cotizacion " + current.getNombre(), "Fechas",
                "Cotizacion(€)", dataset, PlotOrientation.VERTICAL, true, true, false);

        XYPlot plot = chart.getXYPlot();

        DateAxis axis = new DateAxis();
        plot.setDomainAxis(axis);
        axis.setDateFormatOverride(new SimpleDateFormat("dd-MM-yyyy"));

        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
        renderer.setSeriesPaint(0, Color.RED);
        renderer.setSeriesStroke(0, new BasicStroke(2.0f));


        plot.setRenderer(renderer);
        plot.setBackgroundPaint(Color.white);

        plot.setRangeMinorGridlinesVisible(true);
        plot.setRangeGridlinePaint(Color.BLACK);

        plot.setDomainMinorGridlinesVisible(true);
        plot.setDomainGridlinePaint(Color.BLACK);

        chart.getLegend().setFrame(BlockBorder.NONE);
        chart.setTitle(new TextTitle("Cotizacion " + current.getNombre(),
                new Font("Serif", Font.BOLD, 18)));

        return chart;
    }
}
