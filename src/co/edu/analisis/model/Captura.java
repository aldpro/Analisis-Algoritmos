package co.edu.analisis.model;

import java.util.Arrays;
import java.util.HashMap;

import co.edu.analisis.model.methods.NaivKahan;
import co.edu.analisis.model.methods.NaivLoopUnrollingFour;
import co.edu.analisis.model.methods.NaivLoopUnrollingThree;
import co.edu.analisis.model.methods.NaivLoopUnrollingTwo;
import co.edu.analisis.model.methods.NaivOnArray;
import co.edu.analisis.model.methods.NaivStandard;
import co.edu.analisis.model.methods.ParallelBlockFourFive;
import co.edu.analisis.model.methods.ParallelBlockFourFour;
import co.edu.analisis.model.methods.ParallelBlockFourThree;
import co.edu.analisis.model.methods.SequentialBlockThreeFive;
import co.edu.analisis.model.methods.SequentialBlockThreeFour;
import co.edu.analisis.model.methods.SequentialBlockThreeThree;
import co.edu.analisis.model.methods.StrassenNaiv;
import co.edu.analisis.model.methods.StrassenWinograd;
import co.edu.analisis.model.methods.WinogradOriginal;
import co.edu.analisis.model.methods.WinogradScaled;

public class Captura {

	public Object[] consultaMetodo(double[][] matrizn, double[][] matrizm, int metodo) {
		Object[] ejecucion = null;
		
		switch (metodo) {
		case 1:
			ejecucion = capturaNaivStandard(matrizn, matrizm);
			break;
		case 2:
			ejecucion = capturaNaivOnArray(matrizn, matrizm);
			break;
		case 3:
			ejecucion = capturaNaivKahan(matrizn, matrizm);
			break;
		case 4:
			ejecucion = capturaNaivLoopUnrollingTwo(matrizn, matrizm);
			break;
		case 5:
			ejecucion = capturaNaivLoopUnrollingThree(matrizn, matrizm);
			break;
		case 6:
			  ejecucion = capturaNaivLoopUnrollingFour(matrizn, matrizm);
			break;
		case 7:
			  ejecucion = capturaWinogradOriginal(matrizn, matrizm);
			break;
		case 8:
			  ejecucion = capturaWinogradScaled(matrizn, matrizm);
			break;
		case 9:
			  ejecucion = capturaStrassenNaiv(matrizn, matrizm);
			break;
		case 10:
			  ejecucion = capturaStrassenWinograd(matrizn, matrizm);
			break;
		case 11:
			  ejecucion = capturaSequentialBlockThreeThree(matrizn, matrizm);
			break;
		case 12:
			  ejecucion = capturaSequentialBlockThreeFour(matrizn, matrizm);
			break;
		case 13:
			  ejecucion = capturaSequentialBlockThreeFive(matrizn, matrizm);
			break;
		case 14:
			  ejecucion = capturaParallelBlockFourThree(matrizn, matrizm);
			break;
		case 15:
			  ejecucion = capturaParallelBlockFourFour(matrizn, matrizm);
			break;
		case 16:
			  ejecucion = capturaParallelBlockFourFive(matrizn, matrizm);
			break;
		default:
			ejecucion = null;
			break;
		}

		return ejecucion;
	}
	
	public Object[] capturaNaivStandard(double[][] a, double[][] b) {

		NaivStandard metodo = new NaivStandard();

		int n = a.length;
		int p = b.length;
		int m = b[0].length;
		
		double[][] resultadoMatriz;
		double[][] c = new double[n][m];
		
		long inicioTiempo = System.nanoTime();

		resultadoMatriz = metodo.naivStandard(a, b, c, n, p, m);

		long finTiempo = System.nanoTime(); // .nanoTime() .currentTimeMillis()
		long tiempo = finTiempo - inicioTiempo;

		Object[] respuesta = { tiempo, resultadoMatriz };

		return respuesta;
	}

	public Object[] capturaNaivOnArray(double[][] a, double[][] b) {

		NaivOnArray metodo = new NaivOnArray();

		int n = a.length;
		int p = b.length;
		int m = b[0].length;
		
		double[][] resultadoMatriz;
		double[][] c = new double[n][m];

		long inicioTiempo = System.nanoTime();

		resultadoMatriz = metodo.naivOnArray(a, b, c, n, p, m);

		long finTiempo = System.nanoTime(); // .nanoTime() .currentTimeMillis()
		long tiempo = finTiempo - inicioTiempo;

		Object[] respuesta = { tiempo, resultadoMatriz };

		return respuesta;
	}

	public Object[] capturaNaivKahan(double[][] a, double[][] b) {

		NaivKahan metodo = new NaivKahan();

		int n = a.length;
		int p = b.length;
		int m = b[0].length;
		
		double[][] resultadoMatriz;
		double[][] c = new double[n][m];


		long inicioTiempo = System.nanoTime();

		resultadoMatriz = metodo.naivKahan(a, b, c, n, p, m);

		long finTiempo = System.nanoTime(); // .nanoTime() .currentTimeMillis()
		long tiempo = finTiempo - inicioTiempo;

		Object[] respuesta = { tiempo, resultadoMatriz };

		return respuesta;
	}

	public Object[] capturaNaivLoopUnrollingTwo(double[][] a, double[][] b) {

		NaivLoopUnrollingTwo metodo = new NaivLoopUnrollingTwo();

		int n = a.length;
		int p = b.length;
		int m = b[0].length;
		
		double[][] resultadoMatriz;
		double[][] c = new double[n][m];

		long inicioTiempo = System.nanoTime();

		resultadoMatriz = metodo.naivLoopUnrollingTwo(a, b, c, n, p, m);

		long finTiempo = System.nanoTime(); // .nanoTime() .currentTimeMillis()
		long tiempo = finTiempo - inicioTiempo;

		Object[] respuesta = { tiempo, resultadoMatriz };

		return respuesta;
	}
	
	public Object[] capturaNaivLoopUnrollingThree(double[][] a, double[][] b) {

		NaivLoopUnrollingThree metodo = new NaivLoopUnrollingThree();

		int n = a.length;
		int p = b.length;
		int m = b[0].length;
		
		double[][] resultadoMatriz;
		double[][] c = new double[n][m];

		long inicioTiempo = System.nanoTime();

		resultadoMatriz = metodo.naiveLoopUnrollingThree(a, b, c, n, p, m);

		long finTiempo = System.nanoTime(); // .nanoTime() .currentTimeMillis()
		long tiempo = finTiempo - inicioTiempo;

		Object[] respuesta = { tiempo, resultadoMatriz };

		return respuesta;
	}
	
	public Object[] capturaNaivLoopUnrollingFour(double[][] a, double[][] b) {

		NaivLoopUnrollingFour metodo = new NaivLoopUnrollingFour();

		int n = a.length;
		int p = b.length;
		int m = b[0].length;
		
		double[][] resultadoMatriz;
		double[][] c = new double[n][m];

		long inicioTiempo = System.nanoTime();

		resultadoMatriz = metodo.naivLoopUnrollingFour(a, b, c, n, p, m);

		long finTiempo = System.nanoTime(); // .nanoTime() .currentTimeMillis()
		long tiempo = finTiempo - inicioTiempo;

		Object[] respuesta = { tiempo, resultadoMatriz };

		return respuesta;
	}
	
	public Object[] capturaWinogradOriginal(double[][] a, double[][] b) {

		WinogradOriginal metodo = new WinogradOriginal();

		int n = a.length;
		int p = b.length;
		int m = b[0].length;
		
		double[][] resultadoMatriz;
		double[][] c = new double[n][m];

		long inicioTiempo = System.nanoTime();

		resultadoMatriz = metodo.winogradOriginal(a, b, c, n, p, m);

		long finTiempo = System.nanoTime(); // .nanoTime() .currentTimeMillis()
		long tiempo = finTiempo - inicioTiempo;

		Object[] respuesta = { tiempo, resultadoMatriz };

		return respuesta;
	}
	
	public Object[] capturaWinogradScaled(double[][] a, double[][] b) {

		WinogradScaled metodo = new WinogradScaled();

		int n = a.length;
		int p = b.length;
		int m = b[0].length;
		
		double[][] resultadoMatriz;
		double[][] c = new double[n][m];

		long inicioTiempo = System.nanoTime();

		resultadoMatriz = metodo.winogradScaled(a, b, c, n, p, m);

		long finTiempo = System.nanoTime(); // .nanoTime() .currentTimeMillis()
		long tiempo = finTiempo - inicioTiempo;

		Object[] respuesta = { tiempo, resultadoMatriz };

		return respuesta;
	}
	
	public Object[] capturaStrassenNaiv(double[][] a, double[][] b) {

		StrassenNaiv metodo = new StrassenNaiv();

		int n = a.length;
		int p = b.length;
		int m = b[0].length;
		
		double[][] resultadoMatriz;
		double[][] c = new double[n][m];

		long inicioTiempo = System.nanoTime();

		resultadoMatriz = metodo.strassenNaiv(a, b, c, n, p, m);

		long finTiempo = System.nanoTime(); // .nanoTime() .currentTimeMillis()
		long tiempo = finTiempo - inicioTiempo;

		Object[] respuesta = { tiempo, resultadoMatriz };

		return respuesta;
	}
	
	public Object[] capturaStrassenWinograd(double[][] a, double[][] b) {

		StrassenWinograd metodo = new StrassenWinograd();

		int n = a.length;
		int p = b.length;
		int m = b[0].length;
		
		double[][] resultadoMatriz;
		double[][] c = new double[n][m];

		long inicioTiempo = System.nanoTime();

		resultadoMatriz = metodo.strassenWinograd(a, b, c, n, p, m);

		long finTiempo = System.nanoTime(); // .nanoTime() .currentTimeMillis()
		long tiempo = finTiempo - inicioTiempo;

		Object[] respuesta = { tiempo, resultadoMatriz };

		return respuesta;
	}
	
	public Object[] capturaSequentialBlockThreeThree(double[][] a, double[][] b) {

		SequentialBlockThreeThree metodo = new SequentialBlockThreeThree();

		double[][] resultadoMatriz;

		long inicioTiempo = System.nanoTime();

		resultadoMatriz = metodo.multiply(a, b, (int) Math.sqrt(a.length));

		long finTiempo = System.nanoTime(); // .nanoTime() .currentTimeMillis()
		long tiempo = finTiempo - inicioTiempo;

		Object[] respuesta = { tiempo, resultadoMatriz };

		return respuesta;
	}
	
	public Object[] capturaSequentialBlockThreeFour(double[][] a, double[][] b) {

		SequentialBlockThreeFour metodo = new SequentialBlockThreeFour();

		double[][] resultadoMatriz;

		long inicioTiempo = System.nanoTime();

		resultadoMatriz = metodo.multiply(a, b, (int) Math.sqrt(a.length));

		long finTiempo = System.nanoTime(); // .nanoTime() .currentTimeMillis()
		long tiempo = finTiempo - inicioTiempo;

		Object[] respuesta = { tiempo, resultadoMatriz };

		return respuesta;
	}
	
	public Object[] capturaSequentialBlockThreeFive(double[][] a, double[][] b) {

		SequentialBlockThreeFive metodo = new SequentialBlockThreeFive();

		double[][] resultadoMatriz;

		long inicioTiempo = System.nanoTime();

		resultadoMatriz = metodo.multiply(a, b, (int) Math.sqrt(a.length));

		long finTiempo = System.nanoTime(); // .nanoTime() .currentTimeMillis()
		long tiempo = finTiempo - inicioTiempo;

		Object[] respuesta = { tiempo, resultadoMatriz };

		return respuesta;
	}
	
	public Object[] capturaParallelBlockFourThree(double[][] a, double[][] b) {

		ParallelBlockFourThree metodo = new ParallelBlockFourThree();

		double[][] resultadoMatriz;

		long inicioTiempo = System.nanoTime();

		resultadoMatriz = metodo.multiply(a, b, (int) Math.sqrt(a.length));

		long finTiempo = System.nanoTime(); // .nanoTime() .currentTimeMillis()
		long tiempo = finTiempo - inicioTiempo;

		Object[] respuesta = { tiempo, resultadoMatriz };

		return respuesta;
	}
	
	public Object[] capturaParallelBlockFourFour(double[][] a, double[][] b) {

		ParallelBlockFourFour metodo = new ParallelBlockFourFour();

		double[][] resultadoMatriz;

		long inicioTiempo = System.nanoTime();

		resultadoMatriz = metodo.multiply(a, b, (int) Math.sqrt(a.length));

		long finTiempo = System.nanoTime(); // .nanoTime() .currentTimeMillis()
		long tiempo = finTiempo - inicioTiempo;

		Object[] respuesta = { tiempo, resultadoMatriz };

		return respuesta;
	}
	
	public Object[] capturaParallelBlockFourFive(double[][] a, double[][] b) {

		ParallelBlockFourFive metodo = new ParallelBlockFourFive();

		double[][] resultadoMatriz;

		long inicioTiempo = System.nanoTime();

		resultadoMatriz = metodo.multiply(a, b, (int) Math.sqrt(a.length));

		long finTiempo = System.nanoTime(); // .nanoTime() .currentTimeMillis()
		long tiempo = finTiempo - inicioTiempo;

		Object[] respuesta = { tiempo, resultadoMatriz };

		return respuesta;
	}
}
