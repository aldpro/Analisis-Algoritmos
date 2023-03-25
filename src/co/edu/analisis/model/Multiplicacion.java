package co.edu.analisis.model;

public class Multiplicacion {

	/**/
	public int[][] naivStandard(int[][] a, int[][] b) {
		int[][] c = new int[a.length][b[0].length];

		if (a[0].length == b.length) { // Comprueba si las matrices se pueden multiplicar
			for (int i = 0; i < a.length; i++) {
				for (int j = 0; j < b[0].length; j++) {
					for (int k = 0; k < a[0].length; k++) {

						c[i][j] += a[i][k] * b[k][j]; // Multiplica la matriz
					}
				}
			}
		}
		
		return c;
	}
}
