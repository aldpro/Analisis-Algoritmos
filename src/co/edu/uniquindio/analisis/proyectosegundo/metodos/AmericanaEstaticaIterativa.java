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
		int[] resultado = new int[arreglo1.length + arreglo2.length];

		for (int i = arreglo1.length - 1; i >= 0; i--) {
			for (int j = arreglo2.length - 1; j >= 0; j--) {
				resultado[i + j + 1] += arreglo1[i] * arreglo2[j];
				resultado[i + j] += resultado[i + j + 1] / 10;
				resultado[i + j + 1] %= 10;
			}
		}

		return resultado;
	}
}
