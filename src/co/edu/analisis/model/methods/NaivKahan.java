package co.edu.analisis.model.methods;

public class NaivKahan {

    public double[][] naivKahan(double[][] a, double[][] b, double[][] c, int n, int p, int m) {
        double t, sum, err;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sum = 0.0;
                err = 0.0;
                for (int k = 0; k < p; k++) {
                    err = err + a[i][k] * b[k][j];
                    t = sum + err;
                    err = (sum - t) + err;
                    sum = t;
                }
                c[i][j] = sum;
            }
        }
        return c;
    }
}
