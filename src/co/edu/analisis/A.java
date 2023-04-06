package co.edu.analisis;

import java.awt.Font;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.StandardChartTheme;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class A {

    public static void main(String[] args) {

		StandardChartTheme theme = new StandardChartTheme("Custom Theme");

		theme.setExtraLargeFont(new Font("TW Cen MT", Font.BOLD, 20));
		theme.setLargeFont(new Font("TW Cen MT", Font.BOLD, 18));
		theme.setRegularFont(new Font("TW Cen MT", Font.PLAIN, 11));
		
		ChartFactory.setChartTheme(theme);
    	
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        // Agregamos los valores al dataset
        dataset.addValue(10, "A", "Categoría 1");
        dataset.addValue(20, "B", "Categoría 1");
        dataset.addValue(15, "C", "Categoría 1");
        dataset.addValue(12, "A", "Categoría 2");
        dataset.addValue(25, "B", "Categoría 2");
        dataset.addValue(18, "C", "Categoría 2");
        dataset.addValue(8, "A", "Categoría 3");
        dataset.addValue(15, "B", "Categoría 3");
        dataset.addValue(20, "C", "Categoría 3");

        // Creamos el objeto JFreeChart con los valores del dataset
        JFreeChart chart = ChartFactory.createBarChart(
            "Ejemplo de gráfico de barras", // Título del gráfico
            "Categorías", // Etiqueta del eje X
            "Valores", // Etiqueta del eje Y
            dataset, // Datos
            PlotOrientation.VERTICAL, // Orientación del gráfico
            true, // Incluye leyenda
            true, // Incluye tooltips
            false // Incluye URLs
        );

        // Mostramos el gráfico en una ventana
        ChartFrame frame = new ChartFrame("Gráfico de barras", chart);
        frame.pack();
        frame.setVisible(true);
    }

}

