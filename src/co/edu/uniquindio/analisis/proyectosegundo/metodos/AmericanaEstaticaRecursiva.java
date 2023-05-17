package co.edu.uniquindio.analisis.proyectosegundo.metodos;

public class AmericanaEstaticaRecursiva {

	public int[] multiplicacionAmericanaRecursiva(int[] arreglo1, int[] arreglo2) {
		int[] resultado = new int[arreglo1.length + arreglo2.length];
		multiplicacionAmericanaRecursiva(arreglo1, arreglo2, resultado, 0, 0);
		return resultado;
	}

	private static void multiplicacionAmericanaRecursiva(int[] arreglo1, int[] arreglo2, int[] resultado, int i,
			int j) {
		if (i == arreglo1.length) {
			return;
		}
		if (j == arreglo2.length) {
			multiplicacionAmericanaRecursiva(arreglo1, arreglo2, resultado, i + 1, 0);
			return;
		}
		resultado[i + j] += arreglo1[i] * arreglo2[j];
		resultado[i + j + 1] += resultado[i + j] / 10;
		resultado[i + j] %= 10;
		multiplicacionAmericanaRecursiva(arreglo1, arreglo2, resultado, i, j + 1);
		multiplicacionAmericanaRecursiva(arreglo1, arreglo2, resultado, i + 1, j);
	}
}