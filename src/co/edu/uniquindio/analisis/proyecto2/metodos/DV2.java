package co.edu.uniquindio.analisis.proyecto2.metodos;

import java.util.Arrays;

public class DV2 {

    public int[] multiplicar(int[] a, int[] b) {
        int n = Math.max(a.length, b.length);
        if (n == 1) {
            return new int[]{a[0] * b[0]};
        }
        int m = (n + 1) / 2;

        int[] aLow = Arrays.copyOfRange(a, 0, Math.min(m, a.length));
        int[] aHigh = Arrays.copyOfRange(a, Math.min(m, a.length), a.length);
        int[] bLow = Arrays.copyOfRange(b, 0, Math.min(m, b.length));
        int[] bHigh = Arrays.copyOfRange(b, Math.min(m, b.length), b.length);

        int[] p = multiplicar(aLow, bLow);
        int[] q = multiplicar(aHigh, bHigh);
        int[] r = multiplicar(sum(aLow, aHigh), sum(bLow, bHigh));
        int[] rpq = subtract(subtract(r, p), q);

        int[] result = new int[2 * n];
        System.arraycopy(p, 0, result, 0, p.length);
        System.arraycopy(rpq, 0, result, m, rpq.length);
        System.arraycopy(q, 0, result, 2 * m, q.length);
        return result;
    }

    private static int[] sum(int[] a, int[] b) {
        int n = Math.max(a.length, b.length);
        int[] result = new int[n];
        int carry = 0;
        for (int i = 0; i < n; i++) {
            int x = getDigit(a, i) + getDigit(b, i) + carry;
            result[i] = x % 10;
            carry = x / 10;
        }
        if (carry != 0) {
            result = Arrays.copyOf(result, n + 1);
            result[n] = carry;
        }
        return result;
    }

    private static int[] subtract(int[] a, int[] b) {
        int n = Math.max(a.length, b.length);
        int[] result = new int[n];
        int borrow = 0;
        for (int i = 0; i < n; i++) {
            int x = getDigit(a, i) - getDigit(b, i) - borrow;
            if (x < 0) {
                x += 10;
                borrow = 1;
            } else {
                borrow = 0;
            }
            result[i] = x;
        }
        while (result.length > 1 && result[result.length - 1] == 0) {
            result = Arrays.copyOf(result, result.length - 1);
        }
        return result;
    }

    private static int getDigit(int[] a, int i) {
        if (i < a.length) {
            return a[i];
        } else {
            return 0;
        }
    }


}
