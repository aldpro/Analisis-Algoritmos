package co.edu.analisis.model.methods;

public class NaivOnArray {

	/**
	 * Funcion para multiplicar matrices por algoritmo naiv standard
	 * 
	 * @param a
	 * @param b
	 * @return matriz que contiene la multiplicacion
	 */
	public int[][] naivOnArray(int[][] a, int[][] b) {
		int n = a[0].length; // Columnas matriz []a
		int o = b[0].length; // Columnas matriz b[]
		int m = a.length; // Filas matriz []a
		int x = b.length; // Filas matriz []a

		int[][] c = new int[m][o];

		if (n == x) { // comprueba si las matrices se pueden multiplicar
			for (int i = 0; i < m; i++) {
				for (int j = 0; j < o; j++) {
					int producto = 0;
					for (int k = 0; k < n; k++) {
						producto = producto + (a[i][k] * b[k][j]); // Multiplica la matriz
					}
					c[i][j] = producto;
				}
			}
		}
		return c;
	}
}
