package co.edu.uniquindio.analisis.proyectosegundo.metodos;

public class AmericanaEstaticaIterativa {

	/**
	 * Metodo de multiplicacion americana
	 * 
	 * @param arreglo1
	 * @param arreglo2
	 * @return resultado
	 */
	public int[] multiplicacionAmericana(int[] arreglo1, int[] arreglo2) {
		// Se crea un arreglo resultado con una longitud igual a la suma de las longitudes de los dos arreglos de entrada
		int[] resultado = new int[arreglo1.length + arreglo2.length];

		// Se recorre el primer arreglo en orden inverso
		for (int i = arreglo1.length - 1; i >= 0; i--) {
			// Se recorre el segundo arreglo en orden inverso
			for (int j = arreglo2.length - 1; j >= 0; j--) {
				// Se realiza la multiplicación de los elementos correspondientes y se suma al elemento correspondiente en el arreglo resultado
				resultado[i + j + 1] += arreglo1[i] * arreglo2[j];
				// Si el resultado de la multiplicación es mayor o igual a 10, se lleva el excedente al elemento anterior del arreglo resultado
				resultado[i + j] += resultado[i + j + 1] / 10;
				// Se guarda el resultado de la multiplicación en el elemento correspondiente del arreglo resultado
				resultado[i + j + 1] %= 10;
			}
		}

		// Se devuelve el arreglo resultado
		return resultado;
	}

}
