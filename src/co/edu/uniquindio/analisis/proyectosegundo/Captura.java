package co.edu.uniquindio.analisis.proyectosegundo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import co.edu.uniquindio.analisis.proyectosegundo.metodos.AmericanaDinamicaIterativa;
import co.edu.uniquindio.analisis.proyectosegundo.metodos.AmericanaDinamicaRecursiva;
import co.edu.uniquindio.analisis.proyectosegundo.metodos.AmericanaEstaticaIterativa;
import co.edu.uniquindio.analisis.proyectosegundo.metodos.AmericanaEstaticaRecursiva;
import co.edu.uniquindio.analisis.proyectosegundo.metodos.Cadena;
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

	public Object[] consultaMetodo(int[] arregloa, int[] arreglob, ArrayList<Integer> dinamicoa, ArrayList<Integer> dinamicob, int metodo) {
		Object[] ejecucion = null; 
		
		switch (metodo) {
		case 1:
			ejecucion = capturaAmericanoIterativoEstatico(arregloa, arreglob);
			break;
		case 2:
			ejecucion = capturaAmericanoIterativoDinamico(dinamicoa, dinamicob);
			break;
		case 3:
			ejecucion = capturaAmericanoRecursivoEstatico(arregloa, arreglob);
			break;
		case 4:
			ejecucion = capturaAmericanoRecursivoDinamico(dinamicoa, dinamicob);
			break;
		case 5:
			ejecucion = capturaInglesaIterativoEstatico(arregloa, arreglob);
			break;
		case 6:
			  ejecucion = capturaInglesaIterativoDinamico(dinamicoa, dinamicob);
			break;
		case 7:
			  ejecucion = capturaInglesaRecursivoEstatico(arregloa, arreglob);
			break;
		case 8:
			  ejecucion = capturaInglesaRecursivoDinamico(dinamicoa, dinamicob);
			break;
		case 9:
			  ejecucion = capturaRusa(arregloa, arreglob);
			break;
		case 10:
			  ejecucion = capturaHindu(arregloa, arreglob);
			break;
		case 11:
			  ejecucion = capturaEgipcia(arregloa, arreglob);//X
			break;
		case 12:
			  ejecucion = capturaKaratsuba(arregloa, arreglob);
			break;
		case 13:
			  ejecucion = capturaCadena(arregloa, arreglob); //Sirvio a la primera
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
	
	public Object[] capturaAmericanoIterativoDinamico(ArrayList<Integer> a, ArrayList<Integer> b) {

		AmericanaDinamicaIterativa metodo = new AmericanaDinamicaIterativa();
		
		ArrayList<Integer> resultado;
		
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

		resultado = metodo.multiplicacionAmericana(a, b);

		long finTiempo = System.nanoTime(); // .nanoTime() .currentTimeMillis()
		long tiempo = finTiempo - inicioTiempo;

		Object[] respuesta = { tiempo, resultado };

		return respuesta;
	}
	
	public Object[] capturaAmericanoRecursivoDinamico(ArrayList<Integer> a, ArrayList<Integer> b) {

		AmericanaDinamicaRecursiva metodo = new AmericanaDinamicaRecursiva();
		
		ArrayList<Integer> resultado;
		
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
	
	public Object[] capturaInglesaIterativoDinamico(ArrayList<Integer> a, ArrayList<Integer> b) {

		InglesaDinamicaIterativa metodo = new InglesaDinamicaIterativa();
		
		ArrayList<Integer> resultado;
		
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
	
	public Object[] capturaInglesaRecursivoDinamico(ArrayList<Integer> a, ArrayList<Integer> b) {

		InglesaDinamicaRecursiva metodo = new InglesaDinamicaRecursiva();
		
		ArrayList<Integer> resultado;
		
		long inicioTiempo = System.nanoTime();

		resultado = metodo.multiplicaInglesa(a, b);

		long finTiempo = System.nanoTime(); // .nanoTime() .currentTimeMillis()
		long tiempo = finTiempo - inicioTiempo;

		Object[] respuesta = { tiempo, resultado };

		return respuesta;
	}
	
	public Object[] capturaRusa(int[] a, int[] b) {

		Rusa metodo = new Rusa();
		
		int[] resultado;
		
		long inicioTiempo = System.nanoTime();

		resultado = metodo.multiplicar(a, b);

		long finTiempo = System.nanoTime(); // .nanoTime() .currentTimeMillis()
		long tiempo = finTiempo - inicioTiempo;

		Object[] respuesta = { tiempo, resultado };

		return respuesta;
	}
	
	public Object[] capturaHindu(int[] a, int[] b) {

		Hindu metodo = new Hindu();
		
		int[] resultado;
		
		long inicioTiempo = System.nanoTime();

		resultado = metodo.multiplicacionHindu(a, b);

		long finTiempo = System.nanoTime(); // .nanoTime() .currentTimeMillis()
		long tiempo = finTiempo - inicioTiempo;

		Object[] respuesta = { tiempo, resultado };

		return respuesta;
	}
	
	public Object[] capturaEgipcia(int[] a, int[] b) {

		Egipcia metodo = new Egipcia();
		
		int[] resultado;
		
		long inicioTiempo = System.nanoTime();

		resultado = metodo.multiplyEgipcian(a, b);

		long finTiempo = System.nanoTime(); // .nanoTime() .currentTimeMillis()
		long tiempo = finTiempo - inicioTiempo;

		Object[] respuesta = { tiempo, resultado };

		return respuesta;
	}
	
	public Object[] capturaKaratsuba(int[] a, int[] b) {

		Karatsuba metodo = new Karatsuba();
		
		int[] resultado;
		
		long inicioTiempo = System.nanoTime();

		resultado = metodo.Multiplication(a, b);

		long finTiempo = System.nanoTime(); // .nanoTime() .currentTimeMillis()
		long tiempo = finTiempo - inicioTiempo;

		Object[] respuesta = { tiempo, resultado };

		return respuesta;
	}
	
	public Object[] capturaCadena(int[] a, int[] b) {

		Cadena metodo = new Cadena();
		
		int[] resultado;
		
		long inicioTiempo = System.nanoTime();

		resultado = metodo.multiply(a, b);

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
		
		int tamanio = a.length;
		
		int[] resultado;
		
		long inicioTiempo = System.nanoTime();

		resultado = metodo.MultiplicacionDivideYVenceras1(a, b);

		long finTiempo = System.nanoTime(); // .nanoTime() .currentTimeMillis()
		long tiempo = finTiempo - inicioTiempo;

		Object[] respuesta = { tiempo, resultado };

		return respuesta;
	}
	
	public Object[] capturaDivideVencerasII(int[] a, int[] b) {

		DivideVencerasII metodo = new DivideVencerasII();
		
		int[] resultado;
		
		long inicioTiempo = System.nanoTime();

		resultado = metodo.divideVenceras(a, b);

		long finTiempo = System.nanoTime(); // .nanoTime() .currentTimeMillis()
		long tiempo = finTiempo - inicioTiempo;

		Object[] respuesta = { tiempo, resultado };

		return respuesta;
	}
	
}
