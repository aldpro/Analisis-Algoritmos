package co.edu.analisis.model.methods;

public class NaivKahan {

	public int[][] naivKahan(int[][] a, int[][] b) {
		int m = a.length; // Filas matriz a[]
		int n = a[0].length; // Columnas matriz a[]
		int p = b[0].length; // Columnas matriz b[]

		int[][] c = new int[m][p];
		int[] colum_b = new int[n]; // Arreglo temporal para almacenar columnas de b[]

		for (int k = 0; k < p; k++) {
			for (int j = 0; j < n; j++) {
				colum_b[j] = b[j][k]; // Almacena la columna j-ésima de b en el arreglo temporal
			}
			for (int i = 0; i < m; i++) {
				int s = 0;
				int e = 0; // Error de redondeo
				for (int j = 0; j < n; j++) {
					int prod = a[i][j] * colum_b[j]; // Producto de la i-ésima fila de a y la j-ésima columna de b
					int y = prod - e; // Suma del producto y el error de redondeo anterior
					int t = s + y; // Suma acumulada actual
					e = (t - s) - y; // Calcula el nuevo error de redondeo
					s = t; // Actualiza la suma acumulada
				}
				c[i][k] = s;
			}
		}

		return c; // devuelve la matriz de resultado
	}
}
