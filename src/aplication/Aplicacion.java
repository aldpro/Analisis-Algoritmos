package aplication;

import java.util.Arrays;

import model.Captura;

public class Aplicacion {
	
	public static void main(String[] args) {
		
		Captura captura = new Captura();
		
		int[][] matrizn = {{1234, 2345, 3456, 4567}, {5678, 6789, 7890, 8901}, {9012, 1234, 2345, 3456}, {4567, 5678, 6789, 7890}};
		int[][] matrizm = {{4321, 5432, 6543, 7654}, {8765, 9876, 1098, 2109}, {3210, 4321, 5432, 6543}, {7654, 8765, 9876, 1098}};


		Object[] resultado = captura.capturaNaivStandard(matrizn, matrizm);
		
		long tiempo = (long) resultado[0];
		int[][] matrizNaivStandard = (int[][]) resultado[1];
		
//		System.out.println("Matriz {A}: " + Arrays.deepToString(matrizn) + "\n" + "Matriz {B}: " + Arrays.deepToString(matrizm));
//		System.out.println("Matriz {C}: " + Arrays.deepToString(matrizNaivStandard) + "\n" + "Tiempo: " + tiempo + " [milisegundos]" + "\n" + "Algoritmo: NaivStandard");
		
		System.out.println("Matriz {A}:");
		
		for (int i = 0; i < matrizn.length; i++) {
			  for (int j = 0; j < matrizn[i].length; j++) {
			    System.out.print(matrizn[i][j] + " ");
			  }
			  System.out.println();
		}
		
		System.out.println("\n" + "Matriz {B}:");
		
		for (int i = 0; i < matrizm.length; i++) {
			  for (int j = 0; j < matrizm[i].length; j++) {
			    System.out.print(matrizm[i][j] + " ");
			  }
			  System.out.println();
		}
		
		System.out.println("\n" + "Matriz {C}:");
		
		int digitos = (int) Math.log10(arregloMatriz(matrizNaivStandard)) + 1;
		
		for (int i = 0; i < matrizNaivStandard.length; i++) {
		   for (int j = 0; j < matrizNaivStandard[i].length; j++) {
		     
		     System.out.print(String.format("%" + digitos + "d" + " ",matrizNaivStandard[i][j]));
		   }
		   System.out.println();
		}
		
		System.out.println("Tiempo: " + tiempo + " [milisegundos]" + "\n" + "Algoritmo: NaivStandard");
	}
	
	public static int arregloMatriz(int[][] matriz) {
		int maximo = Integer.MIN_VALUE;
		for (int i = 0; i < matriz.length; i++) {
		  for (int j = 0; j < matriz[i].length; j++) {
		    if (matriz[i][j] > maximo) {
		      maximo = matriz[i][j];
		    }
		   }
		}
		return maximo;
	}
}
