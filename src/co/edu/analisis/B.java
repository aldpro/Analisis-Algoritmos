package co.edu.analisis;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.DefaultXYDataset;
import org.jfree.data.xy.XYDataset;

public class B extends JFrame {

    public B() {
        initComponents();
    }

    private void initComponents() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Gráfico de Puntos");
        setSize(new Dimension(800, 600));
        setLocationRelativeTo(null);
        setResizable(false);
        getContentPane().setBackground(Color.WHITE);
        
        List<Double> xValues = new ArrayList<>();
        List<Double> yValues = new ArrayList<>();
        
        xValues.add(1.0); yValues.add(2.0);
        xValues.add(2.0); yValues.add(5.0);
        xValues.add(3.0); yValues.add(3.0);
        xValues.add(4.0); yValues.add(8.0);
        xValues.add(5.0); yValues.add(4.0);
        
        XYDataset dataset = crearDataset(xValues, yValues);
        JFreeChart chart = crearChart(dataset);
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new Dimension(600, 400));
        add(chartPanel);
    }
    
    private XYDataset crearDataset(List<Double> xValues, List<Double> yValues) {
        DefaultXYDataset dataset = new DefaultXYDataset();
        
        double[][] data = new double[2][xValues.size()];
        
        for (int i = 0; i < xValues.size(); i++) {
            data[0][i] = xValues.get(i);
            data[1][i] = yValues.get(i);
        }
        
        dataset.addSeries("Puntos", data);
        return dataset;
    }

    private JFreeChart crearChart(XYDataset dataset) {
        JFreeChart chart = ChartFactory.createScatterPlot(
                "Gráfico de Puntos", "X", "Y", dataset, 
                PlotOrientation.VERTICAL, true, true, false);

        XYPlot plot = (XYPlot) chart.getPlot();
        plot.setBackgroundPaint(Color.WHITE);
        plot.setDomainGridlinePaint(Color.GRAY);
        plot.setRangeGridlinePaint(Color.GRAY);

        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer(false, true);
        renderer.setSeriesShape(0, new java.awt.geom.Ellipse2D.Double(-3, -3, 6, 6));
        renderer.setSeriesPaint(0, Color.BLUE);
        plot.setRenderer(renderer);

        chart.getLegend().setItemFont(new Font("Tahoma", Font.PLAIN, 12));
        chart.getTitle().setFont(new Font("Tahoma", Font.BOLD, 14));
        return chart;
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            new B().setVisible(true);
        });
    }
}
