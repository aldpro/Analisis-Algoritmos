package co.edu.analisis.model.methods;

public class WinogradOriginal {

	public double[][] winogradOriginal(double[][] a, double[][] b) {
		int m = a.length; // Filas matriz a[]
		int n = a[0].length; // Columnas matriz a[]
		int p = b[0].length; // Columnas matriz b[]

		if (n != b.length) {
			throw new IllegalArgumentException("Dimensiones no compatibles");
		}

		// Calcular las constantes de Winograd
		int r = 2;
		int rr = r * r;
		double[] rowFactor = new double[m];
		double[] colFactor = new double[p];
		for (int i = 0; i < m; i++) {
			rowFactor[i] = 0;
			for (int j = 0; j < n; j += 2) {
				rowFactor[i] += a[i][j] * a[i][j + 1];
			}
		}
		for (int i = 0; i < p; i++) {
			colFactor[i] = 0;
			for (int j = 0; j < n; j += 2) {
				colFactor[i] += b[j][i] * b[j + 1][i];
			}
		}

		double[][] c = new double[m][p];

		// Calcular el producto de las matrices utilizando el algoritmo de winograd
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < p; j++) {
				double dotProduct = 0;
				for (int k = 0; k < n; k += 2) {
					dotProduct += (a[i][k] + b[k + 1][j]) * (a[i][k + 1] + b[k][j]);
				}
				c[i][j] = -rowFactor[i] - colFactor[j] + dotProduct;
			}
		}

		// Si las dimensiones de las matrices son impares, se procesa el sobrante [inaplicable]
		if (n % 2 == 1) {
			throw new IllegalArgumentException("El tamaño de la matriz es impar, el método no es aplicable.");
		}
		return c;
	}

}
