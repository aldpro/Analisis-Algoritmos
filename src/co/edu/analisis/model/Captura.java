package co.edu.analisis.model;

import java.util.Arrays;

import co.edu.analisis.model.methods.NaivKahan;
import co.edu.analisis.model.methods.NaivLoopUnrollingTwo;
import co.edu.analisis.model.methods.NaivOnArray;
import co.edu.analisis.model.methods.NaivStandard;

public class Captura {

	public Object[] consultaMetodo (int[][] matrizn, int[][] matrizm, int metodo) {
		Object[] resultado = null;
		
		switch (metodo) {
		  case 1:
			  resultado = capturaNaivStandard(matrizn, matrizm);
		    break;
		  case 2:
			  resultado = capturaNaivStandard(matrizn, matrizm);
		    break;
		  case 3:
			  resultado = capturaNaivKahan(matrizn, matrizm);
		    break;
		  case 4:
			  resultado = capturaNaiveLoopUnrollingTwo(matrizn, matrizm);
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
		
		NaivStandard metodo = new NaivStandard();
		
		int[][] resultadoMatriz;

		long inicioTiempo = System.nanoTime();

		resultadoMatriz = metodo.naivStandard(a, b);

		long finTiempo = System.nanoTime(); // .nanoTime() .currentTimeMillis()
		long tiempo = finTiempo - inicioTiempo;
		
		Object[] respuesta = { tiempo, resultadoMatriz };
		
		return respuesta;
	}

	
	public Object[] capturaNaivOnArray(int[][] a, int[][] b) {
		
		NaivOnArray metodo = new NaivOnArray();
		
		int[][] resultadoMatriz;

		long inicioTiempo = System.nanoTime();

		resultadoMatriz = metodo.naivOnArray(a, b);

		long finTiempo = System.nanoTime(); // .nanoTime() .currentTimeMillis()
		long tiempo = finTiempo - inicioTiempo;
		
		Object[] respuesta = { tiempo, resultadoMatriz };
		
		return respuesta;
	}
	
	
	public Object[] capturaNaivKahan(int[][] a, int[][] b) {
		
		NaivKahan metodo = new NaivKahan();
		
		int[][] resultadoMatriz;

		long inicioTiempo = System.nanoTime();

		resultadoMatriz = metodo.naivKahan(a, b);

		long finTiempo = System.nanoTime(); // .nanoTime() .currentTimeMillis()
		long tiempo = finTiempo - inicioTiempo;
		
		Object[] respuesta = { tiempo, resultadoMatriz };
		
		return respuesta;
	}
	
	
	public Object[] capturaNaiveLoopUnrollingTwo(int[][] a, int[][] b) {
		
		NaivLoopUnrollingTwo metodo = new NaivLoopUnrollingTwo();
		
		int[][] resultadoMatriz;

		long inicioTiempo = System.nanoTime();

		resultadoMatriz = metodo.naiveLoopUnrollingTwo(a, b);

		long finTiempo = System.nanoTime(); // .nanoTime() .currentTimeMillis()
		long tiempo = finTiempo - inicioTiempo;
		
		Object[] respuesta = { tiempo, resultadoMatriz };
		
		return respuesta;
	}
}
