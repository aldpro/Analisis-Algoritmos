package co.edu.analisis.model;

import java.util.Arrays;

import co.edu.analisis.model.methods.NaivKahan;
import co.edu.analisis.model.methods.NaivLoopUnrollingFour;
import co.edu.analisis.model.methods.NaivLoopUnrollingThree;
import co.edu.analisis.model.methods.NaivLoopUnrollingTwo;
import co.edu.analisis.model.methods.NaivOnArray;
import co.edu.analisis.model.methods.NaivStandard;
import co.edu.analisis.model.methods.WinogradOriginal;
import co.edu.analisis.model.methods.WinogradScaled;

public class Captura {

	public Object[] consultaMetodo(int[][] matrizn, int[][] matrizm, int metodo) {
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
			resultado = capturaNaivLoopUnrollingTwo(matrizn, matrizm);
			break;
		case 5:
			resultado = capturaNaivLoopUnrollingThree(matrizn, matrizm);
			break;
		case 6:
			  resultado = capturaNaivLoopUnrollingFour(matrizn, matrizm);
			break;
		case 7:
			  resultado = capturaWinogradOriginal(matrizn, matrizm);
			break;
		case 8:
			  resultado = capturaWinogradScaled(matrizn, matrizm);
			break;
		case 9:
			  resultado = capturaWinogradOriginal(matrizn, matrizm);
			break;
		case 10:
			  resultado = capturaWinogradOriginal(matrizn, matrizm);
			break;
		case 11:
			  resultado = capturaWinogradOriginal(matrizn, matrizm);
			break;
		case 12:
			  resultado = capturaWinogradOriginal(matrizn, matrizm);
			break;
		case 13:
			  resultado = capturaWinogradOriginal(matrizn, matrizm);
			break;
		case 14:
			  resultado = capturaWinogradOriginal(matrizn, matrizm);
			break;
		case 15:
			  resultado = capturaWinogradOriginal(matrizn, matrizm);
			break;
		case 16:
			  resultado = capturaWinogradOriginal(matrizn, matrizm);
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

	public Object[] capturaNaivLoopUnrollingTwo(int[][] a, int[][] b) {

		NaivLoopUnrollingTwo metodo = new NaivLoopUnrollingTwo();

		int[][] resultadoMatriz;

		long inicioTiempo = System.nanoTime();

		resultadoMatriz = metodo.naivLoopUnrollingTwo(a, b);

		long finTiempo = System.nanoTime(); // .nanoTime() .currentTimeMillis()
		long tiempo = finTiempo - inicioTiempo;

		Object[] respuesta = { tiempo, resultadoMatriz };

		return respuesta;
	}
	
	public Object[] capturaNaivLoopUnrollingThree(int[][] a, int[][] b) {

		NaivLoopUnrollingThree metodo = new NaivLoopUnrollingThree();

		int[][] resultadoMatriz;

		long inicioTiempo = System.nanoTime();

		resultadoMatriz = metodo.naiveLoopUnrollingThree(a, b);

		long finTiempo = System.nanoTime(); // .nanoTime() .currentTimeMillis()
		long tiempo = finTiempo - inicioTiempo;

		Object[] respuesta = { tiempo, resultadoMatriz };

		return respuesta;
	}
	
	public Object[] capturaNaivLoopUnrollingFour(int[][] a, int[][] b) {

		NaivLoopUnrollingFour metodo = new NaivLoopUnrollingFour();

		int[][] resultadoMatriz;

		long inicioTiempo = System.nanoTime();

		resultadoMatriz = metodo.naiveLoopUnrollingFour(a, b);

		long finTiempo = System.nanoTime(); // .nanoTime() .currentTimeMillis()
		long tiempo = finTiempo - inicioTiempo;

		Object[] respuesta = { tiempo, resultadoMatriz };

		return respuesta;
	}
	
	public Object[] capturaWinogradOriginal(int[][] a, int[][] b) {

		WinogradOriginal metodo = new WinogradOriginal();

		int[][] resultadoMatriz;

		long inicioTiempo = System.nanoTime();

		resultadoMatriz = metodo.winogradOriginal(a, b);

		long finTiempo = System.nanoTime(); // .nanoTime() .currentTimeMillis()
		long tiempo = finTiempo - inicioTiempo;

		Object[] respuesta = { tiempo, resultadoMatriz };

		return respuesta;
	}
	
	public Object[] capturaWinogradScaled(int[][] a, int[][] b) {

		WinogradScaled metodo = new WinogradScaled();

		int[][] resultadoMatriz;

		long inicioTiempo = System.nanoTime();

		resultadoMatriz = metodo.winogradScale(a, b);

		long finTiempo = System.nanoTime(); // .nanoTime() .currentTimeMillis()
		long tiempo = finTiempo - inicioTiempo;

		Object[] respuesta = { tiempo, resultadoMatriz };

		return respuesta;
	}
}
