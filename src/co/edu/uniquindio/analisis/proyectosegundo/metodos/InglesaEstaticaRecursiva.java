package co.edu.uniquindio.analisis.proyectosegundo.metodos;

import java.util.Arrays;

public class InglesaEstaticaRecursiva {

	public int[] multiplicaInglesaRecursiva(int[] arreglo1, int[] arreglo2, int pos, int[] resultado) {
		if (pos == arreglo2.length) {
			return resultado;
		}
		for (int i = 0; i < arreglo1.length; i++) {
			resultado[i + pos + 1] += arreglo1[i] * arreglo2[pos];
		}
		for (int k = resultado.length - 1; k > 0; k--) {
			resultado[k - 1] += resultado[k] / 10;
			resultado[k] %= 10;
		}
		return multiplicaInglesaRecursiva(arreglo1, arreglo2, pos + 1, resultado);
	}

	public int[] multiplicaInglesa(int[] arreglo1, int[] arreglo2) {

		int tam = arreglo1.length + arreglo2.length;
		int[] resultado = new int[tam];

		return multiplicaInglesaRecursiva(arreglo1, arreglo2, 0, resultado);
	}

}
