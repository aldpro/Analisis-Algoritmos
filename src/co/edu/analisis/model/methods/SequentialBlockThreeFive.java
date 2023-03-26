package co.edu.analisis.model.methods;

public class SequentialBlockThreeFive {

	public double[][] multiply(double[][] a, double[][] b, int blockSize) {
		int size = a.length;
		double[][] c = new double[size][size];

        for (int ib = 0; ib < size; ib += blockSize) {
            for (int jb = 0; jb < size; jb += blockSize) {
                for (int kb = 0; kb < size; kb += blockSize) {
                    for (int i = ib; i < ib + blockSize && i < size; i++) {
                        for (int j = jb; j < jb + blockSize && j < size; j++) {
                            for (int k = kb; k < kb + blockSize && k < size; k++) {
                                c[k][i] += a[k][j] * b[j][i];
                            }
                        }
                    }
                }
            }
        }
		return c;
	}
}
