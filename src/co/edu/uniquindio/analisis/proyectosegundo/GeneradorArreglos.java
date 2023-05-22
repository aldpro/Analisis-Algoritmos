package co.edu.uniquindio.analisis.proyectosegundo;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

public class GeneradorArreglos {

	public static void main(String[] args) {
		int n = 10;

		// Crea los casos de prueba
		for (int i = 1; i <= 8; i++) {
			int[] a = generateRandomArray(n);
			writeTestCaseToFile(a, "Caso" + "-" + i + ".txt");
			n += 10;
		}
	}

	/**
	 * Generar un arreglo de enteros aleatorios con n elementos
	 * 
	 * @param n
	 * @return arreglo
	 */
	private static int[] generateRandomArray(int n) {
		int[] array = new int[n];
		Random random = new Random();
		array[0] = random.nextInt(9) + 1;
		for (int i = 1; i < n; i++) {
			array[i] = random.nextInt(10);
		}
		return array;
	}

	/**
	 * Escribir los dos arreglos de enteros en un archivo de texto
	 * 
	 * @param a
	 * @param fileName
	 */
	private static void writeTestCaseToFile(int[] a, String fileName) {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
			writer.write(Arrays.toString(a));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
