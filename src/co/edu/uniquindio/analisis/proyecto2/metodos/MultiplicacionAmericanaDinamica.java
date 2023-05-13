package co.edu.uniquindio.analisis.proyecto2.metodos;

import java.util.Arrays;

public class MultiplicacionAmericanaDinamica {

    public static int[] multiplicacionAmericana(int[] arreglo1, int[] arreglo2) {
        int n = arreglo1.length;
        int m = arreglo2.length;
        int[] resultado = new int[n + m];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                int prod = arreglo1[i] * arreglo2[j];
                int pos1 = i + j + 1;
                int pos2 = i + j;

                resultado[pos1] += prod % 10;
                resultado[pos2] += prod / 10;
                resultado[pos1 - 1] += resultado[pos1] / 10;
                resultado[pos1] %= 10;
            }
        }

        int i = 0;
        while (i < resultado.length && resultado[i] == 0) {
            i++;
        }

        return Arrays.copyOfRange(resultado, i, resultado.length);
    }

}

