package co.edu.analisis.model.methods;

public class StrassenWinograd {

    public double[][] multiply(double[][] a, double[][] b) {
        int n = a.length;
        double[][] c = new double[n][n];
        if (n == 1) {
            c[0][0] = a[0][0] * b[0][0];
        } else {
            int m = n / 2;
            double[][] A11 = new double[m][m];
            double[][] A12 = new double[m][m];
            double[][] A21 = new double[m][m];
            double[][] A22 = new double[m][m];
            double[][] B11 = new double[m][m];
            double[][] B12 = new double[m][m];
            double[][] B21 = new double[m][m];
            double[][] B22 = new double[m][m];
            
            // Dividir las matrices A y B en cuatro submatrices
            divide(a, A11, 0, 0);
            divide(a, A12, 0, m);
            divide(a, A21, m, 0);
            divide(a, A22, m, m);
            divide(b, B11, 0, 0);
            divide(b, B12, 0, m);
            divide(b, B21, m, 0);
            divide(b, B22, m, m);
            
            // Calcular los productos parciales
            double[][] M1 = multiply(add(A11, A22), add(B11, B22));
            double[][] M2 = multiply(add(A21, A22), B11);
            double[][] M3 = multiply(A11, subtract(B12, B22));
            double[][] M4 = multiply(A22, subtract(B21, B11));
            double[][] M5 = multiply(add(A11, A12), B22);
            double[][] M6 = multiply(subtract(A21, A11), add(B11, B12));
            double[][] M7 = multiply(subtract(A12, A22), add(B21, B22));
            
            // Calcular las submatrices de la matriz resultante
            double[][] C11 = add(subtract(add(M1, M4), M5), M7);
            double[][] C12 = add(M3, M5);
            double[][] C21 = add(M2, M4);
            double[][] C22 = add(subtract(add(M1, M3), M2), M6);
            
            // Combinar las submatrices de la matriz resultante en una sola matriz
            combine(C11, c, 0, 0);
            combine(C12, c, 0, m);
            combine(C21, c, m, 0);
            combine(C22, c, m, m);
        }
        return c;
    }
    
    // Función para dividir la matriz en cuatro submatrices
    public void divide(double[][] P, double[][] C, int rowb, int colb) {
        for (int i1 = 0, i2 = rowb; i1 < C.length; i1++, i2++) {
            for (int j1 = 0, j2 = colb; j1 < C.length; j1++, j2++) {
                C[i1][j1] = P[i2][j2];
            }
        }
    }
    
 // Función para combinar cuatro submatrices en una sola matriz
    public void combine(double[][] C, double[][] P, int rowb, int colb) {
        for (int i1 = 0, i2 = rowb; i1 < C.length; i1++, i2++) {
            for (int j1 = 0, j2 = colb; j1 < C.length; j1++, j2++) {
                P[i2][j2] = C[i1][j1];
            }
        }
    }

    // Función para sumar dos matrices
    public double[][] add(double[][] a, double[][] b) {
        int n = a.length;
        double[][] c = new double[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                c[i][j] = a[i][j] + b[i][j];
            }
        }
        return c;
    }

    // Función para restar dos matrices
    public double[][] subtract(double[][] a, double[][] b) {
        int n = a.length;
        double[][] c = new double[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                c[i][j] = a[i][j] - b[i][j];
            }
        }
        return c;
    }
}
