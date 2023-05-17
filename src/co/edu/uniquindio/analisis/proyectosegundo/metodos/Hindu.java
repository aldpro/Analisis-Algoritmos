package co.edu.uniquindio.analisis.proyectosegundo.metodos;

public class Hindu {

	/**
	 * Método para sumar y restar digitos a los valores de 2 cifras
	 * 
	 * @param resultado
	 */
	private static void sumarRestarNumeros(int[] resultado) {
		int temporal = 0;
		for (int i = 0; i < resultado.length; i++) {
			temporal = resultado[i];
			int digitos = (int) (Math.log10(temporal) + 1);

			if (digitos == 2 && i != 0) {
				resultado[i - 1] = resultado[i - 1] + (temporal - 9);
				resultado[i] = 9;
			}
		}
	}

	public void multiplicarHindu(int[] multiplicando, int[] multiplicador, int[] resultado) {
		int temporal = 0, pivot = 0, pivot2 = 0;
		int sumador = 0, t = 0;
		int u = 0;

		for (int i = 0; i < multiplicador.length; i++) {
			sumador = 0;
			for (int j = 0; j < multiplicando.length; j++) {

				temporal = multiplicador[i] * multiplicando[j];
				pivot = temporal / 10;
				pivot2 = temporal % 10;

				if (i == 0 && j == 0 && pivot != 0) {
					resultado[i + j] = pivot;
					sumador = pivot2;

				} else {

					if (i + 1 == multiplicador.length && j + 1 == multiplicando.length) {

						resultado[i + j] = u + pivot + sumador;
						resultado[i + j + 1] = pivot2;

						u = resultado[i + j + 1];

					} else {
						if (j + 1 == multiplicando.length) {
							resultado[i + j + 1] = pivot2;

							u = resultado[i + j + 1];
						}
						t = resultado[i + j];
						resultado[i + j] = t + sumador + pivot;
						sumador = pivot2;
					}
				}
			}
		}
	}
}
