package co.edu.uniquindio.analisis.proyectosegundo;

import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableRowSorter;

import org.apache.commons.math3.stat.descriptive.moment.Mean;
import org.apache.commons.math3.stat.descriptive.moment.StandardDeviation;
import org.apache.commons.math3.stat.descriptive.moment.Variance;
import org.apache.commons.math3.stat.descriptive.*;
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
import org.jfree.data.Range;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RectangleInsets;
import org.jfree.ui.RefineryUtilities;
import org.jfree.ui.TextAnchor;
import org.jfree.util.SortOrder;

public class Graficacion extends ApplicationFrame {

	final static int M = 15;
	final static int P = 8;
	static long[][] registro = new long[M][P];
	static ArrayList<Object[]> listaPromedio = new ArrayList<Object[]>();
	static ArrayList<Object[]> listaOrdenado = new ArrayList<Object[]>();

	public static void main(String[] args) {

		Graficacion chart = new Graficacion("Algoritmos");
		chart.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		chart.setExtendedState(JFrame.MAXIMIZED_BOTH);
		chart.setVisible(true);
	}

	public static long tiempo(int[] a, int[] b, ArrayList<Integer> dinamicoa, ArrayList<Integer> dinamicob,
							  int metodo) {
		Captura captura = new Captura();

		Object[] resultado = captura.consultaMetodo(a, b, dinamicoa, dinamicob, metodo);

		long tiempo = (long) resultado[0];
		return tiempo;
	}

	public static String obtenerNombre(int metodo) {
		Metodo mapa = new Metodo();

		String nombreMetodo = " ";
		nombreMetodo = mapa.obtenerNombre(metodo);

		return nombreMetodo;
	}

	public static void promedio(int metodo) {

		String nombre = "";
		long suma = 0;
		long promedio = 0;

		for (int i = 0; i < P; i++) {
			suma += registro[metodo - 1][i];
		}

		promedio = suma / P;
		nombre = obtenerNombre(metodo);

		Object[] respuesta = { nombre, promedio };

		listaPromedio.add(respuesta);
	}

	public static void ordenar() {

		Collections.sort(listaOrdenado, new Comparator<Object[]>() {
			@Override
			public int compare(Object[] o1, Object[] o2) {
				return ((Long) o1[1]).compareTo((Long) o2[1]);
			}
		});
	}

	public static void recorrer(int metodo) {

		int n = 10;
		for (int j = 1; j <= P; j++) {

			int[] a = leerCasosEstatico("Caso" + "-" + j + ".txt", n);
			int[] b = leerCasosEstatico("Caso" + "-" + j + ".txt", n);
			ArrayList<Integer> dinamicoa = leerCasosDinamico("Caso" + "-" + j + ".txt", n);
			ArrayList<Integer> dinamicob = leerCasosDinamico("Caso" + "-" + j + ".txt", n);

			registro[metodo - 1][j - 1] = tiempo(a, b, dinamicoa, dinamicob, metodo);
			n = +10;
		}

	}

	private static int[] leerCasosEstatico(String fileName, int n) {
		int[] array = new int[n];
		try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
			String line = reader.readLine();
			String[] digits = line.substring(1, line.length() - 1).split(", ");
			for (int i = 0; i < n; i++) {
				array[i] = Integer.parseInt(digits[i]);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return array;
	}

	private static ArrayList<Integer> leerCasosDinamico(String fileName, int n) {
		ArrayList<Integer> arrayList = new ArrayList<>();
		try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
			String line = reader.readLine();
			String[] digits = line.substring(1, line.length() - 1).split(", ");
			for (int i = 0; i < n; i++) {
				arrayList.add(Integer.parseInt(digits[i]));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return arrayList;
	}

	public Graficacion(String title) {
		super(title);

		StandardChartTheme theme = new StandardChartTheme("Custom Theme");

		theme.setExtraLargeFont(new Font("TW Cen MT", Font.BOLD, 20));
		theme.setLargeFont(new Font("TW Cen MT", Font.BOLD, 18));
		theme.setRegularFont(new Font("TW Cen MT", Font.PLAIN, 11));

		ChartFactory.setChartTheme(theme);

		for (int i = 1; i <= M; i++) {
			recorrer(i);
		}

		for (int i = 1; i <= M; i++) {
			promedio(i);
		}

		listaOrdenado.addAll(listaPromedio);

		ordenar();

		// C?lculo del ancho m?ximo de la columna de nombres
		int nameWidth = 0;
		for (int fila = 0; fila < registro.length; fila++) {
			int nameLength = obtenerNombre(fila + 1).length();
			if (nameLength > nameWidth) {
				nameWidth = nameLength;
			}
		}

		// C?lculo del ancho m?ximo de cada columna
		int[] columnWidths = new int[registro[0].length];
		for (int fila = 0; fila < registro.length; fila++) {
			for (int columna = 0; columna < registro[fila].length; columna++) {
				int numberLength = Integer.toString((int) registro[fila][columna]).length();
				if (numberLength > columnWidths[columna]) {
					columnWidths[columna] = numberLength;
				}
			}
		}

		// Imprimir los datos con el ancho m?ximo de cada columna
		try {
			FileWriter writer = new FileWriter("registros.txt", true);


			for (int fila = 0; fila < registro.length; fila++) {

				writer.write(String.format("%-" + (nameWidth + 1) + "s |", obtenerNombre(fila + 1)));
				for (int columna = 0; columna < registro[fila].length; columna++) {

					writer.write(String.format("%" + (columnWidths[columna] + 1) + "d |", registro[fila][columna]));

				}
				writer.write("\n");
			}
			writer.write("\n");
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}


		DefaultCategoryDataset dataset1 = new DefaultCategoryDataset();

		for (Object[] arreglo : listaPromedio) {
			long tiempo = (long) arreglo[1];
			String nombre = (String) arreglo[0];
			dataset1.setValue(tiempo, "Metodo", nombre);
		}

		JFreeChart chart1 = ChartFactory.createBarChart("Promedio", " M?todos ", "Tiempo {nanosegundos}", dataset1,
				PlotOrientation.VERTICAL, false, true, false);

		CategoryPlot plot1 = (CategoryPlot) chart1.getPlot();
		BarRenderer renderer1 = (BarRenderer) plot1.getRenderer();
		renderer1.setBaseItemLabelGenerator(
				new StandardCategoryItemLabelGenerator("{2}", NumberFormat.getNumberInstance()));
		renderer1.setBaseItemLabelsVisible(true);
		renderer1.setItemLabelAnchorOffset(0);
		renderer1.setItemLabelsVisible(true);
		renderer1.setDrawBarOutline(false);
		chart1.setBackgroundPaint(Color.WHITE);

		plot1.setRangeGridlinePaint(Color.WHITE);

		CategoryAxis axis = plot1.getDomainAxis();
		NumberAxis yAxis = (NumberAxis) plot1.getRangeAxis();
		yAxis.setNumberFormatOverride(new DecimalFormat("#"));
		axis.setCategoryMargin(0.5);

		DefaultCategoryDataset dataset2 = new DefaultCategoryDataset();

		for (Object[] arreglo : listaOrdenado) {
			long tiempo = (long) arreglo[1];
			String nombre = (String) arreglo[0];
			dataset2.setValue(tiempo, "Metodo", nombre);
		}

		JFreeChart chart2 = ChartFactory.createBarChart("Orden Ascendente", " M?todos ", "Tiempo {nanosegundos}",
				dataset2, PlotOrientation.VERTICAL, false, true, false);

		CategoryPlot plot2 = (CategoryPlot) chart2.getPlot();
		BarRenderer renderer2 = (BarRenderer) plot2.getRenderer();
		renderer2.setBaseItemLabelGenerator(
				new StandardCategoryItemLabelGenerator("{2}", NumberFormat.getNumberInstance()));
		renderer2.setBaseItemLabelsVisible(true);
		renderer2.setItemLabelAnchorOffset(0);
		renderer2.setItemLabelsVisible(true);
		renderer2.setDrawBarOutline(false);
		chart2.setBackgroundPaint(Color.WHITE);

		plot2.setRangeGridlinePaint(Color.WHITE);

		CategoryAxis axis2 = plot2.getDomainAxis();
		NumberAxis yAxis2 = (NumberAxis) plot2.getRangeAxis();
		yAxis2.setNumberFormatOverride(new DecimalFormat("#"));
		axis2.setCategoryMargin(0.5);

		DefaultTableModel tableModel = new DefaultTableModel();
		tableModel.addColumn("M?todo");
		tableModel.addColumn("Media");
		tableModel.addColumn("Rango");
		tableModel.addColumn("Desviaci?n est?ndar");
		tableModel.addColumn("Varianza");

		for (int i = 0; i < registro.length; i++) {
			String metodo = obtenerNombre(i + 1);
			long[] datos = registro[i];

			long media = media(i);
			long rango = rango(i);
			long desviacion = (long) new StandardDeviation().evaluate(convertirDouble(datos));
			long varianza = (long) new Variance().evaluate(convertirDouble(datos));

			tableModel.addRow(new Object[] { metodo, media, rango, desviacion, varianza });
		}

		JTable table = new JTable(tableModel);

		DefaultCategoryDataset dataset3 = new DefaultCategoryDataset();

		for (int i = 0; i < registro.length; i++) {
			for (int j = 0; j < registro[i].length; j++) {
				dataset3.setValue(registro[i][j], "Tama?o: " + j, obtenerNombre(i + 1));
			}
		}

		JFreeChart chart3 = ChartFactory.createBarChart("Orden Ascendente", " M?todos ", "Tiempo {nanosegundos}",
				dataset3, PlotOrientation.VERTICAL, true, true, false);

		CategoryPlot plot3 = (CategoryPlot) chart3.getPlot();
		BarRenderer renderer3 = (BarRenderer) plot3.getRenderer();
		renderer3.setBaseItemLabelGenerator(
				new StandardCategoryItemLabelGenerator("{2}", NumberFormat.getNumberInstance()));
		renderer3.setBaseItemLabelsVisible(true);
		renderer3.setItemLabelAnchorOffset(0);
		renderer3.setItemLabelsVisible(true);
		renderer3.setDrawBarOutline(false);
		chart3.setBackgroundPaint(Color.WHITE);

		plot3.setRangeGridlinePaint(Color.WHITE);

		CategoryAxis axis3 = plot3.getDomainAxis();
		NumberAxis yAxis3 = (NumberAxis) plot3.getRangeAxis();
		yAxis3.setNumberFormatOverride(new DecimalFormat("#"));
		axis3.setCategoryMargin(0.3);

		DefaultTableModel tableModel2 = new DefaultTableModel();

		tableModel2.addColumn("M?todo");

		int[] elevacion = new int[P];

		int x = 10;

		for (int i = 1; i <= P; i++) {
			int resultado = x;

			tableModel2.addColumn("t: " + i + "[" + resultado + "]");
			elevacion[i - 1] = resultado;
			x += 10;
		}

		for (int i = 0; i < registro.length; i++) {
			String metodo = obtenerNombre(i + 1);
			long[] datos = registro[i];

			Object[] row = new Object[elevacion.length + 1];
			row[0] = metodo;

			for (int j = 0; j < elevacion.length; j++) {
				row[j + 1] = datos[j];
			}

			tableModel2.addRow(row);
		}

		JTable table2 = new JTable(tableModel2);

		JPanel chartPanel1 = new ChartPanel(chart1);
		chartPanel1.setPreferredSize(new Dimension(1000, 900));

		JPanel chartPanel2 = new ChartPanel(chart2);
		chartPanel2.setPreferredSize(new Dimension(1000, 900));

		JScrollPane tablePanel = new JScrollPane(table);
		TitledBorder titledBorder = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK),
				"Representacion", TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION,
				new Font("TW Cen MT", Font.BOLD, 22));
		tablePanel.setBorder(titledBorder);

		JTableHeader header = table.getTableHeader();

		Font headerFont = new Font("TW Cen MT", Font.BOLD, 18);
		header.setFont(headerFont);

		Font cellFont = new Font("TW Cen MT", Font.PLAIN, 14);
		table.setFont(cellFont);

		DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
		renderer.setFont(cellFont);
		table.setDefaultRenderer(Object.class, renderer);

		tablePanel.setPreferredSize(new Dimension(1000, 320));

		JPanel chartPanel3 = new ChartPanel(chart3);
		chartPanel3.setPreferredSize(new Dimension(1000, 900));

		JScrollPane tablePanel2 = new JScrollPane(table2);
		TitledBorder titledBorder2 = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK),
				"Llenado de datos", TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION,
				new Font("TW Cen MT", Font.BOLD, 22));
		tablePanel2.setBorder(titledBorder2);

		JTableHeader header2 = table2.getTableHeader();

		Font headerFont2 = new Font("TW Cen MT", Font.BOLD, 18);
		header2.setFont(headerFont2);

		Font cellFont2 = new Font("TW Cen MT", Font.PLAIN, 14);
		table2.setFont(cellFont2);

		DefaultTableCellRenderer renderert = new DefaultTableCellRenderer();
		renderert.setFont(cellFont2);
		table2.setDefaultRenderer(Object.class, renderert);

		tablePanel2.setPreferredSize(new Dimension(1000, 320));

		JPanel chartContainer = new JPanel();
		chartContainer.setLayout(new BorderLayout());
		chartContainer.add(chartPanel1, BorderLayout.NORTH);

		JPanel centerPanel = new JPanel(new BorderLayout());
		centerPanel.add(chartPanel2, BorderLayout.NORTH);
		centerPanel.add(chartPanel3, BorderLayout.CENTER);
		centerPanel.add(tablePanel2, BorderLayout.SOUTH);

		chartContainer.add(centerPanel, BorderLayout.CENTER);
		chartContainer.add(tablePanel, BorderLayout.SOUTH);

		JScrollPane scrollPane = new JScrollPane(chartContainer);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

		CategoryAxis xAxis = chart1.getCategoryPlot().getDomainAxis();
		xAxis.setCategoryLabelPositions(CategoryLabelPositions.DOWN_90);

		CategoryAxis xAxis1 = chart2.getCategoryPlot().getDomainAxis();
		xAxis1.setCategoryLabelPositions(CategoryLabelPositions.DOWN_90);

		CategoryAxis xAxis3 = chart3.getCategoryPlot().getDomainAxis();
		xAxis3.setCategoryLabelPositions(CategoryLabelPositions.DOWN_90);

		setContentPane(scrollPane);
		pack();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}

	public static long media(int metodo) {

		long suma = 0;

		for (int i = 0; i < P; i++) {
			suma += registro[metodo][i];
		}

		return suma / P;
	}

	public static long rango(int metodo) {
		long[] datos = registro[metodo];
		long min = datos[0];
		long max = datos[0];
		for (int i = 1; i < datos.length; i++) {
			if (datos[i] < min) {
				min = datos[i];
			} else if (datos[i] > max) {
				max = datos[i];
			}
		}
		return max - min;
	}

	public static double[] convertirDouble(long[] array) {
		double[] result = new double[array.length];
		for (int i = 0; i < array.length; i++) {
			result[i] = (double) array[i];
		}
		return result;
	}

}