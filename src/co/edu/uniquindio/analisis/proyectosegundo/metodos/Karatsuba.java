package co.edu.uniquindio.analisis.proyectosegundo.metodos;

import java.math.BigInteger;
import java.util.Arrays;

public class Karatsuba {
	int[] Multiply_Base(int[] a, int power) {
		int[] a2 = new int[a.length + power];

		for (int i = 0; i < a.length; i++)
			a2[i] = a[i];

		return a2;
	}

	int[] Equal(int[] a, int[] b) {

		int diff = a.length - b.length;

		int[] b2 = new int[a.length];

		for (int i = diff; i < a.length; i++)
			b2[i] = b[i - diff];

		return b2;
	}

	static int Maximum(int a, int b) {
		if (a > b)
			return a;

		else
			return b;
	}

	int[] Add(int[] a, int[] b) {

		b = Equal(a, b);

		int[] result = new int[a.length + 1];

		for (int i = result.length - 1; i >= 1; i--) {
			result[i] += a[i - 1] + b[i - 1];

			if (result[i] >= 10) {
				result[i - 1] += result[i] / 10;
				result[i] = result[i] % 10;

			}
		}

		if (result[0] == 0) {
			int[] result2 = new int[a.length];

			for (int i = 0; i < result2.length; i++)
				result2[i] = result[i + 1];

			return result2;

		}
		return result;
	}

	int[] Substract(int[] a, int[] b) {

		if (a.length > b.length) {
			b = Equal(a, b);
		}

		int sub = 0;
		int carry = 0;

		int[] result = new int[a.length];

		for (int i = a.length - 1; i >= 0; i--) {

			sub = a[i] - b[i] - carry;
			carry = 0;

			if (sub < 0) {
				carry = 1;
				sub += 10;
			}
			result[i] = sub;

		}
		int temp = 0;
		while (temp < result.length && result[temp] == 0) {
			temp++;
		}

		if (temp != 0) {
			int[] result2 = new int[result.length - temp];

			for (int i = 0; i < result2.length; i++)
				result2[i] = result[i + temp];

			return result2;
		}

		return result;
	}

	int[] SubArray(int[] a, int start, int end) {

		int[] result = new int[end - start + 1];

		for (int i = 0, j = start; i < result.length && j <= end; i++, j++) {
			result[i] = a[j];
		}

		return result;
	}

	public int[] Multiplication(int[] a, int[] b) {

		if (a.length > b.length)
			b = Equal(a, b);

		if (a.length < b.length)
			a = Equal(b, a);

		if (a.length == 1 && b.length == 1) {
			int product = a[0] * b[0];

			if (product >= 10) {
				int[] result = new int[2];
				result[0] = product / 10;
				result[1] = product % 10;
				return result;
			}

			else {
				int[] result = new int[1];
				result[0] = product;
				return result;
			}

		}

		else {
			int n = a.length;

			int m = n / 2;

			int[] al = SubArray(a, 0, n - m - 1);
			int[] ar = SubArray(a, n - m, a.length - 1);
			int[] bl = SubArray(b, 0, n - m - 1);
			int[] br = SubArray(b, n - m, a.length - 1);

			int[] z2 = Multiplication(al, bl);
			int[] z0 = Multiplication(ar, br);
			int[] z1 = Substract(Substract(Multiplication(Add(al, ar), Add(bl, br)), z2), z0);

			return Add(Add(Multiply_Base(z2, 2 * m), Multiply_Base(z1, m)), z0);
		}
	}
}
