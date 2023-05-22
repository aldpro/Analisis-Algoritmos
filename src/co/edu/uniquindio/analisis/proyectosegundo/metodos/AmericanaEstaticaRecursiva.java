package co.edu.uniquindio.analisis.proyectosegundo.metodos;

public class AmericanaEstaticaRecursiva {

	public int[] multiplicacionAmericana(int[] arreglo1, int[] arreglo2) {
		// Crea un arreglo resultado con una longitud igual a la suma de las longitudes de los dos arreglos de entrada
		int[] resultado = new int[arreglo1.length + arreglo2.length];
		// Llama a la funci?n recursiva para realizar la multiplicaci?n americana
		multiplicacionAmericanaRecursiva(arreglo1, arreglo2, resultado, arreglo1.length - 1, arreglo2.length - 1);

		// Devuelve el arreglo resultado
		return resultado;
	}

	public static void multiplicacionAmericanaRecursiva(int[] arreglo1, int[] arreglo2, int[] resultado, int i, int j) {
		// Caso base: si alguno de los ?ndices es menor que 0, termina la recursi?n
		if (i < 0 || j < 0) {
			return;
		}

		// Realiza la multiplicaci?n de los elementos correspondientes y suma al elemento correspondiente en el arreglo resultado
		resultado[i + j + 1] += arreglo1[i] * arreglo2[j];
		// Si el resultado de la multiplicaci?n es mayor o igual a 10, lleva el excedente al elemento anterior del arreglo resultado
		resultado[i + j] += resultado[i + j + 1] / 10;
		// Guarda el resultado de la multiplicaci?n en el elemento correspondiente del arreglo resultado
		resultado[i + j + 1] %= 10;

		// Llama a la funci?n recursiva para el siguiente elemento
		if (j == 0) {
			multiplicacionAmericanaRecursiva(arreglo1, arreglo2, resultado, i - 1, arreglo2.length - 1);
		} else {
			multiplicacionAmericanaRecursiva(arreglo1, arreglo2, resultado, i, j - 1);
		}
	}

}