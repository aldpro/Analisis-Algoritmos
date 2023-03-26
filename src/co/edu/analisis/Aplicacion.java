package co.edu.analisis;

import java.util.Arrays;

import co.edu.analisis.model.Captura;

public class Aplicacion {
	
	public static void main(String[] args) {
		
		double[][] matrizn = {{1234, 2345, 3456, 4567}, {5678, 6789, 7890, 8901}, {9012, 1234, 2345, 3456}, {4567, 5678, 6789, 7890}};
		double[][] matrizm = {{4321, 5432, 6543, 7654}, {8765, 9876, 1098, 2109}, {3210, 4321, 5432, 6543}, {7654, 8765, 9876, 1098}};

//		for (int i = 1; i <= 12; i++) {
//			resultado(matrizn, matrizm, i);
//		}
		resultado(matrizn, matrizm, 1);
		resultado(matrizn, matrizm, 2);
		resultado(matrizn, matrizm, 3);
		resultado(matrizn, matrizm, 4);
		resultado(matrizn, matrizm, 5);
		resultado(matrizn, matrizm, 6);
		resultado(matrizn, matrizm, 7);
		resultado(matrizn, matrizm, 8);
		resultado(matrizn, matrizm, 9);
		resultado(matrizn, matrizm, 10);
		resultado(matrizn, matrizm, 11);
		resultado(matrizn, matrizm, 12);
//		resultado(matrizn, matrizm, 13);
//		resultado(matrizn, matrizm, 14);
//		resultado(matrizn, matrizm, 15);
//		resultado(matrizn, matrizm, 16);
	}
	
	public static double arregloMatriz(double[][] matriz) {
	    double maximo = Double.MIN_VALUE;
	    for (int i = 0; i < matriz.length; i++) {
	      for (int j = 0; j < matriz[i].length; j++) {
	        if (matriz[i][j] > maximo) {
	          maximo = matriz[i][j];
	        }
	       }
	    }
	    return maximo;
	  }
	  
	  public static void imprimirMatriz(double[][] matriz, String nombre) {
	    int digitos = (int) Math.ceil(Math.log10(arregloMatriz(matriz)));
	    
	    System.out.println("Matriz [" + nombre + "]:");
	    
	    for (int i = 0; i < matriz.length; i++) {
	      for (int j = 0; j < matriz[i].length; j++) {
	        System.out.printf("%" + digitos + ".0f" + " ", matriz[i][j]);
	      }
	      System.out.println();
	    }
	    System.out.println();
	  }
	
	public static void resultado (double[][] matrizn, double[][] matrizm, int metodo) {
		Captura captura = new Captura();
		
		Object[] resultado = captura.consultaMetodo(matrizn, matrizm, metodo);
		
		long tiempo = (long) resultado[0];
		double[][] matrizResultado = (double[][]) resultado[1];
		
		imprimirMatriz(matrizn, "A");
		imprimirMatriz(matrizm, "B");
		imprimirMatriz(matrizResultado, "C");
		
		System.out.println("Tiempo: " + tiempo + " [milisegundos]" + "\n" + "Algoritmo: " + metodo + "\n");
	}
}
