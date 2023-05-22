package co.edu.uniquindio.analisis.proyectosegundo.metodos;

import java.util.ArrayList;
import java.util.List;

public class InglesaDinamicaIterativa {

	public ArrayList<Integer> multiplicaInglesa(ArrayList<Integer> arreglo1, ArrayList<Integer> arreglo2) {
		int tam = arreglo1.size() + arreglo2.size();
		int[] resultado = new int[tam];

		for (int i = 0; i < arreglo2.size(); i++) {
			for (int j = 0; j < arreglo1.size(); j++) {
				resultado[i + j + 1] += arreglo1.get(j) * arreglo2.get(i);
			}
		}

		for (int k = tam - 1; k > 0; k--) {
			resultado[k - 1] += resultado[k] / 10;
			resultado[k] %= 10;
		}

		ArrayList<Integer> resultadoArrayList = new ArrayList<>();
		for (int digit : resultado) {
			resultadoArrayList.add(digit);
		}

		return resultadoArrayList;
	}
}
