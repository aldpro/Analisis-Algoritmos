package co.edu.analisis.model;

import java.util.Arrays;

import co.edu.analisis.model.methods.NaivKahan;
import co.edu.analisis.model.methods.NaivLoopUnrollingFour;
import co.edu.analisis.model.methods.NaivLoopUnrollingThree;
import co.edu.analisis.model.methods.NaivLoopUnrollingTwo;
import co.edu.analisis.model.methods.NaivOnArray;
import co.edu.analisis.model.methods.NaivStandard;
import co.edu.analisis.model.methods.SequentialBlockThreeFour;
import co.edu.analisis.model.methods.SequentialBlockThreeThree;
import co.edu.analisis.model.methods.StrassenNaiv;
import co.edu.analisis.model.methods.StrassenWinograd;
import co.edu.analisis.model.methods.WinogradOriginal;
import co.edu.analisis.model.methods.WinogradScaled;

public class Captura {

	public Object[] consultaMetodo(double[][] matrizn, double[][] matrizm, int metodo) {
		Object[] resultado = null;

		switch (metodo) {
		case 1:
			resultado = capturaNaivStandard(matrizn, matrizm);
			break;
		case 2:
			resultado = capturaNaivOnArray(matrizn, matrizm);
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
			  resultado = capturaStrassenNaiv(matrizn, matrizm);
			break;
		case 10:
			  resultado = capturaStrassenWinograd(matrizn, matrizm);
			break;
		case 11:
			  resultado = capturaSequentialBlockThreeThree(matrizn, matrizm);
			break;
		case 12:
			  resultado = capturaSequentialBlockThreeFour(matrizn, matrizm);
			break;
//		case 13:
//			  resultado = capturaWinogradOriginal(matrizn, matrizm);
//			break;
//		case 14:
//			  resultado = capturaWinogradOriginal(matrizn, matrizm);
//			break;
//		case 15:
//			  resultado = capturaWinogradOriginal(matrizn, matrizm);
//			break;
//		case 16:
//			  resultado = capturaWinogradOriginal(matrizn, matrizm);
//			break;
		default:
			resultado = null;
			break;
		}

		return resultado;
	}

	public Object[] capturaNaivStandard(double[][] a, double[][] b) {

		NaivStandard metodo = new NaivStandard();

		double[][] resultadoMatriz;

		long inicioTiempo = System.nanoTime();

		resultadoMatriz = metodo.naivStandard(a, b);

		long finTiempo = System.nanoTime(); // .nanoTime() .currentTimeMillis()
		long tiempo = finTiempo - inicioTiempo;

		Object[] respuesta = { tiempo, resultadoMatriz };

		return respuesta;
	}

	public Object[] capturaNaivOnArray(double[][] a, double[][] b) {

		NaivOnArray metodo = new NaivOnArray();

		double[][] resultadoMatriz;

		long inicioTiempo = System.nanoTime();

		resultadoMatriz = metodo.naivOnArray(a, b);

		long finTiempo = System.nanoTime(); // .nanoTime() .currentTimeMillis()
		long tiempo = finTiempo - inicioTiempo;

		Object[] respuesta = { tiempo, resultadoMatriz };

		return respuesta;
	}

	public Object[] capturaNaivKahan(double[][] a, double[][] b) {

		NaivKahan metodo = new NaivKahan();

		double[][] resultadoMatriz;

		long inicioTiempo = System.nanoTime();

		resultadoMatriz = metodo.naivKahan(a, b);

		long finTiempo = System.nanoTime(); // .nanoTime() .currentTimeMillis()
		long tiempo = finTiempo - inicioTiempo;

		Object[] respuesta = { tiempo, resultadoMatriz };

		return respuesta;
	}

	public Object[] capturaNaivLoopUnrollingTwo(double[][] a, double[][] b) {

		NaivLoopUnrollingTwo metodo = new NaivLoopUnrollingTwo();

		double[][] resultadoMatriz;

		long inicioTiempo = System.nanoTime();

		resultadoMatriz = metodo.naivLoopUnrollingTwo(a, b);

		long finTiempo = System.nanoTime(); // .nanoTime() .currentTimeMillis()
		long tiempo = finTiempo - inicioTiempo;

		Object[] respuesta = { tiempo, resultadoMatriz };

		return respuesta;
	}
	
	public Object[] capturaNaivLoopUnrollingThree(double[][] a, double[][] b) {

		NaivLoopUnrollingThree metodo = new NaivLoopUnrollingThree();

		double[][] resultadoMatriz;

		long inicioTiempo = System.nanoTime();

		resultadoMatriz = metodo.naiveLoopUnrollingThree(a, b);

		long finTiempo = System.nanoTime(); // .nanoTime() .currentTimeMillis()
		long tiempo = finTiempo - inicioTiempo;

		Object[] respuesta = { tiempo, resultadoMatriz };

		return respuesta;
	}
	
	public Object[] capturaNaivLoopUnrollingFour(double[][] a, double[][] b) {

		NaivLoopUnrollingFour metodo = new NaivLoopUnrollingFour();

		double[][] resultadoMatriz;

		long inicioTiempo = System.nanoTime();

		resultadoMatriz = metodo.naiveLoopUnrollingFour(a, b);

		long finTiempo = System.nanoTime(); // .nanoTime() .currentTimeMillis()
		long tiempo = finTiempo - inicioTiempo;

		Object[] respuesta = { tiempo, resultadoMatriz };

		return respuesta;
	}
	
	public Object[] capturaWinogradOriginal(double[][] a, double[][] b) {

		WinogradOriginal metodo = new WinogradOriginal();

		double[][] resultadoMatriz;

		long inicioTiempo = System.nanoTime();

		resultadoMatriz = metodo.winogradOriginal(a, b);

		long finTiempo = System.nanoTime(); // .nanoTime() .currentTimeMillis()
		long tiempo = finTiempo - inicioTiempo;

		Object[] respuesta = { tiempo, resultadoMatriz };

		return respuesta;
	}
	
	public Object[] capturaWinogradScaled(double[][] a, double[][] b) {

		WinogradScaled metodo = new WinogradScaled();

		double[][] resultadoMatriz;

		long inicioTiempo = System.nanoTime();

		resultadoMatriz = metodo.winogradScale(a, b);

		long finTiempo = System.nanoTime(); // .nanoTime() .currentTimeMillis()
		long tiempo = finTiempo - inicioTiempo;

		Object[] respuesta = { tiempo, resultadoMatriz };

		return respuesta;
	}
	
	public Object[] capturaStrassenNaiv(double[][] a, double[][] b) {

		StrassenNaiv metodo = new StrassenNaiv();

		double[][] resultadoMatriz;

		long inicioTiempo = System.nanoTime();

		resultadoMatriz = metodo.multiply(a, b);

		long finTiempo = System.nanoTime(); // .nanoTime() .currentTimeMillis()
		long tiempo = finTiempo - inicioTiempo;

		Object[] respuesta = { tiempo, resultadoMatriz };

		return respuesta;
	}
	
	public Object[] capturaStrassenWinograd(double[][] a, double[][] b) {

		StrassenWinograd metodo = new StrassenWinograd();

		double[][] resultadoMatriz;

		long inicioTiempo = System.nanoTime();

		resultadoMatriz = metodo.multiply(a, b);

		long finTiempo = System.nanoTime(); // .nanoTime() .currentTimeMillis()
		long tiempo = finTiempo - inicioTiempo;

		Object[] respuesta = { tiempo, resultadoMatriz };

		return respuesta;
	}
	
	public Object[] capturaSequentialBlockThreeThree(double[][] a, double[][] b) {

		SequentialBlockThreeThree metodo = new SequentialBlockThreeThree();

		double[][] resultadoMatriz;

		long inicioTiempo = System.nanoTime();

		resultadoMatriz = metodo.multiply(a, b, 1);

		long finTiempo = System.nanoTime(); // .nanoTime() .currentTimeMillis()
		long tiempo = finTiempo - inicioTiempo;

		Object[] respuesta = { tiempo, resultadoMatriz };

		return respuesta;
	}
	
	public Object[] capturaSequentialBlockThreeFour(double[][] a, double[][] b) {

		SequentialBlockThreeFour metodo = new SequentialBlockThreeFour();

		double[][] resultadoMatriz;

		long inicioTiempo = System.nanoTime();

		resultadoMatriz = metodo.multiply(a, b, 1);

		long finTiempo = System.nanoTime(); // .nanoTime() .currentTimeMillis()
		long tiempo = finTiempo - inicioTiempo;

		Object[] respuesta = { tiempo, resultadoMatriz };

		return respuesta;
	}
}
