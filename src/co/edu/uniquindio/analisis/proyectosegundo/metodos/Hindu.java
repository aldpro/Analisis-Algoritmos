package co.edu.uniquindio.analisis.proyectosegundo.metodos;

import java.util.Arrays;

public class Hindu {

	public int[] multiplicacionHindu(int[] num1, int[] num2) {
	    int[] resultado = new int[num1.length + num2.length];
	    int carry = 0;
	    int index = resultado.length - 1;

	    for (int i = num2.length - 1; i >= 0; i--) {
	        int num = num2[i];
	        int tempIndex = index--;

	        for (int j = num1.length - 1; j >= 0; j--) {
	            int producto = num1[j] * num + carry + resultado[tempIndex];
	            resultado[tempIndex--] = producto % 10;
	            carry = producto / 10;
	        }

	        while (carry > 0) {
	            int producto = carry + resultado[tempIndex];
	            resultado[tempIndex--] = producto % 10;
	            carry = producto / 10;
	        }
	    }

	    // Eliminar ceros a la izquierda del resultado
	    int i = 0;
	    while (i < resultado.length - 1 && resultado[i] == 0) {
	        i++;
	    }

	    return Arrays.copyOfRange(resultado, i, resultado.length);
	}


}
