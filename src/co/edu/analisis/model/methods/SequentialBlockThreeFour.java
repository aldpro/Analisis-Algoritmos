package co.edu.analisis.model.methods;

public class SequentialBlockThreeFour {

    public double[][] multiply(double[][] matrixA, double[][] matrixB, int blockSize) {
        int n = matrixA.length;
        int p = matrixB[0].length;
        int m = matrixB.length;

        double[][] result = new double[n][p];

        // Dividir matrices en bloques
        for (int i = 0; i < n; i += blockSize) {
            for (int j = 0; j < p; j += blockSize) {
                for (int k = 0; k < m; k += blockSize) {
                    // Multiplicar bloques
                    for (int ii = i; ii < Math.min(i + blockSize, n); ii++) {
                        for (int jj = j; jj < Math.min(j + blockSize, p); jj++) {
                            for (int kk = k; kk < Math.min(k + blockSize, m); kk++) {
                                result[ii][jj] += matrixA[ii][kk] * matrixB[kk][jj];
                            }
                        }
                    }
                }
            }
        }

        return result;
    }
}
