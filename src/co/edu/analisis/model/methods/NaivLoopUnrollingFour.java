package co.edu.analisis.model.methods;

public class NaivLoopUnrollingFour {

	public int[][] naiveLoopUnrollingFour(int[][] a, int[][] b) {
	    int m = a.length; //Filas matriz a[]
	    int n = a[0].length; // Columnas matriz a[]
	    int p = b[0].length; // Columnas matriz b[]

	    int[][] c = new int[m][p];

	    for (int i = 0; i < m; i++) {
	        for (int j = 0; j < p; j++) {
	            int s = 0; // Inicializar la variable de acumulación
	            
	            for (int k = 0; k < n; k += 4) {  // Recorrer las columnas de a en grupos de cuatro
	               
	                s += a[i][k] * b[k][j] + a[i][k + 1] * b[k + 1][j] + a[i][k + 2] * b[k + 2][j] + a[i][k + 3] * b[k + 3][j];   // Multiplicar y acumular los cuartetos de elementos
	            }
	            c[i][j] = s;
	        }
	    }
	    return c;
	}
}
