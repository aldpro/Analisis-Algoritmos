package co.edu.analisis.model.methods;

public class NaivLoopUnrollingTwo {

	public int[][] naivLoopUnrollingTwo(int[][] a, int[][] b) {
		int m = a.length; // Filas matriz a[]
		int n = a[0].length; // Columnas matriz a[]
		int p = b[0].length; // Columnas matriz b[]

		int[][] c = new int[m][p];

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < p; j++) {
				int s = 0; // Acumula la suma de los productos
				
				for (int k = 0; k < n; k += 2) {
					
					s += a[i][k] * b[k][j] + a[i][k + 1] * b[k + 1][j]; // Calcula la suma de los productos de los pares de elementos
				}
				c[i][j] = s;
			}
		}
		return c;
	}
}
