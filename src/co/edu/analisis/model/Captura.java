package co.edu.analisis.model;

import java.util.Arrays;

public class Captura {

	Multiplicacion metodos = new Multiplicacion();

	public Object[] consultaMetodo (int[][] matrizn, int[][] matrizm, int metodo) {
		Object[] resultado = null;
		
		switch (metodo) {
		  case 1:
			  resultado = capturaNaivStandard(matrizn, matrizm);
		    break;
		  case 2:
//			  resultado
		    break;
		  case 3:
//			  resultado
		    break;
		  case 4:
//			  resultado
		    break;
		  case 5:
//			  resultado
		    break;
		  case 6:
//			  resultado
		    break;
		  case 7:
//			  resultado
		    break;
		  default:
			  resultado = null;
		    break;
		}
		
		return resultado;
	}
	
	public Object[] capturaNaivStandard(int[][] a, int[][] b) {
		
		int[][] resultadoMatriz;

		long inicioTiempo = System.nanoTime();

		resultadoMatriz = metodos.naivStandard(a, b);

		long finTiempo = System.nanoTime(); // .nanoTime() .currentTimeMillis()
		long tiempo = finTiempo - inicioTiempo;
		
		Object[] respuesta = { tiempo, resultadoMatriz };
		
		return respuesta;
	}

}
