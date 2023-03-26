package co.edu.analisis.model.methods;

public class StrassenNaiv {

	/**
	 * Principal metodo para strassen naiv
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public double[][] multiply(double[][] a, double[][] b) {
		int n = a.length;
		double[][] c = new double[n][n];

		if (n == 1) {
			c[0][0] = a[0][0] * b[0][0];
		} else {
			double[][] A11 = new double[n / 2][n / 2];
			double[][] A12 = new double[n / 2][n / 2];
			double[][] A21 = new double[n / 2][n / 2];
			double[][] A22 = new double[n / 2][n / 2];
			double[][] B11 = new double[n / 2][n / 2];
			double[][] B12 = new double[n / 2][n / 2];
			double[][] B21 = new double[n / 2][n / 2];
			double[][] B22 = new double[n / 2][n / 2];

			// Dividir las matrices en cuatro submatrices
			divide(a, A11, 0, 0);
			divide(a, A12, 0, n / 2);
			divide(a, A21, n / 2, 0);
			divide(a, A22, n / 2, n / 2);
			divide(b, B11, 0, 0);
			divide(b, B12, 0, n / 2);
			divide(b, B21, n / 2, 0);
			divide(b, B22, n / 2, n / 2);

			// Calcular los productos necesarios
			double[][] P1 = multiply(add(A11, A22), add(B11, B22));
			double[][] P2 = multiply(add(A21, A22), B11);
			double[][] P3 = multiply(A11, subtract(B12, B22));
			double[][] P4 = multiply(A22, subtract(B21, B11));
			double[][] P5 = multiply(add(A11, A12), B22);
			double[][] P6 = multiply(subtract(A21, A11), add(B11, B12));
			double[][] P7 = multiply(subtract(A12, A22), add(B21, B22));

			// Calcular los resultados
			double[][] C11 = add(subtract(add(P1, P4), P5), P7);
			double[][] C12 = add(P3, P5);
			double[][] C21 = add(P2, P4);
			double[][] C22 = add(subtract(add(P1, P3), P2), P6);

			// Combinar los resultados en una sola matriz
			combine(C11, c, 0, 0);
			combine(C12, c, 0, n / 2);
			combine(C21, c, n / 2, 0);
			combine(C22, c, n / 2, n / 2);
		}

		return c;
	}

	/**
	 * Función para dividir la matriz en cuatro submatrices
	 * 
	 * @param P
	 * @param C
	 * @param rowb
	 * @param colb
	 */
	public void divide(double[][] P, double[][] C, int rowb, int colb) {
		for (int i1 = 0, i2 = rowb; i1 < C.length; i1++, i2++) {
			for (int j1 = 0, j2 = colb; j1 < C.length; j1++, j2++) {
				C[i1][j1] = P[i2][j2];
			}
		}
	}

	/**
	 * Función para combinar cuatro submatrices en una sola matriz
	 * 
	 * @param C
	 * @param P
	 * @param rowb
	 * @param colb
	 */
	public void combine(double[][] C, double[][] P, int rowb, int colb) {
		for (int i1 = 0, i2 = rowb; i1 < C.length; i1++, i2++) {
			for (int j1 = 0, j2 = colb; j1 < C.length; j1++, j2++) {
				P[i2][j2] = C[i1][j1];
			}
		}
	}

	/**
	 * Función para sumar dos matrices
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public double[][] add(double[][] a, double[][] b) {
		int n = a.length;
		double[][] c = new double[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				c[i][j] = a[i][j] + b[i][j];
			}
		}
		return c;
	}

	/**
	 * Función para restar dos matrices
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public double[][] subtract(double[][] a, double[][] b) {
		int n = a.length;
		double[][] c = new double[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				c[i][j] = a[i][j] - b[i][j];
			}
		}
		return c;
	}
}
