package co.edu.analisis.model.methods;

public class NaivLoopUnrollingTwo {

	public double[][] naivLoopUnrollingTwo(double[][] a, double[][] b, double[][] c, int n, int p, int m) {
		int i, j, k;
		double aux;
		if (p % 2 == 0) {
			for (i = 0; i < n; i++) {
				for (j = 0; j < m; j++) {
					aux = 0.0;
					for (k = 0; k < p; k += 2) {
						aux += a[i][k] * b[k][j] + a[i][k + 1] * b[k + 1][j];
					}
					c[i][j] = aux;
				}
			}
		} else {
			int PP = p - 1;
			for (i = 0; i < n; i++) {
				for (j = 0; j < m; j++) {
					aux = 0.0;
					for (k = 0; k < PP; k += 2) {
						aux += a[i][k] * b[k][j] + a[i][k + 1] * b[k + 1][j];
					}
					c[i][j] = aux + a[i][PP] * b[PP][j];
				}
			}
		}
		return c;
	}
}
