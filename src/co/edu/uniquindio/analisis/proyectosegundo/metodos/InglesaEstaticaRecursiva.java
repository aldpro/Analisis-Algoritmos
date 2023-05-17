package co.edu.uniquindio.analisis.proyectosegundo.metodos;

import java.util.Arrays;

public class InglesaEstaticaRecursiva {

    public int[] multiplicaInglesa(int[] arreglo1, int[] arreglo2) {
        int n = arreglo1.length;
        int m = arreglo2.length;

        if (n == 0 || m == 0) {
            return new int[0];
        }

        if (n == 1 && m == 1) {
            int[] resultado = new int[1];
            resultado[0] = arreglo1[0] * arreglo2[0];
            return resultado;
        }

        int medio = Math.max(n, m) / 2;

        int[] a = Arrays.copyOfRange(arreglo1, medio, n);
        int[] b = Arrays.copyOfRange(arreglo1, 0, medio);
        int[] c = Arrays.copyOfRange(arreglo2, medio, m);
        int[] d = Arrays.copyOfRange(arreglo2, 0, medio);

        int[] z2 = multiplicaInglesa(b, d);
        int[] z0 = multiplicaInglesa(a, c);
        int[] z1 = resta(multiplicaInglesa(suma(a, b), suma(c, d)), suma(z0, z2));

        int[] resultado = new int[n + m];
        System.arraycopy(z0, 0, resultado, 0, z0.length);
        System.arraycopy(z1, 0, resultado, medio, z1.length);
        System.arraycopy(z2, 0, resultado, medio * 2, z2.length);

        return resultado;
    }

    public int[] suma(int[] arreglo1, int[] arreglo2) {
        int n = arreglo1.length;
        int m = arreglo2.length;
        int tam = Math.max(n, m) + 1;
        int[] resultado = new int[tam];

        int i = n - 1, j = m - 1, k = tam - 1, carry = 0;
        while (i >= 0 || j >= 0) {
            int sum = carry;
            if (i >= 0) {
                sum += arreglo1[i--];
            }
            if (j >= 0) {
                sum += arreglo2[j--];
            }
            resultado[k--] = sum % 10;
            carry = sum / 10;
        }

        if (carry > 0) {
            resultado[k--] = carry;
        }

        return Arrays.copyOfRange(resultado, k + 1, tam);
    }

    public int[] resta(int[] arreglo1, int[] arreglo2) {
        int n = arreglo1.length;
        int m = arreglo2.length;
        int tam = Math.max(n, m);
        int[] resultado = new int[tam];

        int i = n - 1, j = m - 1, k = tam - 1, carry = 0;
        while (i >= 0) {
            int diff = carry + arreglo1[i];
            if (j >= 0) {
                diff -= arreglo2[j--];
            }
            if (diff < 0) {
                diff += 10;
                carry = -1;
            } else {
                carry = 0;
            }
            resultado[k--] = diff;
            i--;
        }

        while (k >= 0 && resultado[k] == 0) {
            k--;
        }

        if (k < 0) {
            return new int[1];
        }

        return Arrays.copyOfRange(resultado, 0, k + 1);
    }

}
