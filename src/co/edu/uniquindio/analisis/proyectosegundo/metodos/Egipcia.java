package co.edu.uniquindio.analisis.proyectosegundo.metodos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Egipcia {

	public static int[] multiplyEgipcian(int[] arr1, int[] arr2) {
	    int m = arr1.length;
	    int n = arr2.length;
	    int[] result = new int[m + n];

	    for (int i = m - 1; i >= 0; i--) {
	        int carry = 0;

	        for (int j = n - 1; j >= 0; j--) {
	            int product = arr1[i] * arr2[j] + carry + result[i + j + 1];
	            carry = product / 10;
	            result[i + j + 1] = product % 10;
	        }

	        result[i] += carry;
	    }

	    return result;
	}
}
