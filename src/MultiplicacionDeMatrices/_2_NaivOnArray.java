package MultiplicacionDeMatrices;

import org.junit.Test;

import java.util.Random;

public class _2_NaivOnArray {

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

        NaivOnArray(matrizA, matrizB, matrizC, size,size,size);

        imprimirMatriz(matrizC, "C", size);
    }

    public void NaivOnArray(double[][] matrizA, double[][] matrizB, double[][] matrizC, int N, int P , int M){
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                matrizC[i][j] = 0.0;
                for (int k = 0; k < P; k++) {
                    matrizC[i][j] += matrizA[i][k] * matrizB[k][j];
                }
            }
        }
    }
}
