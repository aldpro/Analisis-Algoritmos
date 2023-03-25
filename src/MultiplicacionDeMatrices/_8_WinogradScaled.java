package MultiplicacionDeMatrices;

import org.junit.Test;

import java.util.Random;

public class _8_WinogradScaled extends _7_WinogradOriginal {

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

        WinogradScaled(matrizA, matrizB, matrizC, size,size,size);

        imprimirMatriz(matrizC, "C", size);
    }

    public void WinogradScaled(double[][] A, double[][] B, double[][] Result, int N, int P, int M) {
        int i, j;
        /* Create scaled copies of A and B */
        double[][] CopyA = new double[N][P];
        double[][] CopyB = new double[P][M];
        /* Scaling factors */
        double a = NormInf(A, N, P);
        double b = NormInf(B, P, M);
        double lambda = Math.floor(0.5 + Math.log(b/a)/Math.log(4));
        /* Scaling */
        MultiplyWithScalar(A, CopyA, N, P, Math.pow(2, lambda));
        MultiplyWithScalar(B, CopyB, P, M, Math.pow(2, -lambda));
        /* Using Winograd with scaled matrices */
        WinogradOriginal(CopyA, CopyB, Result, N, P, M);
    }

    public static void MultiplyWithScalar(double[][] A, double[][] B, int N, int M, double scalar) {
        int i, j;
        for (i = 0; i < N; i++) {
            for (j = 0; j < M; j++) {
                B[i][j] = A[i][j] * scalar;
            }
        }
    }

    public static double NormInf(double[][] A, int N, int M) {
        int i, j;
        double max = Double.NEGATIVE_INFINITY;
        for (i = 0; i < N; i++) {
            double sum = 0.0;
            for (j = 0; j < M; j++) {
                sum += Math.abs(A[i][j]);
            }
            if (sum > max) {
                max = sum;
            }
        }
        return max;
    }

}
