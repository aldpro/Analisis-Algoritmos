package co.edu.uniquindio.analisis.proyectosegundo.metodos;

import java.util.Arrays;

public class DivideVencerasII {

	public int[] divideVenceras(int vec1[], int vec2[]) {

		if (vec1.length <= 100 || vec2.length <= 100) {
			return tradicional(vec1, vec2);
		}
		int tam = tamaño(vec1, vec2);
		vec1 = completar(vec1, tam, 1);
		vec2 = completar(vec2, tam, 0);
		int w[] = splitArray(vec1, 1);
		int x[] = splitArray(vec1, 0);
		int y[] = splitArray(vec2, 1);
		int z[] = splitArray(vec2, 0);
		int m1[] = divideVenceras(w, y);
		int m3[] = divideVenceras(x, z);
		int r[] = divideVenceras(sumaArray(w, x), sumaArray(y, z));
		int m2[] = restaArray(r, sumaArray(m1, m3));
		return sumaArray(sumaArray(completar(m1, m1.length + tam, 0), completar(m2, m2.length + tam / 2, 0)), m3);
	}

	public int tamaño(int[] vec1, int[] vec2) {
		return Math.max(vec1.length, vec2.length);
	}

	public int[] tradicional(int[] vec1, int[] vec2) {
		int[] result = new int[vec1.length + vec2.length];

		for (int i = vec1.length - 1; i >= 0; i--) {
			for (int j = vec2.length - 1; j >= 0; j--) {
				int product = vec1[i] * vec2[j];
				int tempSum = result[i + j + 1] + product;

				result[i + j + 1] = tempSum % 10;
				result[i + j] += tempSum / 10;
			}
		}

		return result;
	}

	public int[] completar(int vec[], int tam, int id) {
		int res[];
		if (tam > vec.length) {
			int cant = tam - vec.length;
			res = new int[tam];

			if (id == 1) {
				for (int i = 0; i < res.length; i++) {
					if (i < cant)
						res[i] = 0;
					else
						res[i] = vec[i - cant];
				}
				return res;
			} else {
				for (int i = 0; i < res.length; i++) {
					if (i < vec.length)
						res[i] = vec[i];
					else
						res[i] = 0;
				}
				return res;
			}
		}
		return vec;
	}

	public int[] splitArray(int vec[], int id) {
		int tam = vec.length;
		int res[] = new int[tam / 2];
		if (id == 1) {
			for (int i = 0; i < tam / 2; i++)
				res[i] = vec[i];
		} else {
			for (int i = tam / 2; i < tam; i++)
				res[i - tam / 2] = vec[i];
		}
		return res;
	}

	public int[] restaArray(int vec[], int vec2[]) {
		int res[] = new int[vec.length];
		int k, j = vec2.length - 1;
		int bvec = base(vec), bvec2 = base(vec2);
		for (int i = vec.length - 1; i >= bvec; i--) {
			if (j >= bvec2) {
				if (vec[i] >= vec2[j])
					res[i] = vec[i] - vec2[j];
				else {
					k = i;
					vec[k] += 10;
					while (vec[k - 1] == 0 && k > bvec) {
						vec[k - 1] = 9;
						k--;
					}
					vec[k - 1]--;
					res[i] = vec[i] - vec2[j];
				}
				j--;
			} else
				res[i] = vec[i];
		}
		return res;
	}

	public int base(int v[]) {
		int pos = 0;
		while (v[pos] == 0 && pos < v.length - 1) {
			pos++;
		}
		if (pos > 2)
			pos--;
		return pos;
	}

	public int[] sumaArray(int v1[], int v2[]) {
		int res[];
		int mayor[] = v1;
		int menor[] = v2;
		if (v2.length > v1.length) {
			mayor = v2;
			menor = v1;
		}
		res = new int[mayor.length + 1];
		int j = menor.length - 1;
		for (int i = res.length - 1; i > 0; i--) {
			if (j >= 0) {
				int temp = mayor[i - 1] + menor[j];
				res[i] += temp;
				res[i - 1] = res[i] / 10;
				res[i] = res[i] % 10;
				j--;
			} else {
				res[i] += mayor[i - 1];
				res[i - 1] = res[i] / 10;
				res[i] = res[i] % 10;
			}
		}
		return res;
	}
}
