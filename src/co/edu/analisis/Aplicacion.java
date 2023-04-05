package co.edu.analisis;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import co.edu.analisis.model.Captura;
import co.edu.analisis.model.Metodo;

public class Aplicacion {

	public static void main(String[] args) {

		int j = 1;

		double[][] matrizn = leerMatrix("Matriz " + j + ".txt");
		double[][] matrizm = leerMatrix("Matriz " + j + ".txt");
		for (int i = 1; i <= 16; i++) {
			resultado(matrizn, matrizm, i);
		}


	}

	public static double arregloMatriz(double[][] matriz) {
		double maximo = Double.MIN_VALUE;
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				if (matriz[i][j] > maximo) {
					maximo = matriz[i][j];
				}
			}
		}
		return maximo;
	}

	public static void imprimirMatriz(double[][] matriz, String nombre) {
		int digitos = (int) Math.ceil(Math.log10(arregloMatriz(matriz)));

		System.out.println("Matriz [" + nombre + "]:");

		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				System.out.printf("%" + digitos + ".0f" + " ", matriz[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}

	public static void resultado (double[][] matrizn, double[][] matrizm, int metodo) {
		Captura captura = new Captura();
		Metodo met = new Metodo();

		String nombreMetodo = " ";

		nombreMetodo = met.obtenerNombre(metodo);
		Object[] resultado = captura.consultaMetodo(matrizn, matrizm, metodo);


		long tiempo = (long) resultado[0];
		double[][] matrizResultado = (double[][]) resultado[1];

		//imprimirMatriz(matrizn, "A");
		//imprimirMatriz(matrizm, "B");
		//imprimirMatriz(matrizResultado, "C");

		System.out.println("Tiempo: " + tiempo + " [milisegundos]" + "\n" + "Algoritmo: " + nombreMetodo + "\n");
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
