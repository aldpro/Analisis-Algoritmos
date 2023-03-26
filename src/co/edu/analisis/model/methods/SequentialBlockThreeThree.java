package co.edu.analisis.model.methods;

public class SequentialBlockThreeThree {
	
    /**
     * Función para multiplicar dos matrices utilizando el método sequential block
     * 
     * @param a
     * @param b
     * @param blockSize
     * @return
     */
    public double[][] multiply(double[][] a, double[][] b, int blockSize) {
        int n = a.length;
        double[][] c = new double[n][n];
        int i, j, k, ib, jb, kb;
        double sum;
        
        // Dividir las matrices en bloques
        for (ib = 0; ib < n; ib += blockSize) {
            for (jb = 0; jb < n; jb += blockSize) {
                for (kb = 0; kb < n; kb += blockSize) {
                    // Multiplicar los bloques de matrices
                    for (i = ib; i < ib + blockSize && i < n; i++) {
                        for (j = jb; j < jb + blockSize && j < n; j++) {
                            sum = 0;
                            for (k = kb; k < kb + blockSize && k < n; k++) {
                                sum += a[i][k] * b[k][j];
                            }
                            c[i][j] += sum;
                        }
                    }
                }
            }
        }
        return c;
    }
}
