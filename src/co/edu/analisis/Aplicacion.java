package co.edu.analisis;

import co.edu.analisis.model.Captura;
import co.edu.analisis.model.Metodo;

public class Aplicacion {
	
	public static void main(String[] args) {
		
		double[][] matrizn = {{1234, 2345, 3456, 4567}, {5678, 6789, 7890, 8901}, {9012, 1234, 2345, 3456}, {4567, 5678, 6789, 7890}};
		double[][] matrizm = {{4321, 5432, 6543, 7654}, {8765, 9876, 1098, 2109}, {3210, 4321, 5432, 6543}, {7654, 8765, 9876, 1098}};

		for (int i = 1; i <= 16; i++) {
			resultado(matrizn, matrizm, i);
		}
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
		Metodo met = new Metodo();
		
		String nombreMetodo = " ";
		
		nombreMetodo = met.obtenerNombre(metodo);
		Object[] resultado = captura.consultaMetodo(matrizn, matrizm, metodo);
		
		
		long tiempo = (long) resultado[0];
		double[][] matrizResultado = (double[][]) resultado[1];
		
		imprimirMatriz(matrizn, "A");
		imprimirMatriz(matrizm, "B");
		imprimirMatriz(matrizResultado, "C");
		
		System.out.println("Tiempo: " + tiempo + " [milisegundos]" + "\n" + "Algoritmo: " + nombreMetodo + "\n");
	}

}
