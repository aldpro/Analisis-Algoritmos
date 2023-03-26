package co.edu.analisis.model.methods;

public class NaivOnArray {

	public double[][] naivOnArray(double[][] a, double[][] b, double[][] c, int n, int p , int m){
	    for (int i = 0; i < n; i++) {
	        for (int j = 0; j < m; j++) {
	            c[i][j] = 0.0;
	            for (int k = 0; k < p; k++) {
	                c[i][j] += a[i][k] * b[k][j];
	            }
	        }
	    }
	    return c;
	}
}
