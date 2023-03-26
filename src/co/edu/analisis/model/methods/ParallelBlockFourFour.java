package co.edu.analisis.model.methods;

import java.util.Arrays;
import java.util.stream.IntStream;

public class ParallelBlockFourFour {

	public double[][] multiply(double[][] a, double[][] b, int blockSize) {
		int size = a.length;
		double[][] c = new double[size][size];

        IntStream.range(0, size / blockSize).parallel().forEach(ib -> {
            for (int jb = 0; jb < size; jb += blockSize) {
                for (int kb = 0; kb < size; kb += blockSize) {
                    for (int i = ib * blockSize; i < (ib + 1) * blockSize && i < size; i++) {
                        for (int j = jb; j < jb + blockSize && j < size; j++) {
                            for (int k = kb; k < kb + blockSize && k < size; k++) {
                                c[i][k] += a[i][j] * b[j][k];
                            }
                        }
                    }
                }
            }
        });
		return c;
	}
}
