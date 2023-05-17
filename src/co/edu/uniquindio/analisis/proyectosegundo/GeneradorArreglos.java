package co.edu.uniquindio.analisis.proyectosegundo;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

public class GeneradorArreglos {

	public static void main(String[] args) {
		int n = 10;

		// Crear 8 casos de prueba
		for (int i = 1; i <= 8; i++) {
			int[] a = generateRandomArray(n);
			writeTestCaseToFile(a, "Caso" + "-" + i + ".txt");
			n += 500;
		}
	}

	// Generar un arreglo de enteros aleatorios con n elementos
	private static int[] generateRandomArray(int n) {
		int[] array = new int[n];
		Random random = new Random();
		array[0] = random.nextInt(9) + 1;
		for (int i = 1; i < n; i++) {
			array[i] = random.nextInt(10);
		}
		return array;
	}

	// Escribir los dos arreglos de enteros en un archivo de texto
	private static void writeTestCaseToFile(int[] a, String fileName) {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
			writer.write(Arrays.toString(a));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
