package co.edu.uniquindio.analisis.proyectosegundo.metodos;

public class AmericanaEstaticaRecursiva {

	public int[] multiplicacionAmericana(int[] arreglo1, int[] arreglo2) {
		int[] resultado = new int[arreglo1.length + arreglo2.length];
		multiplicacionAmericanaRecursiva(arreglo1, arreglo2, resultado, arreglo1.length - 1, arreglo2.length - 1);
		return resultado;
	}

	public static void multiplicacionAmericanaRecursiva(int[] arreglo1, int[] arreglo2, int[] resultado, int i, int j) {
		if (i < 0 || j < 0) {
			return;
		}

		resultado[i + j + 1] += arreglo1[i] * arreglo2[j];
		resultado[i + j] += resultado[i + j + 1] / 10;
		resultado[i + j + 1] %= 10;

		if (j == 0) {
			multiplicacionAmericanaRecursiva(arreglo1, arreglo2, resultado, i - 1, arreglo2.length - 1);
		} else {
			multiplicacionAmericanaRecursiva(arreglo1, arreglo2, resultado, i, j - 1);
		}
	}
}