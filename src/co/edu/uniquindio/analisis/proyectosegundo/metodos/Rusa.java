package co.edu.uniquindio.analisis.proyectosegundo.metodos;

import java.util.Arrays;

public class Rusa {

    public static int[] multiplicar(int[] num1, int[] num2) {
        int len1 = num1.length;
        int len2 = num2.length;
        int[] resultado = new int[len1 + len2];

        for (int i = len1 - 1; i >= 0; i--) {
            for (int j = len2 - 1; j >= 0; j--) {
                int producto = num1[i] * num2[j];
                int pos1 = i + j;
                int pos2 = i + j + 1;
                int suma = producto + resultado[pos2];

                resultado[pos1] += suma / 10;
                resultado[pos2] = suma % 10;
            }
        }

        return resultado;
    }



	
//	public static void main(String[] args) {
//		int multiplicador = 221;
//		int multiplicando = 1194;
//
//		int dimension = dimensionar(multiplicador);
//
//		int numerosMultiplicador[] = new int[dimension];
//		int numerosMultiplicando[] = new int[dimension];
//
//		int almacenador[] = new int[dimension];
//
//		int resultado = multiplicarRusa(multiplicador, multiplicando, numerosMultiplicador, numerosMultiplicando,
//				almacenador);
//
//		for (int i = 0; i < numerosMultiplicador.length; i++) {
//			System.out.println("Numero1: :" + numerosMultiplicador[i] + "  |    " + " Numero2: "
//					+ numerosMultiplicando[i] + "|    " + " Acumulado: " + almacenador[i] + "|");
//		}
//
//		System.out.println("Resultado:    " + resultado);
//	}
//
//	private static int dimensionar(int multiplicador) {
//		int n = 0;
//		while (multiplicador != 0) {
//			multiplicador = multiplicador / 2;
//			n += 1;
//		}
//		return n;
//	}
//
//	private static int multiplicarRusa(int multiplicador, int multiplicando, int[] numerosMultiplicador,
//			int[] numerosMultiplicando, int[] almacenador) {
//		int sumador = 0;
//		int i = 0;
//
//		while (multiplicador != 0) {
//
//			if (multiplicador % 2 == 0) {
//				numerosMultiplicador[i] = multiplicador;
//				numerosMultiplicando[i] = multiplicando;
//				multiplicador = multiplicador / 2;
//				multiplicando = multiplicando * 2;
//				i += 1;
//
//			} else {
//				numerosMultiplicador[i] = multiplicador;
//				numerosMultiplicando[i] = multiplicando;
//				int n = multiplicando;
//				almacenador[i] = n;
//				sumador = sumador + n;
//
//				multiplicador = multiplicador / 2;
//				multiplicando = multiplicando * 2;
//				i += 1;
//			}
//
//		}
//
//		return sumador;
//
//	}
}
