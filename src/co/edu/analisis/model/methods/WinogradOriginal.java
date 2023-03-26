package co.edu.analisis.model.methods;

public class WinogradOriginal {

	public double[][] winogradOriginal(double[][] a, double[][] b, double[][] c, int n, int p, int m) {
		int i, j, k;
		double aux;
		int upsilon = p % 2;
		int gamma = p - upsilon;
		double[] y = new double[m];
		double[] z = new double[n];

		for (i = 0; i < m; i++) {
			aux = 0.0;
			for (j = 0; j < gamma; j += 2) {
				aux += a[i][j] * a[i][j + 1];
			}
			y[i] = aux;
		}

		for (i = 0; i < n; i++) {
			aux = 0.0;
			for (j = 0; j < gamma; j += 2) {
				aux += b[j][i] * b[j + 1][i];
			}
			z[i] = aux;
		}

		if (upsilon == 1) {
			int PP = p - 1;
			for (i = 0; i < m; i++) {
				for (k = 0; k < n; k++) {
					aux = 0.0;
					for (j = 0; j < gamma; j += 2) {
						aux += (a[i][j] + b[j + 1][k]) * (a[i][j + 1] + b[j][k]);
					}
					c[i][k] = aux - y[i] - z[k] + a[i][PP] * b[PP][k];
				}
			}
		} else {
			for (i = 0; i < m; i++) {
				for (k = 0; k < n; k++) {
					aux = 0.0;
					for (j = 0; j < gamma; j += 2) {
						aux += (a[i][j] + b[j + 1][k]) * (a[i][j + 1] + b[j][k]);
					}
					c[i][k] = aux - y[i] - z[k];
				}
			}
		}

		// Liberar memoria
		y = null;
		z = null;

		return c;
	}

}
