package co.edu.uniquindio.analisis.proyectosegundo.metodos;

public class Rusa {

	public static void main(String[] args) {
		int multiplicador = 221;
		int multiplicando = 1194;

		int dimension = dimensionar(multiplicador);

		int numerosMultiplicador[] = new int[dimension];
		int numerosMultiplicando[] = new int[dimension];

		int almacenador[] = new int[dimension];

		int resultado = multiplicarRusa(multiplicador, multiplicando, numerosMultiplicador, numerosMultiplicando,
				almacenador);

		for (int i = 0; i < numerosMultiplicador.length; i++) {
			System.out.println("Numero1: :" + numerosMultiplicador[i] + "  |    " + " Numero2: "
					+ numerosMultiplicando[i] + "|    " + " Acumulado: " + almacenador[i] + "|");
		}

		System.out.println("Resultado:    " + resultado);
	}

	private static int dimensionar(int multiplicador) {
		int n = 0;
		while (multiplicador != 0) {
			multiplicador = multiplicador / 2;
			n += 1;
		}
		return n;
	}

	private static int multiplicarRusa(int multiplicador, int multiplicando, int[] numerosMultiplicador,
			int[] numerosMultiplicando, int[] almacenador) {
		int sumador = 0;
		int i = 0;

		while (multiplicador != 0) {

			if (multiplicador % 2 == 0) {
				numerosMultiplicador[i] = multiplicador;
				numerosMultiplicando[i] = multiplicando;
				multiplicador = multiplicador / 2;
				multiplicando = multiplicando * 2;
				i += 1;

			} else {
				numerosMultiplicador[i] = multiplicador;
				numerosMultiplicando[i] = multiplicando;
				int n = multiplicando;
				almacenador[i] = n;
				sumador = sumador + n;

				multiplicador = multiplicador / 2;
				multiplicando = multiplicando * 2;
				i += 1;
			}

		}

		return sumador;

	}
}
