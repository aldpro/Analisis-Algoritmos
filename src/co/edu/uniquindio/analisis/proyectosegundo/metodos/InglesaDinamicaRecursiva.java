package co.edu.uniquindio.analisis.proyectosegundo.metodos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class InglesaDinamicaRecursiva {

	public ArrayList<Integer> multiplicaInglesaRecursiva(ArrayList<Integer> arreglo1, ArrayList<Integer> arreglo2,
			int pos, ArrayList<Integer> resultado) {
		if (pos == arreglo2.size()) {
			return resultado;
		}
		for (int i = 0; i < arreglo1.size(); i++) {
			resultado.set(i + pos + 1, resultado.get(i + pos + 1) + arreglo1.get(i) * arreglo2.get(pos));
		}
		for (int k = resultado.size() - 1; k > 0; k--) {
			resultado.set(k - 1, resultado.get(k - 1) + resultado.get(k) / 10);
			resultado.set(k, resultado.get(k) % 10);
		}
		return multiplicaInglesaRecursiva(arreglo1, arreglo2, pos + 1, resultado);
	}

	public ArrayList<Integer> multiplicaInglesa(ArrayList<Integer> arreglo1, ArrayList<Integer> arreglo2) {
		
		int tam = arreglo1.size() + arreglo2.size();
		
		ArrayList<Integer> resultado = new ArrayList<Integer>(Collections.nCopies(tam, 0));
		
		return multiplicaInglesaRecursiva(arreglo1, arreglo2, 0, resultado);
	}

}
