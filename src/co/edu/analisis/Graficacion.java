package co.edu.analisis;

import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableRowSorter;

import co.edu.analisis.model.Captura;
import co.edu.analisis.model.Metodo;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.StandardChartTheme;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.DataUtilities;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RectangleInsets;
import org.jfree.ui.RefineryUtilities;
import org.jfree.ui.TextAnchor;
import org.jfree.util.SortOrder;

public class Graficacion extends ApplicationFrame {

	public static void main(String[] args) {

		Graficacion chart = new Graficacion("Algoritmos");
		chart.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		chart.setExtendedState(JFrame.MAXIMIZED_BOTH);
		chart.setVisible(true);
	}

	public static long tiempo(double[][] matrizn, double[][] matrizm, int metodo) {
		Captura captura = new Captura();

		Object[] resultado = captura.consultaMetodo(matrizn, matrizm, metodo);

		long tiempo = (long) resultado[0];
		return tiempo;
	}

	public static String obtenernombre(int metodo) {
		Metodo met = new Metodo();

		String nombreMetodo = " ";
		nombreMetodo = met.obtenerNombre(metodo);

		return nombreMetodo;
	}
	
	public static long promedio(int x) {

		int numeroMatrices = 8;
		long promedio;
		long sum = 0;
		for (int i = 1; i <= numeroMatrices; i++) {
			double[][] matrizn = leerMatrix("Matriz " + i + ".txt");
			double[][] matrizm = leerMatrix("Matriz " + i + ".txt");
			sum += tiempo(matrizn, matrizm, x);
		}
		promedio = sum / numeroMatrices;
		return promedio;

	}

	public Graficacion(String title) {
		super(title);

		StandardChartTheme theme = new StandardChartTheme("Custom Theme");

		theme.setExtraLargeFont(new Font("TW Cen MT", Font.BOLD, 20));
		theme.setLargeFont(new Font("TW Cen MT", Font.BOLD, 18));
		theme.setRegularFont(new Font("TW Cen MT", Font.PLAIN, 11));
		
		ChartFactory.setChartTheme(theme);

		DefaultCategoryDataset dataset1 = new DefaultCategoryDataset();

		for (int k = 1; k <= 16; k++) {
			dataset1.setValue(promedio(k), "Metodo", obtenernombre(k));
		}

		JFreeChart chart1 = ChartFactory.createBarChart("Promedio", " Métodos ", "Tiempo", dataset1, PlotOrientation.VERTICAL, false, true, false);

		CategoryPlot plot1 = (CategoryPlot) chart1.getPlot();
		BarRenderer renderer1 = (BarRenderer) plot1.getRenderer();
		renderer1.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator("{2}", NumberFormat.getNumberInstance()));
		renderer1.setBaseItemLabelsVisible(true);
		renderer1.setItemLabelAnchorOffset(0);
		renderer1.setItemLabelsVisible(true);
		renderer1.setDrawBarOutline(false);
		chart1.setBackgroundPaint(Color.WHITE);

		plot1.setRangeGridlinePaint(Color.BLACK);

		CategoryAxis axis = plot1.getDomainAxis();
		axis.setCategoryMargin(0.5);

		DefaultCategoryDataset dataset2 = new DefaultCategoryDataset();

		for (int i = 0; i < dataset1.getRowCount(); i++) {
			Comparable rowKey = dataset1.getRowKey(i);
			for (int j = 0; j < dataset1.getColumnCount(); j++) {
				Comparable columnKey = dataset1.getColumnKey(j);
				Number value = dataset1.getValue(i, j);
				dataset2.setValue(value, rowKey, columnKey);
			}
		}

		ArrayList<Double> values = new ArrayList<>();
		for (int i = 0; i < dataset2.getRowCount(); i++) {
			for (int j = 0; j < dataset2.getColumnCount(); j++) {
				Number value = dataset2.getValue(i, j);
				if (value != null) {
					values.add(value.doubleValue());
				}
			}
		}

		Collections.sort(values);

		int index = 0;
		for (int i = 0; i < dataset2.getRowCount(); i++) {
			for (int j = 0; j < dataset2.getColumnCount(); j++) {
				Number value = dataset2.getValue(i, j);
				if (value != null) {
					dataset2.setValue(values.get(index++), dataset2.getRowKey(i), dataset2.getColumnKey(j));
				}
			}
		}

		JFreeChart chart2 = ChartFactory.createBarChart("Orden Ascendente", " Métodos ", "Tiempo", dataset2, PlotOrientation.VERTICAL, false, true, false);

		CategoryPlot plot2 = (CategoryPlot) chart2.getPlot();
		BarRenderer renderer2 = (BarRenderer) plot2.getRenderer();
		renderer2.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator("{2}", NumberFormat.getNumberInstance()));
		renderer2.setBaseItemLabelsVisible(true);
		renderer2.setItemLabelAnchorOffset(0);
		renderer2.setItemLabelsVisible(true);
		renderer2.setDrawBarOutline(false);
		chart2.setBackgroundPaint(Color.WHITE);

		plot2.setRangeGridlinePaint(Color.BLACK);

		CategoryAxis axis2 = plot2.getDomainAxis();
		axis2.setCategoryMargin(0.5);
		
		DefaultTableModel tableModel = new DefaultTableModel();
		tableModel.addColumn("Método");
		tableModel.addColumn("Media");
		tableModel.addColumn("Rango");
		tableModel.addColumn("Desviación estándar");
		tableModel.addColumn("Varianza");
		tableModel.addRow(new Object[]{"Celda 1", "Celda 2"});
		tableModel.addRow(new Object[]{"Celda 3", "Celda 4"});

		JTable table = new JTable(tableModel);

		JPanel chartPanel1 = new ChartPanel(chart1);
		chartPanel1.setPreferredSize(new Dimension(1000, 800));

		JPanel chartPanel2 = new ChartPanel(chart2);
		chartPanel2.setPreferredSize(new Dimension(1000, 800));

		JScrollPane tablePanel = new JScrollPane(table);
		TitledBorder titledBorder = BorderFactory.createTitledBorder(
		        BorderFactory.createLineBorder(Color.BLACK), "Representacion",
		        TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION,
		        new Font("TW Cen MT", Font.BOLD, 22));
		tablePanel.setBorder(titledBorder);
		
		tablePanel.setPreferredSize(new Dimension(1000, 800));
		
//		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);		
//		table.getColumnModel().getColumn(0).setPreferredWidth(200);
//		table.getColumnModel().getColumn(1).setPreferredWidth(200);
		
		JPanel chartContainer = new JPanel();
		chartContainer.setLayout(new BorderLayout());
		chartContainer.add(chartPanel1, BorderLayout.NORTH);
		chartContainer.add(chartPanel2, BorderLayout.CENTER);
		chartContainer.add(tablePanel, BorderLayout.SOUTH);

		JScrollPane scrollPane = new JScrollPane(chartContainer);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

		CategoryAxis xAxis = chart1.getCategoryPlot().getDomainAxis();
		xAxis.setCategoryLabelPositions(CategoryLabelPositions.DOWN_90);

		CategoryAxis xAxis1 = chart2.getCategoryPlot().getDomainAxis();
		xAxis1.setCategoryLabelPositions(CategoryLabelPositions.DOWN_90);
		

		setContentPane(scrollPane);
		pack();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
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