package MultiplicacionDeMatrices;

import org.junit.Test;

import java.util.Random;

public class _7_WinogradOriginal {

    public static int[][] llenarMatrizAleatoria(int filas, int columnas) {
        int[][] matriz = new int[filas][columnas];

        Random random = new Random();

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                matriz[i][j] = random.nextInt(10); // Valor aleatorio entre 0 y 99
            }
        }

        return matriz;
    }

    public void imprimirMatriz(double[][] matriz,String letra,int size)
    {
        // Imprimir la matriz A
        System.out.println("Matriz"+letra+": ");
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println(); // Salto de línea al final de cada fila
        }

    }
    @Test
    public void metodosTraducidos() {

        // Tamaño de las matrices
        int size = 4;

        double[][] matrizA = {
                {7, 3, 4, 9},
                {4, 8, 7, 9},
                {2, 8, 0, 5},
                {0, 2, 3, 7}
        };
        //int[][] matrizB = llenarMatrizAleatoria(size, size);
        imprimirMatriz(matrizA, "A", size);

        double[][] matrizB = {
                {7, 0, 2, 8},
                {0, 0, 2, 7},
                {3, 0, 8, 8},
                {8, 9, 8, 4}
        };
        //int[][] matrizC = llenarMatrizAleatoria(size, size);
        imprimirMatriz(matrizB, "B", size);

        //Resultado de esta multiplicación
        /*
         * {133 81 124 145}
         * {121 81 152 180}
         * {54  45 60  92}
         * {65  63 84  66}
         */

        //Matriz del resultado de la multiplicación
        double[][] matrizC = new double[size][size];

        /**
         *
         */

        WinogradOriginal(matrizA, matrizB, matrizC, size,size,size);

        imprimirMatriz(matrizC, "C", size);
    }

    void WinogradOriginal(double[][] A, double[][] B, double[][] Result, int N, int P, int M) {
        int i, j, k;
        double aux;
        int upsilon = P % 2;
        int gamma = P - upsilon;
        double[] y = new double[M];
        double[] z = new double[N];

        for (i = 0; i < M; i++) {
            aux = 0.0;
            for (j = 0; j < gamma; j += 2) {
                aux += A[i][j] * A[i][j+1];
            }
            y[i] = aux;
        }

        for (i = 0; i < N; i++) {
            aux = 0.0;
            for (j = 0; j < gamma; j += 2) {
                aux += B[j][i] * B[j+1][i];
            }
            z[i] = aux;
        }

        if (upsilon == 1) {
            /*
             * P is odd
             * The value A[i][P]*B[P][k] is missing in all auxiliary sums.
             */
            int PP = P - 1;
            for (i = 0; i < M; i++) {
                for (k = 0; k < N; k++) {
                    aux = 0.0;
                    for (j = 0; j < gamma; j += 2) {
                        aux += (A[i][j] + B[j+1][k]) * (A[i][j+1] + B[j][k]);
                    }
                    Result[i][k] = aux - y[i] - z[k] + A[i][PP] * B[PP][k];
                }
            }
        } else {
            /*
             * P is even
             * The result can be computed with the auxiliary sums.
             */
            for (i = 0; i < M; i++) {
                for (k = 0; k < N; k++) {
                    aux = 0.0;
                    for (j = 0; j < gamma; j += 2) {
                        aux += (A[i][j] + B[j+1][k]) * (A[i][j+1] + B[j][k]);
                    }
                    Result[i][k] = aux - y[i] - z[k];
                }
            }
        }

        // Liberar memoria
        y = null;
        z = null;
    }

}
