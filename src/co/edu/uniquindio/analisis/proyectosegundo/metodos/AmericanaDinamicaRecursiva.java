package co.edu.uniquindio.analisis.proyectosegundo.metodos;

import java.util.ArrayList;

public class AmericanaDinamicaRecursiva {

	public ArrayList<Integer> multiplicacionAmericana(ArrayList<Integer> arreglo1, ArrayList<Integer> arreglo2) {
	    int n = arreglo1.size();
	    int m = arreglo2.size();

	    int[] resultado = new int[n + m];
	    multiplicacionAmericanaRecursiva(arreglo1, arreglo2, resultado, n - 1, m - 1);

	    ArrayList<Integer> resultadoArrayList = new ArrayList<>();
	    for (int digit : resultado) {
	        resultadoArrayList.add(digit);
	    }

	    return resultadoArrayList;
	}

	public void multiplicacionAmericanaRecursiva(ArrayList<Integer> arreglo1, ArrayList<Integer> arreglo2, int[] resultado, int i, int j) {
	    if (i < 0 || j < 0) {
	        return;
	    }

	    resultado[i + j + 1] += arreglo1.get(i) * arreglo2.get(j);
	    resultado[i + j] += resultado[i + j + 1] / 10;
	    resultado[i + j + 1] %= 10;

	    if (j == 0) {
	        multiplicacionAmericanaRecursiva(arreglo1, arreglo2, resultado, i - 1, arreglo2.size() - 1);
	    } else {
	        multiplicacionAmericanaRecursiva(arreglo1, arreglo2, resultado, i, j - 1);
	    }
	}
}
