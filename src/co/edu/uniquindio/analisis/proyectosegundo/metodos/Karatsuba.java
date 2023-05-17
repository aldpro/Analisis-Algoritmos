package co.edu.uniquindio.analisis.proyectosegundo.metodos;

import java.util.Arrays;

public class Karatsuba {

	public int[] karatsuba(int[] x, int[] y) {
		int n = Math.max(x.length, y.length);
		if (n <= 200) {
			return naiveMultiply(x, y);
		}

		int m = (n + 1) / 2;

		int[] xLow = Arrays.copyOfRange(x, 0, Math.min(m, x.length));
		int[] xHigh = Arrays.copyOfRange(x, Math.min(m, x.length), x.length);

		int[] yLow = Arrays.copyOfRange(y, 0, Math.min(m, y.length));
		int[] yHigh = Arrays.copyOfRange(y, Math.min(m, y.length), y.length);

		int[] z0 = karatsuba(xLow, yLow);
		int[] z2 = karatsuba(xHigh, yHigh);

		int[] sumX = add(xLow, xHigh);
		int[] sumY = add(yLow, yHigh);

		int[] z1 = subtract(subtract(karatsuba(sumX, sumY), z0), z2);

		int[] result = new int[2 * n];
		System.arraycopy(z0, 0, result, 0, z0.length);
		System.arraycopy(z1, 0, result, m, z1.length);
		System.arraycopy(z2, 0, result, 2 * m, z2.length);

		return result;
	}

	public static int[] add(int[] x, int[] y) {
		int n = Math.max(x.length, y.length);
		int[] result = new int[n];
		int carry = 0;
		for (int i = 0; i < n; i++) {
			int sum = carry;
			if (i < x.length) {
				sum += x[i];
			}
			if (i < y.length) {
				sum += y[i];
			}
			result[i] = sum % 10;
			carry = sum / 10;
		}
		if (carry != 0) {
			result = Arrays.copyOf(result, n + 1);
			result[n] = carry;
		}
		return result;
	}

	public static int[] subtract(int[] x, int[] y) {
		int n = Math.max(x.length, y.length);
		int[] result = new int[n];
		int borrow = 0;
		for (int i = 0; i < n; i++) {
			int diff = borrow;
			if (i < x.length) {
				diff += x[i];
			}
			if (i < y.length) {
				diff -= y[i];
			}
			if (diff < 0) {
				diff += 10;
				borrow = -1;
			} else {
				borrow = 0;
			}
			result[i] = diff;
		}
		while (result.length > 1 && result[result.length - 1] == 0) {
			result = Arrays.copyOf(result, result.length - 1);
		}
		return result;
	}

	public static int[] naiveMultiply(int[] x, int[] y) {
		int n = x.length;
		int m = y.length;
		int[] result = new int[n + m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				result[i + j] += x[i] * y[j];
				result[i + j + 1] += result[i + j] / 10;
				result[i + j] %= 10;
			}
		}
		while (result.length > 1 && result[result.length - 1] == 0) {
			result = Arrays.copyOf(result, result.length - 1);
		}
		return result;
	}
}
