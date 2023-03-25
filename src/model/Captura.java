package model;

import java.util.Arrays;

public class Captura {

	Multiplicacion metodos = new Multiplicacion();

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
