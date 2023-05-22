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
		
		for (int j = tamArreglos - num1.length, y = 0; j < aux1.length; j++, y++) {
			aux1[j] = num1[y];
		}
		for (int j = tamArreglos - num2.length, y = 0; j < aux2.length; j++, y++) {
			aux2[j] = num2[y];
		}
		StringBuilder sb = new StringBuilder();
		StringBuilder sb2 = new StringBuilder();
		
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
			    // Opcionalmente, puedes agregar un mensaje más descriptivo:
			    // System.out.println("Error: formato de número inválido. Cadena: " + numeroConcatenadoStr);
			    // System.out.println("Error: formato de número inválido. Cadena: " + numeroConcatenadoStr2);
			    // O bien, simplemente puedes no imprimir ningún mensaje adicional.
			}
		}
		
		desplazo = aux1.length;
		
		int[] multiplicadoA = guardarNumeroEnArreglo(multiplicado);
		int[] multiplicadorA = guardarNumeroEnArreglo(multiplicador);
		
		result = americano(multiplicadoA, multiplicadorA);
		guardarNumeroArreglo(result, desplazo, resultado);
		sb = new StringBuilder();
		sb2 = new StringBuilder();
		
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
			    // Opcionalmente, puedes agregar un mensaje más descriptivo:
			    // System.out.println("Error: formato de número inválido. Cadena: " + numeroConcatenadoStr);
			    // System.out.println("Error: formato de número inválido. Cadena: " + numeroConcatenadoStr2);
			    // O bien, simplemente puedes no imprimir ningún mensaje adicional.
			}
		}
		desplazo = aux1.length / 2;
		multiplicadoA = guardarNumeroEnArreglo(multiplicado);
		multiplicadorA = guardarNumeroEnArreglo(multiplicador);
		result = americano(multiplicadoA, multiplicadorA);
		guardarNumeroArreglo(result, desplazo, resultado);
		sb = new StringBuilder();
		sb2 = new StringBuilder();
		
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
			    // Opcionalmente, puedes agregar un mensaje más descriptivo:
			    // System.out.println("Error: formato de número inválido. Cadena: " + numeroConcatenadoStr);
			    // System.out.println("Error: formato de número inválido. Cadena: " + numeroConcatenadoStr2);
			    // O bien, simplemente puedes no imprimir ningún mensaje adicional.
			}
		}
		multiplicadoA = guardarNumeroEnArreglo(multiplicado);
		multiplicadorA = guardarNumeroEnArreglo(multiplicador);
		result = americano(multiplicadoA, multiplicadorA);
		guardarNumeroArreglo(result, desplazo, resultado);
		sb = new StringBuilder();
		sb2 = new StringBuilder();
		
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
			    // Opcionalmente, puedes agregar un mensaje más descriptivo:
			    // System.out.println("Error: formato de número inválido. Cadena: " + numeroConcatenadoStr);
			    // System.out.println("Error: formato de número inválido. Cadena: " + numeroConcatenadoStr2);
			    // O bien, simplemente puedes no imprimir ningún mensaje adicional.
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
		// Convierte el n�mero en una cadena
		String numeroStr = String.valueOf(numero);
		// Obtiene la longitud de la cadena
		int longitud = numeroStr.length();
		// Crea un arreglo con la longitud de la cadena
		int[] arreglo = new int[longitud];
		// Recorre cada d�gito de la cadena y los guarda en el arreglo
		for (int i = 0; i < longitud; i++) {
			char digitoChar = numeroStr.charAt(i);
			int digito = Character.getNumericValue(digitoChar);
			arreglo[i] = digito;
		}
		return arreglo;
	}

	/**
	 * Guarda los d�gitos de un n�mero representado como arreglo en otro arreglo de
	 * resultado, comenzando en la posici�n de desplazo especificada.
	 *
	 * @param numero    Arreglo que representa el n�mero del cual se obtendr�n los
	 *                  d�gitos.
	 * @param desplazo  Posici�n de inicio en el arreglo de resultado para almacenar
	 *                  los d�gitos.
	 * @param resultado Arreglo de resultado donde se guardar�n los d�gitos del
	 *                  n�mero.
	 * @return El arreglo de resultado actualizado con los d�gitos del n�mero.
	 */
	public static int[] guardarNumeroArreglo(int[] numero, int desplazo, int[] resultado) {
		int longitud = numero.length;
		// Recorre el arreglo 'numero' en orden inverso y guarda los d�gitos en el
		// arreglo 'resultado'
		// a partir de la posici�n 'desplazo'
		for (int i = longitud - 1, j = resultado.length - desplazo - 1; i >= 0; i--, j--) {
			resultado[j] += numero[i];
		}
		return resultado;
	}

	/**
	 * Realiza la multiplicaci�n de dos arreglos utilizando el algoritmo de la
	 * multiplicaci�n americana.
	 *
	 * @param arreglo1 Primer arreglo de d�gitos a multiplicar.
	 * @param arreglo2 Segundo arreglo de d�gitos a multiplicar.
	 * @return Arreglo resultante de la multiplicaci�n de los dos arreglos.
	 */
	public static int[] americano(int arreglo1[], int arreglo2[]) {
		int k = arreglo1.length + arreglo2.length - 1;
		int pos = arreglo1.length + arreglo2.length - 1;
		int resultado[] = new int[arreglo1.length + arreglo2.length];
		// Realiza la multiplicaci�n de los arreglos utilizando el algoritmo de la
		// multiplicaci�n americana
		for (int i = arreglo1.length - 1; i >= 0; i--) {
			for (int j = arreglo2.length - 1; j >= 0; j--) {
				resultado[k] = resultado[k] + arreglo1[i] * arreglo2[j];
				// Realiza el acarreo si el resultado es mayor a 9
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
	 * Realiza el ajuste del acarreo en caso de que haya d�gitos mayores a 9 en el
	 * arreglo.
	 *
	 * @param resultado Arreglo de d�gitos a ordenar.
	 */
	public static void ordernarArreglo(int[] resultado) {
		// Realiza el ajuste del acarreo en caso de que haya d�gitos mayores a 9
		for (int i = resultado.length - 1; i >= 0; i--) {
			// Verifica si el d�gito actual es mayor a 9
			if (resultado[i] > 9) {
				// Realiza el acarreo dividiendo el d�gito por 10 y sumando el cociente al
				// d�gito anterior
				resultado[i - 1] += resultado[i] / 10;
				// Almacena el residuo de la divisi�n en el d�gito actual
				resultado[i] = resultado[i] % 10;
			} else {
				// Si el d�gito no es mayor a 9, no es necesario realizar el acarreo
			}
		}
	}

}
