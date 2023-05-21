package co.edu.uniquindio.analisis.proyectosegundo;

import java.util.Arrays;
import java.util.HashMap;

import co.edu.uniquindio.analisis.proyectosegundo.metodos.AmericanaDinamicaIterativa;
import co.edu.uniquindio.analisis.proyectosegundo.metodos.AmericanaDinamicaRecursiva;
import co.edu.uniquindio.analisis.proyectosegundo.metodos.AmericanaEstaticaIterativa;
import co.edu.uniquindio.analisis.proyectosegundo.metodos.AmericanaEstaticaRecursiva;
import co.edu.uniquindio.analisis.proyectosegundo.metodos.InglesaDinamicaIterativa;
import co.edu.uniquindio.analisis.proyectosegundo.metodos.InglesaDinamicaRecursiva;
import co.edu.uniquindio.analisis.proyectosegundo.metodos.InglesaEstaticaIterativa;
import co.edu.uniquindio.analisis.proyectosegundo.metodos.InglesaEstaticaRecursiva;
import co.edu.uniquindio.analisis.proyectosegundo.metodos.Rusa;
import co.edu.uniquindio.analisis.proyectosegundo.metodos.Hindu;
import co.edu.uniquindio.analisis.proyectosegundo.metodos.Egipcia;
import co.edu.uniquindio.analisis.proyectosegundo.metodos.Karatsuba;
import co.edu.uniquindio.analisis.proyectosegundo.metodos.DivideVencerasI;
import co.edu.uniquindio.analisis.proyectosegundo.metodos.DivideVencerasII;

public class Captura {

	public Object[] consultaMetodo(int[] arregloa, int[] arreglob, int metodo) {
		Object[] ejecucion = null;
		
		switch (metodo) {
		case 1:
			ejecucion = capturaAmericanoIterativoEstatico(arregloa, arreglob);
			break;
		case 2:
			ejecucion = capturaAmericanoIterativoDinamico(arregloa, arreglob);
			break;
		case 3:
			ejecucion = capturaAmericanoRecursivoEstatico(arregloa, arreglob);
			break;
		case 4:
			ejecucion = capturaAmericanoIterativoDinamico(arregloa, arreglob);
//			ejecucion = capturaAmericanoRecursivoDinamico(arregloa, arreglob);
			break;
		case 5:
			ejecucion = capturaInglesaIterativoEstatico(arregloa, arreglob);
			break;
		case 6:
			  ejecucion = capturaInglesaIterativoDinamico(arregloa, arreglob);
			break;
		case 7:
			  ejecucion = capturaInglesaRecursivoEstatico(arregloa, arreglob);
			break;
		case 8:
			  ejecucion = capturaInglesaRecursivoDinamico(arregloa, arreglob);
			break;
		case 9:
			  ejecucion = capturaHindu(arregloa, arreglob); //Modificar por el algoritmo: Cadena
			break;
		case 10:
			  ejecucion = capturaHindu(arregloa, arreglob);
			break;
		case 11:
			  ejecucion = capturaEgipcia(arregloa, arreglob);
			break;
		case 12:
			  ejecucion = capturaKaratsuba(arregloa, arreglob);
			break;
		case 13:
			  ejecucion = capturaDivideVencerasI(arregloa, arreglob); //Modificar por el algoritmo: Cadena
			break;
		case 14:
			  ejecucion = capturaDivideVencerasI(arregloa, arreglob);
			break;
		case 15:
			  ejecucion = capturaDivideVencerasII(arregloa, arreglob);
			break;
		default:
			ejecucion = null;
			break;
		}

		return ejecucion;
	}
	
	public Object[] capturaAmericanoIterativoEstatico(int[] a, int[] b) {

		AmericanaEstaticaIterativa metodo = new AmericanaEstaticaIterativa();
		
		int[] resultado;
		
		long inicioTiempo = System.nanoTime();

		resultado = metodo.multiplicacionAmericana(a, b);

		long finTiempo = System.nanoTime(); // .nanoTime() .currentTimeMillis()
		long tiempo = finTiempo - inicioTiempo;

		Object[] respuesta = { tiempo, resultado };

		return respuesta;
	}
	
	public Object[] capturaAmericanoIterativoDinamico(int[] a, int[] b) {

		AmericanaDinamicaIterativa metodo = new AmericanaDinamicaIterativa();
		
		int[] resultado;
		
		long inicioTiempo = System.nanoTime();

		resultado = metodo.multiplicacionAmericana(a, b);

		long finTiempo = System.nanoTime(); // .nanoTime() .currentTimeMillis()
		long tiempo = finTiempo - inicioTiempo;

		Object[] respuesta = { tiempo, resultado };

		return respuesta;
	}
	
	public Object[] capturaAmericanoRecursivoEstatico(int[] a, int[] b) {

		AmericanaEstaticaRecursiva metodo = new AmericanaEstaticaRecursiva();
		
		int[] resultado;
		
		long inicioTiempo = System.nanoTime();

		resultado = metodo.multiplicacionAmericanaRecursiva(a, b);

		long finTiempo = System.nanoTime(); // .nanoTime() .currentTimeMillis()
		long tiempo = finTiempo - inicioTiempo;

		Object[] respuesta = { tiempo, resultado };

		return respuesta;
	}
	
	public Object[] capturaAmericanoRecursivoDinamico(int[] a, int[] b) {

		AmericanaDinamicaRecursiva metodo = new AmericanaDinamicaRecursiva();
		
		int[] resultado;
		
		long inicioTiempo = System.nanoTime();

		resultado = metodo.multiplicacionAmericana(a, b);

		long finTiempo = System.nanoTime(); // .nanoTime() .currentTimeMillis()
		long tiempo = finTiempo - inicioTiempo;

		Object[] respuesta = { tiempo, resultado };

		return respuesta;
	}
	
	public Object[] capturaInglesaIterativoEstatico(int[] a, int[] b) {

		InglesaEstaticaIterativa metodo = new InglesaEstaticaIterativa();
		
		int[] resultado;
		
		long inicioTiempo = System.nanoTime();

		resultado = metodo.multiplicaInglesa(a, b);

		long finTiempo = System.nanoTime(); // .nanoTime() .currentTimeMillis()
		long tiempo = finTiempo - inicioTiempo;

		Object[] respuesta = { tiempo, resultado };

		return respuesta;
	}
	
	public Object[] capturaInglesaIterativoDinamico(int[] a, int[] b) {

		InglesaDinamicaIterativa metodo = new InglesaDinamicaIterativa();
		
		int[] resultado;
		
		long inicioTiempo = System.nanoTime();

		resultado = metodo.multiplicaInglesa(a, b);

		long finTiempo = System.nanoTime(); // .nanoTime() .currentTimeMillis()
		long tiempo = finTiempo - inicioTiempo;

		Object[] respuesta = { tiempo, resultado };

		return respuesta;
	}
	
	public Object[] capturaInglesaRecursivoEstatico(int[] a, int[] b) {

		InglesaEstaticaRecursiva metodo = new InglesaEstaticaRecursiva();
		
		int[] resultado;
		
		long inicioTiempo = System.nanoTime();

		resultado = metodo.multiplicaInglesa(a, b);

		long finTiempo = System.nanoTime(); // .nanoTime() .currentTimeMillis()
		long tiempo = finTiempo - inicioTiempo;

		Object[] respuesta = { tiempo, resultado };

		return respuesta;
	}
	
	public Object[] capturaInglesaRecursivoDinamico(int[] a, int[] b) {

		InglesaDinamicaRecursiva metodo = new InglesaDinamicaRecursiva();
		
		int[] resultado;
		
		long inicioTiempo = System.nanoTime();

		resultado = metodo.multiplicaInglesaRecursiva(a, b);

		long finTiempo = System.nanoTime(); // .nanoTime() .currentTimeMillis()
		long tiempo = finTiempo - inicioTiempo;

		Object[] respuesta = { tiempo, resultado };

		return respuesta;
	}
	
	public Object[] capturaRusa(int[] a, int[] b) {

		Rusa metodo = new Rusa();
		
		int[] resultado;
		
		long inicioTiempo = System.nanoTime();

		resultado = metodo(a, b);

		long finTiempo = System.nanoTime(); // .nanoTime() .currentTimeMillis()
		long tiempo = finTiempo - inicioTiempo;

		Object[] respuesta = { tiempo, resultado };

		return respuesta;
	}
	
	public Object[] capturaHindu(int[] a, int[] b) {

		Hindu metodo = new Hindu();
		
		int n = a.length;
		
		int[] resultado = new int[n];
		
		long inicioTiempo = System.nanoTime();

		metodo.multiplicarHindu(a, b, resultado);

		long finTiempo = System.nanoTime(); // .nanoTime() .currentTimeMillis()
		long tiempo = finTiempo - inicioTiempo;

		Object[] respuesta = { tiempo, resultado };

		return respuesta;
	}
	
	public Object[] capturaEgipcia(int[] a, int[] b) {

		Egipcia metodo = new Egipcia();
		
		int[] resultado;
		
		long inicioTiempo = System.nanoTime();

		resultado = metodo.egipcio(a, b);

		long finTiempo = System.nanoTime(); // .nanoTime() .currentTimeMillis()
		long tiempo = finTiempo - inicioTiempo;

		Object[] respuesta = { tiempo, resultado };

		return respuesta;
	}
	
	public Object[] capturaKaratsuba(int[] a, int[] b) {

		Karatsuba metodo = new Karatsuba();
		
		int[] resultado;
		
		long inicioTiempo = System.nanoTime();

		resultado = metodo.karatsuba(a, b);

		long finTiempo = System.nanoTime(); // .nanoTime() .currentTimeMillis()
		long tiempo = finTiempo - inicioTiempo;

		Object[] respuesta = { tiempo, resultado };

		return respuesta;
	}
	
	/**
	 * Representado con Cadenas [falta]
	 */
	
	public Object[] capturaDivideVencerasI(int[] a, int[] b) {

		DivideVencerasI metodo = new DivideVencerasI();
		
		int[] resultado;
		
		long inicioTiempo = System.nanoTime();

		resultado = metodo.multiplicar(a, b);

		long finTiempo = System.nanoTime(); // .nanoTime() .currentTimeMillis()
		long tiempo = finTiempo - inicioTiempo;

		Object[] respuesta = { tiempo, resultado };

		return respuesta;
	}
	
	public Object[] capturaDivideVencerasII(int[] a, int[] b) {

		DivideVencerasII metodo = new DivideVencerasII();
		
		int[] resultado;
		
		long inicioTiempo = System.nanoTime();

		resultado = metodo.multiplicar(a, b);

		long finTiempo = System.nanoTime(); // .nanoTime() .currentTimeMillis()
		long tiempo = finTiempo - inicioTiempo;

		Object[] respuesta = { tiempo, resultado };

		return respuesta;
	}
	
}
