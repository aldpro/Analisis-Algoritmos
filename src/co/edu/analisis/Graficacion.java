package co.edu.analisis;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import co.edu.analisis.model.Captura;
import co.edu.analisis.model.Metodo;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.StandardChartTheme;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
import org.jfree.ui.TextAnchor;

public class Graficacion extends ApplicationFrame {

    public static void main(String[] args) {

        Graficacion chart = new Graficacion("Algoritmos");
        chart.setSize(1000, 600);
        chart.setLocationRelativeTo(null); // Centrar en pantalla
        chart.setVisible(true);
    }

    public static long tiempo (double[][] matrizn, double[][] matrizm, int metodo) {
        Captura captura = new Captura();

        Object[] resultado = captura.consultaMetodo(matrizn, matrizm, metodo);

        long tiempo = (long) resultado[0];
        return tiempo;
    }
    
    public static String nombre (int metodo) {
        Metodo met = new Metodo();

        String nombreMetodo = " ";

        nombreMetodo = met.obtenerNombre(metodo);

        return nombreMetodo;
    }

    public Graficacion(String title) {
        super(title);
        
        StandardChartTheme theme = new StandardChartTheme("Custom Theme");
        
        theme.setExtraLargeFont(new Font("TW Cen MT", Font.BOLD, 20));
        theme.setLargeFont(new Font("TW Cen MT", Font.BOLD, 18));
        theme.setRegularFont(new Font("TW Cen MT", Font.PLAIN, 16));
        
        ChartFactory.setChartTheme(theme);
        
        double[][] matrizn = leerMatrix("Matriz 1.txt");
        double[][] matrizm = leerMatrix("Matriz 1.txt");

        // Primer Dataset para el primer gr�fico de barras
        DefaultCategoryDataset dataset1 = new DefaultCategoryDataset();

        for (int i = 1; i <= 10; i++) {
        	dataset1.setValue(tiempo(matrizn, matrizm, i),"Metodo " + i, nombre(i));
		}
        
        JFreeChart chart1 = ChartFactory.createBarChart("Promedio", "Algoritmos", "Tiempo", dataset1, PlotOrientation.VERTICAL, false, true, false);
        
        CategoryPlot plot1 = (CategoryPlot) chart1.getPlot();
        BarRenderer renderer1 = (BarRenderer) plot1.getRenderer();
        renderer1.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator("{2}", NumberFormat.getNumberInstance()));
        renderer1.setBaseItemLabelsVisible(true);
        renderer1.setItemLabelAnchorOffset(0);
        renderer1.setItemLabelsVisible(true);
        
        ChartPanel chartPanel1 = new ChartPanel(chart1);
        chartPanel1.setPreferredSize(new Dimension(1000, 1000));
        
        // Crear el segundo dataset para el segundo gr�fico de barras
        DefaultCategoryDataset dataset2 = new DefaultCategoryDataset();
       

//        for (int i = 1; i <= 10; i++) {
//            dataset2.setValue(tiempo(matrizn2, matrizm2, i),"Metodo " + i, nombre(i));
//        }
        
        // Crear el segundo gr�fico de barras
        JFreeChart chart2 = ChartFactory.createBarChart("Algoritmos 2", "Algoritmos", "Tiempo", dataset1, PlotOrientation.VERTICAL, false, true, false);
        
        CategoryPlot plot2 = (CategoryPlot) chart2.getPlot();
        BarRenderer renderer2 = (BarRenderer) plot2.getRenderer();
        renderer2.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator("{2}", NumberFormat.getNumberInstance()));
        renderer2.setBaseItemLabelsVisible(true);
        renderer2.setItemLabelAnchorOffset(0);
        renderer2.setItemLabelsVisible(true);
        
        ChartPanel chartPanel2 = new ChartPanel(chart2);
        chartPanel2.setPreferredSize(new Dimension(1000, 1000));
        
        // Crear el panel para los gr�ficos
        JPanel panel = new JPanel(new GridLayout(2, 1)); // GridLayout con 2 filas y 1 columna
        
        // Agregar los gr�ficos al panel
        panel.add(new ChartPanel(chart1));
        panel.add(new ChartPanel(chart2));
        
        // Crear un JScrollPane para el panel y agregarlo al JFrame
        JScrollPane scrollPane = new JScrollPane(panel);
        add(scrollPane, BorderLayout.CENTER);
        
        CategoryAxis xAxis = chart1.getCategoryPlot().getDomainAxis();
        xAxis.setCategoryLabelPositions(CategoryLabelPositions.UP_90);
        
        CategoryAxis xAxis1 = chart2.getCategoryPlot().getDomainAxis();
        xAxis1.setCategoryLabelPositions(CategoryLabelPositions.UP_90);
    }
    
	public static double[][] leerMatrix(String fileName) {
	    double[][] matrix = null;
	    try {
	        BufferedReader reader = new BufferedReader(new FileReader(fileName));
	        String line;
	        int row = 0;
	        while ((line = reader.readLine()) != null) {
	            String[] values = line.split("\t");
	            if (matrix == null) {
	                matrix = new double[values.length][values.length];
	            }
	            for (int col = 0; col < values.length; col++) {
	                matrix[row][col] = Integer.parseInt(values[col]);
	            }
	            row++;
	        }
	        reader.close();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    return matrix;
	}

}