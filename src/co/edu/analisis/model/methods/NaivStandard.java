package co.edu.analisis.model.methods;

public class NaivStandard {

	public double[][] naivStandard(double[][] a, double[][] b, double[][] c, int n, int p, int m) {
	    double aux; // variable auxiliar para almacenar el valor temporal del producto de las matrices
	    for (int i = 0; i < n; i++) { // iteración sobre las filas de la matriz [A]
	        for (int j = 0; j < m; j++) { // iteración sobre las columnas de la matriz [B]
	            aux = 0.0; // inicialización de la variable auxiliar en cero
	            for (int k = 0; k < p; k++) { // iteración sobre los elementos de la matriz [A] y [B] a multiplicar
	                aux += a[i][k] * b[k][j]; // se multiplica y se suma el resultado a la variable auxiliar
	            }
	            c[i][j] = aux; // se almacena el resultado final en la matriz C
	        }
	    }
	    return c; // se devuelve la matriz C resultante
	}

}
