package co.edu.uniquindio.analisis.proyectosegundo.metodos;

import java.util.Arrays;

public class DivideVencerasI {

	public int[] multiplicacionDivideVenceras(int[] num1, int[] num2) {
		int tam = num1.length + num2.length;
		int tamArreglos = 0;
		int[] resultado = new int[tam];
		int multiplicador = 0;
		int multiplicado = 0;
		int[] result;
		int desplazo = 0;

		// Determinar el tamaño del arreglo más grande
		if (num1.length > num2.length) {
			tamArreglos = num1.length;
		} else {
			tamArreglos = num2.length;
		}

		while ((tamArreglos & (tamArreglos - 1)) != 0) {
			tamArreglos++;
		}

		int[] aux1 = new int[tamArreglos];
		int[] aux2 = new int[tamArreglos];

		// Llenar los arreglos auxiliares con los números originales
		for (int j = tamArreglos - num1.length, y = 0; j < aux1.length; j++, y++) {
			aux1[j] = num1[y];
		}
		for (int j = tamArreglos - num2.length, y = 0; j < aux2.length; j++, y++) {
			aux2[j] = num2[y];
		}
		StringBuilder sb = new StringBuilder();
		StringBuilder sb2 = new StringBuilder();

		// Realizar la multiplicación para la primera mitad de los arreglos
		for (int i = 0; i < aux1.length / 2; i++) {
			sb.append(aux1[i]);
			sb2.append(aux2[i]);
			String numeroConcatenadoStr = sb.toString();
			String numeroConcatenadoStr2 = sb2.toString();
			try {
				multiplicador = Integer.parseInt(numeroConcatenadoStr);
				multiplicado = Integer.parseInt(numeroConcatenadoStr2);
			} catch (NumberFormatException e) {
				System.out.print("");

			}
		}

		desplazo = aux1.length;

		int[] multiplicadoA = guardarNumeroEnArreglo(multiplicado);
		int[] multiplicadorA = guardarNumeroEnArreglo(multiplicador);

		result = americano(multiplicadoA, multiplicadorA);
		guardarNumeroArreglo(result, desplazo, resultado);

		// Reiniciar los StringBuilder para el siguiente cálculo
		sb = new StringBuilder();
		sb2 = new StringBuilder();

		// Realizar la multiplicación para la segunda mitad de los arreglos
		for (int i = 0, j = aux2.length / 2; i < aux1.length / 2; i++, j++) {
			sb.append(aux1[i]);
			sb2.append(aux2[j]);
			String numeroConcatenadoStr = sb.toString();
			String numeroConcatenadoStr2 = sb2.toString();
			try {
				multiplicador = Integer.parseInt(numeroConcatenadoStr);
				multiplicado = Integer.parseInt(numeroConcatenadoStr2);
			} catch (NumberFormatException e) {
				System.out.print("");

			}
		}
		desplazo = aux1.length / 2;
		multiplicadoA = guardarNumeroEnArreglo(multiplicado);
		multiplicadorA = guardarNumeroEnArreglo(multiplicador);
		result = americano(multiplicadoA, multiplicadorA);
		guardarNumeroArreglo(result, desplazo, resultado);

		// Reiniciar los StringBuilder para el siguiente cálculo
		sb = new StringBuilder();
		sb2 = new StringBuilder();

		// Realizar la multiplicación para la tercera combinación de mitades de los arreglos
		for (int i = 0, j = aux2.length / 2; i < aux1.length / 2; i++, j++) {
			sb.append(aux1[j]);
			sb2.append(aux2[i]);
			String numeroConcatenadoStr = sb.toString();
			String numeroConcatenadoStr2 = sb2.toString();
			try {
				multiplicador = Integer.parseInt(numeroConcatenadoStr);
				multiplicado = Integer.parseInt(numeroConcatenadoStr2);
			} catch (NumberFormatException e) {
				System.out.print("");

			}
		}
		multiplicadoA = guardarNumeroEnArreglo(multiplicado);
		multiplicadorA = guardarNumeroEnArreglo(multiplicador);
		result = americano(multiplicadoA, multiplicadorA);
		guardarNumeroArreglo(result, desplazo, resultado);

		// Reiniciar los StringBuilder para el siguiente cálculo
		sb = new StringBuilder();
		sb2 = new StringBuilder();

		// Realizar la multiplicación para la última parte de los arreglos
		for (int j = aux2.length / 2; j < aux1.length; j++) {
			sb.append(aux1[j]);
			sb2.append(aux2[j]);
			String numeroConcatenadoStr = sb.toString();
			String numeroConcatenadoStr2 = sb2.toString();
			try {
				multiplicador = Integer.parseInt(numeroConcatenadoStr);
				multiplicado = Integer.parseInt(numeroConcatenadoStr2);
			} catch (NumberFormatException e) {
				System.out.print("");

			}
		}
		desplazo = 0;
		multiplicadoA = guardarNumeroEnArreglo(multiplicado);
		multiplicadorA = guardarNumeroEnArreglo(multiplicador);
		result = americano(multiplicadoA, multiplicadorA);
		guardarNumeroArreglo(result, desplazo, resultado);
		ordernarArreglo(resultado);
		return resultado;
	}

	/**
	 * Guarda un n�mero entero en un arreglo, donde cada elemento del arreglo
	 * representa un d�gito del n�mero.
	 *
	 * @param numero El n�mero entero a ser guardado en el arreglo.
	 * @return Un arreglo de enteros que representa el n�mero.
	 */
	public static int[] guardarNumeroEnArreglo(int numero) {

		String numeroStr = String.valueOf(numero);

		int longitud = numeroStr.length();

		int[] arreglo = new int[longitud];

		for (int i = 0; i < longitud; i++) {
			char digitoChar = numeroStr.charAt(i);
			int digito = Character.getNumericValue(digitoChar);
			arreglo[i] = digito;
		}
		return arreglo;
	}

	/**
	 * Realiza la suma de dos arreglos de números enteros teniendo en cuenta un desplazamiento.
	 *
	 * @param numero    El primer arreglo de números enteros.
	 * @param desplazo  El desplazamiento a tener en cuenta al realizar la suma.
	 * @param resultado El arreglo en el que se almacenará el resultado de la suma.
	 * @return El arreglo resultado con la suma realizada.
	 */
	public static int[] guardarNumeroArreglo(int[] numero, int desplazo, int[] resultado) {
		int longitud = numero.length;

		for (int i = longitud - 1, j = resultado.length - desplazo - 1; i >= 0; i--, j--) {
			resultado[j] += numero[i];
		}
		return resultado;
	}

	/**
	 * Realiza la multiplicación de dos arreglos de números enteros en el estilo americano.
	 *
	 * @param arreglo1 El primer arreglo de números enteros.
	 * @param arreglo2 El segundo arreglo de números enteros.
	 * @return El arreglo resultado de la multiplicación.
	 */
	public static int[] americano(int arreglo1[], int arreglo2[]) {
		int k = arreglo1.length + arreglo2.length - 1;
		int pos = arreglo1.length + arreglo2.length - 1;
		int resultado[] = new int[arreglo1.length + arreglo2.length];

		for (int i = arreglo1.length - 1; i >= 0; i--) {
			for (int j = arreglo2.length - 1; j >= 0; j--) {
				resultado[k] = resultado[k] + arreglo1[i] * arreglo2[j];

				if (resultado[k] > 9) {
					resultado[k - 1] += resultado[k] / 10;
					resultado[k] = resultado[k] % 10;
				}
				k--;
			}
			k = pos;
			pos--;
			k--;
		}
		return resultado;
	}

	/**
	 * Ordena el arreglo resultado de manera adecuada.
	 *
	 * @param resultado El arreglo que se desea ordenar.
	 */
	public static void ordernarArreglo(int[] resultado) {

		for (int i = resultado.length - 1; i >= 0; i--) {

			if (resultado[i] > 9) {

				resultado[i - 1] += resultado[i] / 10;

				resultado[i] = resultado[i] % 10;
			} else {

			}
		}
	}

}