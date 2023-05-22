package co.edu.uniquindio.analisis.proyectosegundo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Aplicacion {

	public static void main(String[] args) {

		int x = 10;
		
		for (int n = 1; n <= 8; n ++) {

			int[] a = leerCasosEstatico("Caso" + "-" + n + ".txt", x);
			int[] b = leerCasosEstatico("Caso" + "-" + n + ".txt", x);
			ArrayList<Integer> dinamicoa = leerCasosDinamico("Caso" + "-" + n + ".txt", x);
			ArrayList<Integer> dinamicob = leerCasosDinamico("Caso" + "-" + n + ".txt", x);
			x += 10;
			for (int i = 1; i <= 15; i++) {
				resultado(a, b, dinamicoa, dinamicob, i);
			}
		}
	}

	public static String obtenerNombre(int metodo) {
		Metodo mapa = new Metodo();

		String nombreMetodo = " ";
		nombreMetodo = mapa.obtenerNombre(metodo);

		return nombreMetodo;
	}
	
	public static void resultado(int[] a, int[] b, ArrayList<Integer> dinamicoa, ArrayList<Integer> dinamicob,
			int metodo) {
		Captura captura = new Captura();

		String nombreMetodo = " ";
		String nombreArregloa = "~A";
		String nombreArreglob = "~B";
		String nombreResultado = "~C";

		nombreMetodo = obtenerNombre(metodo);
		Object[] resultado = captura.consultaMetodo(a, b, dinamicoa, dinamicob, metodo);

		long tiempo = (long) resultado[0];

		System.out.println("Numero del metodo: " + metodo);

		if (metodo == 2 || metodo == 4 || metodo == 6 || metodo == 8) {

			ArrayList<Integer> respuesta = (ArrayList<Integer>) resultado[1];

			imprimirDinamico(dinamicoa, nombreArregloa);
			imprimirDinamico(dinamicob, nombreArreglob);
			imprimirDinamico(respuesta, nombreResultado);
		} else {

			int[] respuesta = (int[]) resultado[1];

			imprimirArreglo(a, nombreArregloa);
			imprimirArreglo(b, nombreArreglob);
			imprimirArreglo(respuesta, nombreResultado);
		}

		System.out.println("Tiempo: " + tiempo + " [milisegundos]" + "\n" + "Algoritmo: " + nombreMetodo + "\n");
	}

	public static void imprimirDinamico(ArrayList<Integer> arreglo, String nombre) {
		String formattedString = Arrays.toString(arreglo.toArray()).replace("[", "").replace("]", "");
		System.out.println("[" + nombre + "]: " + "[" + formattedString + "]");
		System.out.println("\n");
	}

	public static void imprimirArreglo(int[] arreglo, String nombre) {
		System.out.println("[" + nombre + "]: " + Arrays.toString(arreglo));
		System.out.println("\n");
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
