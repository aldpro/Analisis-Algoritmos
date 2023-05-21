package co.edu.uniquindio.analisis.proyectosegundo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Aplicacion {

	public static void main(String[] args) {

		int[] a = leerCasosPruebas("Caso" + "-" + 1 + ".txt", 10);
		int[] b = leerCasosPruebas("Caso" + "-" + 1 + ".txt", 10);

		for (int i = 1; i <= 15; i++) {
			resultado(a, b, i);
		}
	}

	public static void resultado(int[] a, int[] b, int metodo) {
		Captura captura = new Captura();
		Metodo mapa = new Metodo();

		String nombreMetodo = " ";

		nombreMetodo = mapa.obtenerNombre(metodo);
		Object[] resultado = captura.consultaMetodo(a, b, metodo);

		long tiempo = (long) resultado[0];
		int[] matrizResultado = (int[]) resultado[1];

		imprimirArreglo(a, "Matriz A");
		imprimirArreglo(b, "Matriz B");
		imprimirArreglo(matrizResultado, "Matriz C");

		System.out.println("Tiempo: " + tiempo + " [milisegundos]" + "\n" + "Algoritmo: " + nombreMetodo + "\n");
	}

	public static void imprimirArreglo(int[] arreglo, String nombre) {
		System.out.println("[" + nombre + "]: " + Arrays.toString(arreglo));
		System.out.println();
	}

	private static int[] leerCasosPruebas(String fileName, int n) {
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

//	public static void main(String[] args) {
//		int n = 10;
//		for (int i = 1; i <= 8; i++) {
//			int[] a = leerCasosPruebas("Caso" + "-" + i + ".txt", n);
//
//			System.out.println("Test case " + i + ":");
//			System.out.println("a = " + Arrays.toString(a));
//			System.out.println();
//			n += 500;
//		}
//	}

}
