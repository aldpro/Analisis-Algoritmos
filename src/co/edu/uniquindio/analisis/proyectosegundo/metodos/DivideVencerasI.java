package co.edu.uniquindio.analisis.proyectosegundo.metodos;

public class DivideVencerasI {

	public int[] divideVenceras1(int vec1[],int vec2[],int n) {
		int[] resultado, x, y, z, w, r, auxr, s, auxs, t, auxt, u, res, res2, res3;
		if(n==2)
		{
			resultado = AlgoritmoTradicional(vec1,vec2,n);
			return resultado;
		}else{
			x = new int[(n + 1) / 2];
			y = new int[(n + 1) / 2];
			z = new int[(n + 1) / 2];
			w = new int[(n + 1) / 2];
			for (int i = 0; i < (n + 1) / 2; i++) {
				w[i] = vec1[i];
				y[i] = vec2[i];
				x[i] = vec1[i + (n + 1) / 2];
				z[i] = vec2[i + (n + 1) / 2];
			}
			r = new int[2 * n];
			auxr = new int[2 * n];
			iniceros(r, 2 * n);
			auxr = divideVenceras1(w, y, (n + 1) / 2);
			for (int i = 0; i < 2 * n; i++) {
				r[i] = auxr[i];
			}
			s = new int[n + (n + 1) / 2];
			auxs = new int[n + (n + 1) / 2];
			iniceros(s, n + (n + 1) / 2);
			auxs = divideVenceras1(w, z, (n + 1) / 2);
			for (int i = 0; i < n + (n + 1) / 2; i++) {
				s[i] = auxs[i];
			}
			t = new int[(n + 1) / 2 + n];
			auxt = new int[(n + 1) / 2 + n];
			iniceros(t, (n + 1) / 2 + n);
			auxt = divideVenceras1(x, y, (n + 1) / 2);
			for (int i = 0; i < (n + 1) / 2 + n; i++) {
				t[i] = auxt[i];
			}
			u = new int[n];
			iniceros(u, n);
			u = divideVenceras1(x, z, (n + 1) / 2);
			res = new int[2 * n];
			iniceros(res, 2 * n);
			res = suma(r, 2 * n, s, n + (n + 1) / 2);
			res2 = new int[(n + 1) / 2 + n];
			iniceros(res2, (n + 1) / 2 + n);
			res2 = suma(t, (n + 1) / 2 + n, u, n);
			res3 = new int[2 * n];
			iniceros(res3, 2 * n);
			res3 = suma(res, 2 * n, res2, (n + 1) / 2 + n);
			return res3;
		}
	}

	void iniceros(int arreglo[],int tamano)
	{
		for(int i=0; i<tamano; i++)
		{
			arreglo[i]=0;
		}
	}

	public int[] AlgoritmoTradicional(int[] vec1, int[] vec2, int n) {
		int[] resultado = new int[n * 2 + 1];
		int carry = 0;

		for (int i = n - 1; i >= 0; i--) {
			int multiplicacion = vec1[i] * vec2[i] + carry;
			resultado[i + n] = multiplicacion % 10;
			carry = multiplicacion / 10;
		}

		for (int i = n - 1; i >= 0; i--) {
			int suma = resultado[i + n] + resultado[i] + carry;
			resultado[i + n] = suma % 10;
			carry = suma / 10;
		}

		if (carry > 0) {
			resultado[0] = carry;
		}

		return resultado;
	}

	public int[] suma(int[] arreglo1, int tamano1, int[] arreglo2, int tamano2) {
		int maxTamano = Math.max(tamano1, tamano2);
		int[] resultado = new int[maxTamano];
		int carry = 0;

		for (int i = 0; i < maxTamano; i++) {
			int sum = carry;
			if (i < tamano1) {
				sum += arreglo1[i];
			}
			if (i < tamano2) {
				sum += arreglo2[i];
			}

			resultado[i] = sum % 10;
			carry = sum / 10;
		}

		if (carry > 0) {
			int[] resultadoFinal = new int[maxTamano];
			resultadoFinal[0] = carry;
			System.arraycopy(resultado, 0, resultadoFinal, 1, maxTamano);
			return resultadoFinal;
		} else {
			return resultado;
		}
	}
}
