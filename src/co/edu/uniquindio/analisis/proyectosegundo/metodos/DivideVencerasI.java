package co.edu.uniquindio.analisis.proyectosegundo.metodos;

public class DivideVencerasI {

	public static void imprimirArreglo(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]);
		}
		System.out.println();
	}

	// Función para multiplicar dos arreglos que representan números
	public int[] multiplicar(int[] a, int[] b) {
		int n = a.length;

		// Caso base: si ambos arreglos tienen una sola cifra, hacer la multiplicación
		// directamente
		if (n == 1) {
			int[] resultado = new int[2];
			resultado[1] = a[0] * b[0];
			resultado[0] = resultado[1] / 10;
			resultado[1] = resultado[1] % 10;
			return resultado;
		}

		// Dividir los arreglos en dos mitades
		int[] w = new int[n / 2];
		int[] x = new int[n / 2];
		int[] y = new int[n / 2];
		int[] z = new int[n / 2];
		for (int i = 0; i < n / 2; i++) {
			w[i] = a[i];
			y[i] = b[i];
		}
		for (int i = n / 2; i < n; i++) {
			x[i - n / 2] = a[i];
			z[i - n / 2] = b[i];
		}

		// Multiplicar las mitades y sumar los resultados
		int[] wy = multiplicar(w, y);
		int[] wz = multiplicar(w, z);
		int[] xy = multiplicar(x, y);
		int[] xz = multiplicar(x, z);

		// Desplazar los resultados
		int[] resultado = new int[n * 2];
		for (int i = 0; i < wy.length; i++) {
			resultado[i] += wy[i];
		}
		for (int i = 0; i < wz.length; i++) {
			resultado[i + n / 2] += wz[i];
		}
		for (int i = 0; i < xy.length; i++) {
			resultado[i + n / 2] += xy[i];
		}
		for (int i = 0; i < xz.length; i++) {
			resultado[i + n] += xz[i];
		}

		// Acarreos
		for (int i = 0; i < resultado.length - 1; i++) {
			resultado[i + 1] += resultado[i] / 10;
			resultado[i] %= 10;
		}

		// Eliminar ceros sobrantes
		int i = resultado.length - 1;
		while (i > 0 && resultado[i] == 0) {
			i--;
		}
		int[] resultadoFinal = new int[i + 1];
		for (int j = 0; j <= i; j++) {
			resultadoFinal[j] = resultado[j];
		}

		return resultadoFinal;
	}
}
