package co.edu.analisis.model.methods;

public class NaivLoopUnrollingFour {

    public double[][] naivLoopUnrollingFour(double[][] a, double[][] b, double[][] c, int n, int p, int m) {
        int i, j, k;
        double aux;

        if (p % 4 == 0) {
            for (i = 0; i < n; i++) {
                for (j = 0; j < m; j++) {
                    aux = 0.0;
                    for (k = 0; k < p; k += 4) {
                        aux += a[i][k]*b[k][j] + a[i][k+1]*b[k+1][j] + a[i][k+2]*b[k+2][j]
                                + a[i][k+3]*b[k+3][j];
                    }
                    c[i][j] = aux;
                }
            }
        } else if (p % 4 == 1) {
            int PP = p - 1;
            for (i = 0; i < n; i++) {
                for (j = 0; j < m; j++) {
                    aux = 0.0;
                    for (k = 0; k < PP; k += 4) {
                        aux += a[i][k]*b[k][j] + a[i][k+1]*b[k+1][j] + a[i][k+2]*b[k+2][j]
                                + a[i][k+3]*b[k+3][j];
                    }
                    c[i][j] = aux + a[i][PP]*b[PP][j];
                }
            }
        } else if (p % 4 == 2) {

            int PP = p - 2;
            int PPP = p - 1;
            for (i = 0; i < n; i++) {
                for (j = 0; j < m; j++) {
                    aux = 0.0;
                    for (k = 0; k < PP; k += 4) {
                        aux += a[i][k]*b[k][j] + a[i][k+1]*b[k+1][j] + a[i][k+2]*b[k+2][j]
                                + a[i][k+3]*b[k+3][j];
                    }
                    c[i][j] = aux + a[i][PP]*b[PP][j] + a[i][PPP]*b[PPP][j];
                }
            }
        } else {
            int PP = p - 3;
            int PPP = p - 2;
            int PPPP = p - 1;
            for (i = 0; i < n; i++) {
                for (j = 0; j < m; j++) {
                    aux = 0.0;
                    for (k = 0; k < PP; k += 4) {
                        aux += a[i][k]*b[k][j] + a[i][k+1]*b[k+1][j] + a[i][k+2]*b[k+2][j]
                                + a[i][k+3]*b[k+3][j];
                    }
                    c[i][j] = aux + a[i][PP]*b[PP][j] + a[i][PPP]*b[PPP][j]
                            + a[i][PPPP]*b[PPPP][j];
                }
            }
        }
        return c;
    }
}
