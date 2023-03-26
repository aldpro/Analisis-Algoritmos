package co.edu.analisis.model.methods;

public class NaivKahan {

	public double[][] naivKahan(double[][] a, double[][] b) {
	    int m = a.length; // Filas matriz a[]
	    int n = a[0].length; // Columnas matriz a[]
	    int p = b[0].length; // Columnas matriz b[]

	    double[][] c = new double[m][p];
	    double[] columb = new double[n]; // Arreglo temporal para almacenar columnas de b[]

	    for (int k = 0; k < p; k++) {
	        for (int j = 0; j < n; j++) {
	            columb[j] = b[j][k]; // Almacena la columna j-ésima de b en el arreglo temporal
	        }
	        for (int i = 0; i < m; i++) {
	            double s = 0;
	            double e = 0; // Error de redondeo
	            for (int j = 0; j < n; j++) {
	                double prod = a[i][j] * columb[j]; // Producto de la i-ésima fila de a y la j-ésima columna de b
	                double y = prod - e; // Suma del producto y el error de redondeo anterior
	                double t = s + y; // Suma acumulada actual
	                e = (t - s) - y; // Calcula el nuevo error de redondeo
	                s = t; // Actualiza la suma acumulada
	            }
	            c[i][k] = s;
	        }
	    }

	    return c; // Devuelve la matriz de resultado
	}
}
