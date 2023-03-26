package co.edu.analisis;

import java.awt.BorderLayout;
import javax.swing.JFrame;

import co.edu.analisis.model.Captura;
import co.edu.analisis.model.Metodo;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class BarChartExample extends ApplicationFrame {

    public static void main(String[] args) {

        BarChartExample chart = new BarChartExample("Algoritmos");
        chart.pack();
        RefineryUtilities.centerFrameOnScreen(chart);
        chart.setVisible(true);
    }

    public static long tiempo (double[][] matrizn, double[][] matrizm, int metodo) {
        Captura captura1 = new Captura();
        Metodo met = new Metodo();

        String nombreMetodo = " ";

        nombreMetodo = met.obtenerNombre(metodo);
        Object[] resultado = captura1.consultaMetodo(matrizn, matrizm, metodo);

        long tiempo = (long) resultado[0];
        return tiempo;
    }
    public static String nombre (int metodo) {
        Metodo met = new Metodo();

        String nombreMetodo = " ";

        nombreMetodo = met.obtenerNombre(metodo);

        return nombreMetodo;
    }

    public BarChartExample(String title) {
        super(title);
        double[][] matrizn = {{1234, 2345, 3456, 4567}, {5678, 6789, 7890, 8901}, {9012, 1234, 2345, 3456}, {4567, 5678, 6789, 7890}};
        double[][] matrizm = {{4321, 5432, 6543, 7654}, {8765, 9876, 1098, 2109}, {3210, 4321, 5432, 6543}, {7654, 8765, 9876, 1098}};

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.setValue(tiempo(matrizn, matrizm, 1),"Metodo 1", nombre(1));
        dataset.setValue(tiempo(matrizn, matrizm, 2),"Metodo 1", nombre(2));
        dataset.setValue(tiempo(matrizn, matrizm, 3),"Metodo 1", nombre(3));
        dataset.setValue(tiempo(matrizn, matrizm, 4),"Metodo 1", nombre(4));
        dataset.setValue(tiempo(matrizn, matrizm, 5),"Metodo 1", nombre(5));
        dataset.setValue(tiempo(matrizn, matrizm, 6),"Metodo 1", nombre(6));
        dataset.setValue(tiempo(matrizn, matrizm, 7),"Metodo 1", nombre(7));
        dataset.setValue(tiempo(matrizn, matrizm, 8),"Metodo 1", nombre(8));
        dataset.setValue(tiempo(matrizn, matrizm, 9),"Metodo 1", nombre(9));
        dataset.setValue(tiempo(matrizn, matrizm, 10),"Metodo 1", nombre(10));
        dataset.setValue(tiempo(matrizn, matrizm, 11),"Metodo 1", nombre(11));
        dataset.setValue(tiempo(matrizn, matrizm, 12),"Metodo 1", nombre(12));
        dataset.setValue(tiempo(matrizn, matrizm, 13),"Metodo 1", nombre(13));
        dataset.setValue(tiempo(matrizn, matrizm, 14),"Metodo 1", nombre(14));
        dataset.setValue(tiempo(matrizn, matrizm, 15),"Metodo 1", nombre(15));
        JFreeChart chart = ChartFactory.createBarChart("Algoritmos", "Algoritmos", "Tiempo", dataset, PlotOrientation.VERTICAL, false, true, false);
        ChartPanel chartPanel = new ChartPanel(chart);
        add(chartPanel, BorderLayout.CENTER);

    }

}