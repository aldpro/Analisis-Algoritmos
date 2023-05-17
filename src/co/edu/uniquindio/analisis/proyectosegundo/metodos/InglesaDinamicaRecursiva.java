package co.edu.uniquindio.analisis.proyectosegundo.metodos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InglesaDinamicaRecursiva {

	public int[] multiplicaInglesaRecursiva(int[] arreglo1, int[] arreglo2) {
		if (arreglo1.length < arreglo2.length) {
			return multiplicaInglesaRecursiva(arreglo2, arreglo1);
		}

		if (arreglo2.length == 0) {
			return new int[] {};
		}

		if (arreglo2.length == 1) {
			return multiplicacionPorDigito(arreglo1, arreglo2[0]);
		}

		int m = arreglo1.length / 2;
		int n = arreglo2.length / 2;

		int[] a = Arrays.copyOfRange(arreglo1, 0, m);
		int[] b = Arrays.copyOfRange(arreglo1, m, arreglo1.length);
		int[] c = Arrays.copyOfRange(arreglo2, 0, n);
		int[] d = Arrays.copyOfRange(arreglo2, n, arreglo2.length);

		int[] ac = multiplicaInglesaRecursiva(a, c);
		int[] bd = multiplicaInglesaRecursiva(b, d);
		int[] ad = multiplicaInglesaRecursiva(a, d);
		int[] bc = multiplicaInglesaRecursiva(b, c);

		int[] temp = suma(ac, bd);
		int[] resultado = suma(ad, bc);
		resultado = suma(resultado, temp);

		if (resultado.length > 1 && resultado[0] == 0) {
			resultado = Arrays.copyOfRange(resultado, 1, resultado.length);
		}

		return resultado;
	}

	public int[] multiplicacionPorDigito(int[] arreglo, int digito) {
		if (digito == 0) {
			return new int[] { 0 };
		}

		int acarreo = 0;
		List<Integer> temp = new ArrayList<>();

		for (int i = arreglo.length - 1; i >= 0; i--) {
			int val = arreglo[i] * digito + acarreo;
			temp.add(0, val % 10);
			acarreo = val / 10;
		}

		if (acarreo > 0) {
			temp.add(0, acarreo);
		}

		int[] resultado = new int[temp.size()];
		for (int i = 0; i < temp.size(); i++) {
			resultado[i] = temp.get(i);
		}

		return resultado;
	}

	public int[] suma(int[] arreglo1, int[] arreglo2) {
		int m = arreglo1.length;
		int n = arreglo2.length;

		int[] resultado = new int[Math.max(m, n) + 1];
		int acarreo = 0;

		for (int i = 0; i < resultado.length; i++) {
			int val1 = (i < m) ? arreglo1[m - 1 - i] : 0;
			int val2 = (i < n) ? arreglo2[n - 1 - i] : 0;
			int val = val1 + val2 + acarreo;
			resultado[resultado.length - 1 - i] = val % 10;
			acarreo = val / 10;
		}

		if (acarreo > 0) {
			resultado[0] = acarreo;
		} else {
			resultado = Arrays.copyOfRange(resultado, 1, resultado.length);
		}

		return resultado;
	}

}
