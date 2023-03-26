package co.edu.analisis;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class BarChartExample extends ApplicationFrame {
    
    public BarChartExample(String title) {
        super(title);
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.setValue(100, "Año 1", "Producto 1");
        dataset.setValue(200, "Año 1", "Producto 2");
        dataset.setValue(300, "Año 2", "Producto 1");
        dataset.setValue(400, "Año 2", "Producto 2");
        JFreeChart chart = ChartFactory.createBarChart("Ventas", "Años", "Ventas", dataset, PlotOrientation.VERTICAL, false, true, false);
        ChartPanel chartPanel = new ChartPanel(chart);
        add(chartPanel, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        BarChartExample chart = new BarChartExample("Ventas");
        chart.pack();
        RefineryUtilities.centerFrameOnScreen(chart);
        chart.setVisible(true);
    }

}