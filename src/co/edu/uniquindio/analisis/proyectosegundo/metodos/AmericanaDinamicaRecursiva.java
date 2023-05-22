package co.edu.uniquindio.analisis.proyectosegundo.metodos;

import java.util.ArrayList;

public class AmericanaDinamicaRecursiva {

	public ArrayList<Integer> multiplicacionAmericana(ArrayList<Integer> arreglo1, ArrayList<Integer> arreglo2) {
	    // Obtiene el tamaño de los dos ArrayList de entrada
	    int n = arreglo1.size();
	    int m = arreglo2.size();

	    // Crea un arreglo resultado con una longitud igual a la suma de las longitudes de los dos ArrayList de entrada
	    int[] resultado = new int[n + m];
	    // Llama a la función recursiva para realizar la multiplicación americana
	    multiplicacionAmericanaRecursiva(arreglo1, arreglo2, resultado, n - 1, m - 1);

	    // Convierte el arreglo resultado a un ArrayList
	    ArrayList<Integer> resultadoArrayList = new ArrayList<>();
	    for (int digit : resultado) {
	        resultadoArrayList.add(digit);
	    }

	    // Devuelve el ArrayList resultado
	    return resultadoArrayList;
	}

	public void multiplicacionAmericanaRecursiva(ArrayList<Integer> arreglo1, ArrayList<Integer> arreglo2, int[] resultado, int i, int j) {
	    // Caso base: si alguno de los índices es menor que 0, termina la recursión
	    if (i < 0 || j < 0) {
	        return;
	    }

	    // Realiza la multiplicación de los elementos correspondientes y suma al elemento correspondiente en el arreglo resultado
	    resultado[i + j + 1] += arreglo1.get(i) * arreglo2.get(j);
	    // Si el resultado de la multiplicación es mayor o igual a 10, lleva el excedente al elemento anterior del arreglo resultado
	    resultado[i + j] += resultado[i + j + 1] / 10;
	    // Guarda el resultado de la multiplicación en el elemento correspondiente del arreglo resultado
	    resultado[i + j + 1] %= 10;

	    // Llama a la función recursiva para el siguiente elemento
	    if (j == 0) {
	        multiplicacionAmericanaRecursiva(arreglo1, arreglo2, resultado, i - 1, arreglo2.size() - 1);
	    } else {
	        multiplicacionAmericanaRecursiva(arreglo1, arreglo2, resultado, i, j - 1);
	    }
	}

}
