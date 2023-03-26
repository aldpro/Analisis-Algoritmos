package co.edu.analisis.model.methods;

public class NaivLoopUnrollingThree {
	
	public int[][] naiveLoopUnrollingThree(int[][] a, int[][] b) {
	    int m = a.length; // Filas matriz a[]
	    int n = a[0].length; // Columnas matriz a[]
	    int p = b[0].length; // Columnas matriz b[]

	    if (n != b.length) {
	        throw new IllegalArgumentException("Dimensiones no compatibles");
	    }

	    int[][] c = new int[m][p];

	    for (int i = 0; i < m; i++) {
	        for (int j = 0; j < p; j++) {
	            int s = 0; // Inicializar la variable de acumulación
	            
	            for (int k = 0; k < n; k += 3) { // Recorrer las columnas de a en grupos de tres
	                
	                if (k + 2 < n) {  // Multiplicar y acumular los tríos de elementos
	                	
	                    s += a[i][k] * b[k][j] + a[i][k + 1] * b[k + 1][j] + a[i][k + 2] * b[k + 2][j];
	                } else if (k + 1 < n) {
	                    
	                    s += a[i][k] * b[k][j] + a[i][k + 1] * b[k + 1][j]; // Si la columna no se puede agrupar en tríos, usar el bucle simple
	                } else {
	                	
	                    s += a[i][k] * b[k][j];
	                }
	            }
	            c[i][j] = s;
	        }
	    }
	    return c;
	}
}
