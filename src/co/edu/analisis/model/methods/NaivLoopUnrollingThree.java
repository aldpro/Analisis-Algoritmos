package co.edu.analisis.model.methods;

public class NaivLoopUnrollingThree {
	
    public double[][] naiveLoopUnrollingThree(double[][] a, double[][] b, double[][] c, int n, int p, int m) {
        int i, j, k;
        double aux;
        if (p % 3 == 0) {
            for (i = 0; i < n; i++) {
                for (j = 0; j < m; j++) {
                    aux = 0.0;
                    for (k = 0; k < p; k += 3) {
                        aux += a[i][k]*b[k][j] + a[i][k+1]*b[k+1][j] + a[i][k+2]*b[k+2][j];
                    }
                    c[i][j] = aux;
                }
            }
        } else if (p % 3 == 1) {
            int PP = p - 1;
            for (i = 0; i < n; i++) {
                for (j = 0; j < m; j++) {
                    aux = 0.0;
                    for (k = 0; k < PP; k += 3) {
                        aux += a[i][k]*b[k][j] + a[i][k+1]*b[k+1][j] + a[i][k+2]*b[k+2][j];
                    }
                    c[i][j] = aux + a[i][PP]*b[PP][j];
                }
            }
        } else {
            int PP = p - 2;
            int PPP = p - 1;
            for (i = 0; i < n; i++) {
                for (j = 0; j < m; j++) {
                    aux = 0.0;
                    for (k = 0; k < PP; k += 3) {
                        aux += a[i][k]*b[k][j] + a[i][k+1]*b[k+1][j] + a[i][k+2]*b[k+2][j];
                    }
                    c[i][j] = aux + a[i][PP]*b[PP][j] + a[i][PPP]*b[PPP][j];
                }
            }
        }
        return c;
    }
}
