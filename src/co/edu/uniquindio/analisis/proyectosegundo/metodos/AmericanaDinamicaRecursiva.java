package co.edu.uniquindio.analisis.proyectosegundo.metodos;

import java.util.Arrays;

public class AmericanaDinamicaRecursiva {
	
	public int[] multiplicacionAmericana(int[] arreglo1, int[] arreglo2) {
		int n = arreglo1.length;
		int m = arreglo2.length;

		if (n == 0 || m == 0) {
			return new int[] { 0 };
		}

		if (n == 1 && m == 1) {
			int prod = arreglo1[0] * arreglo2[0];
			return new int[] { prod % 10, prod / 10 };
		}

		int mid1 = n / 2;
		int mid2 = m / 2;

		int[] a = Arrays.copyOfRange(arreglo1, 0, mid1);
		int[] b = Arrays.copyOfRange(arreglo1, mid1, n);
		int[] c = Arrays.copyOfRange(arreglo2, 0, mid2);
		int[] d = Arrays.copyOfRange(arreglo2, mid2, m);

		int[] ac = multiplicacionAmericana(a, c);
		int[] bd = multiplicacionAmericana(b, d);
		int[] abcd = multiplicacionAmericana(sumar(a, b), sumar(c, d));

		int[] resultado = new int[n + m];

		for (int i = 0; i < ac.length; i++) {
			resultado[i] += ac[i];
		}

		for (int i = 0; i < bd.length; i++) {
			resultado[i + n + m - bd.length] += bd[i];
		}

		for (int i = 0; i < abcd.length; i++) {
			resultado[i + mid1 + mid2] += abcd[i];
		}

		for (int i = 0; i < resultado.length - 1; i++) {
			resultado[i + 1] += resultado[i] / 10;
			resultado[i] %= 10;
		}

		int i = resultado.length - 1;
		while (i > 0 && resultado[i] == 0) {
			i--;
		}

		return Arrays.copyOfRange(resultado, 0, i + 1);
	}

	private static int[] sumar(int[] a, int[] b) {
		int[] resultado = new int[Math.max(a.length, b.length) + 1];
		int carry = 0;

		for (int i = 0; i < resultado.length; i++) {
			int sum = carry;

			if (i < a.length) {
				sum += a[a.length - i - 1];
			}

			if (i < b.length) {
				sum += b[b.length - i - 1];
			}

			resultado[resultado.length - i - 1] = sum % 10;
			carry = sum / 10;
		}

		if (resultado[0] == 0) {
			return Arrays.copyOfRange(resultado, 1, resultado.length);
		}

		return resultado;
	}

}
