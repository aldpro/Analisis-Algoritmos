package co.edu.uniquindio.analisis.proyectosegundo.metodos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class AmericanaDinamicaIterativa {

	public ArrayList<Integer> multiplicacionAmericana(ArrayList<Integer> arreglo1, ArrayList<Integer> arreglo2) {
	    // Obtiene el tamaño de los dos arreglos de entrada
	    int n = arreglo1.size();
	    int m = arreglo2.size();
	    // Crea un ArrayList resultado con una longitud igual a la suma de las longitudes de los dos ArrayList de entrada
	    ArrayList<Integer> resultado = new ArrayList<>(Collections.nCopies(n + m, 0));

	    // Recorre el primer ArrayList en orden inverso
	    for (int i = n - 1; i >= 0; i--) {
	        // Recorre el segundo ArrayList en orden inverso
	        for (int j = m - 1; j >= 0; j--) {
	            // Realiza la multiplicación de los elementos correspondientes
	            int product = arreglo1.get(i) * arreglo2.get(j);
	            // Suma el producto al elemento correspondiente en el ArrayList resultado
	            resultado.set(i + j + 1, resultado.get(i + j + 1) + product);
	            // Si el resultado de la multiplicación es mayor o igual a 10, lleva el excedente al elemento anterior del ArrayList resultado
	            resultado.set(i + j, resultado.get(i + j) + resultado.get(i + j + 1) / 10);
	            // Guarda el resultado de la multiplicación en el elemento correspondiente del ArrayList resultado
	            resultado.set(i + j + 1, resultado.get(i + j + 1) % 10);
	        }
	    }

	    // Elimina los ceros iniciales si los hay
	    while (!resultado.isEmpty() && resultado.get(0) == 0) {
	        resultado.remove(0);
	    }

	    // Devuelve el ArrayList resultado
	    return resultado;
	}


}
