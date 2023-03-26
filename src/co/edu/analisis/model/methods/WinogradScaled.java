package co.edu.analisis.model.methods;

public class WinogradScaled {

    public double[][] winogradScaled(double[][] a, double[][] b, double[][] c, int n, int p, int m) {
    	WinogradOriginal metodo = new WinogradOriginal();
    	
    	int i, j;
        
        double[][] copya = new double[n][p];
        double[][] copyb = new double[p][m];

        double aa = normInf(a, n, p);
        double bb = normInf(b, p, m);
        double lambda = Math.floor(0.5 + Math.log(bb/aa)/Math.log(4));

        multiplyWithScalar(a, copya, n, p, Math.pow(2, lambda));
        multiplyWithScalar(b, copyb, p, m, Math.pow(2, -lambda));

        c = metodo.winogradOriginal(copya, copyb, c, n, p, m);
        return c;
    }

    public void multiplyWithScalar(double[][] a, double[][] b, int n, int m, double scalar) {
        int i, j;
        for (i = 0; i < n; i++) {
            for (j = 0; j < m; j++) {
                b[i][j] = a[i][j] * scalar;
            }
        }
    }

    public double normInf(double[][] a, int n, int m) {
        int i, j;
        double max = Double.NEGATIVE_INFINITY;
        for (i = 0; i < n; i++) {
            double sum = 0.0;
            for (j = 0; j < m; j++) {
                sum += Math.abs(a[i][j]);
            }
            if (sum > max) {
                max = sum;
            }
        }
        return max;
    }

}
