package co.edu.analisis.model.methods;

public class WinogradScaled {

	public int[][] winogradScale(int[][] a, int[][] b) {
	    int m = a.length;
	    int n = b.length;
	    int q = b[0].length;

	    int[][] c = new int[m][q];

	    int[] rowFactor = new int[m];
	    int[] colFactor = new int[q];

	    for (int i = 0; i < m; i++) {
	        rowFactor[i] = a[i][0] * a[i][1];
	        for (int j = 1; j < n / 2; j++) {
	            int index = 2 * j;
	            rowFactor[i] += a[i][index] * a[i][index + 1];
	        }
	    }

	    for (int i = 0; i < q; i++) {
	        colFactor[i] = b[0][i] * b[1][i];
	        for (int j = 1; j < n / 2; j++) {
	            int index = 2 * j;
	            colFactor[i] += b[index][i] * b[index + 1][i];
	        }
	    }

	    for (int i = 0; i < m; i++) {
	        for (int j = 0; j < q; j++) {
	            int sum = -rowFactor[i] - colFactor[j];
	            for (int k = 0; k < n / 2; k++) {
	                int indexu = 2 * k;
	                int indexo = indexu + 1;
	                sum += (a[i][indexu] + b[indexo][j]) * (a[i][indexo] + b[indexu][j]);
	            }
	            c[i][j] = sum;
	        }
	    }

	    if (n % 2 != 0) {
	        for (int i = 0; i < m; i++) {
	            for (int j = 0; j < q; j++) {
	                c[i][j] += a[i][n - 1] * b[n - 1][j];
	            }
	        }
	    }

	    return c;
	}
}
