package co.edu.uniquindio.analisis.proyectosegundo.metodos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class AmericanaDinamicaIterativa {

	public ArrayList<Integer> multiplicacionAmericana(ArrayList<Integer> arreglo1, ArrayList<Integer> arreglo2) {
	    int n = arreglo1.size();
	    int m = arreglo2.size();
	    ArrayList<Integer> resultado = new ArrayList<>(Collections.nCopies(n + m, 0));

	    for (int i = n - 1; i >= 0; i--) {
	        for (int j = m - 1; j >= 0; j--) {
	            int product = arreglo1.get(i) * arreglo2.get(j);
	            resultado.set(i + j + 1, resultado.get(i + j + 1) + product);
	            resultado.set(i + j, resultado.get(i + j) + resultado.get(i + j + 1) / 10);
	            resultado.set(i + j + 1, resultado.get(i + j + 1) % 10);
	        }
	    }

	    while (!resultado.isEmpty() && resultado.get(0) == 0) {
	        resultado.remove(0);
	    }

	    return resultado;
	}

}
