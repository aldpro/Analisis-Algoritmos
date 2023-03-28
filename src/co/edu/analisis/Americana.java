package co.edu.analisis;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Americana {

	public static void main(String[] args) {
		// TODO Auto-generated method stub


		ArrayList<Integer> a = new ArrayList<>();
		a.addAll(Arrays.asList(3, 9, 8, 5, 6, 0));

		ArrayList<Integer> b = new ArrayList<>();
		b.addAll(Arrays.asList(8, 9, 2, 7, 0, 5));

		ArrayList<Integer> c = americano(a, b);

//		ArrayList<Integer> z = multiplicar(a, b);
		
		String resultadoString = "";
		for (int i = c.size() - 1; i >= 0; i--) {
		    resultadoString += c.get(i).toString();
		}

		System.out.println(resultadoString);

//		String resultadoString2 = "";
//		for (int i = z.size() - 1; i >= 0; i--) {
//		    resultadoString2 += c.get(i).toString();
//		}
//		
//		System.out.println(resultadoString2);
		
	}
	
	public static int[] americano(int arreglo1[], int arreglo2[])
	{
		int k = arreglo1.length + arreglo2.length - 1;
		int pos = arreglo1.length + arreglo2.length - 1;
		int resultado[] = new int[arreglo1.length + arreglo2.length];
		for (int i = arreglo1.length - 1; i >= 0; i--) {
			for (int j = arreglo2.length - 1; j >= 0; j--) {
				resultado[k] = resultado[k] + arreglo1[i] * arreglo2[j];
				if (resultado[k] > 9) {
					resultado[k - 1] += resultado[k] / 10;
					resultado[k] = resultado[k] % 10;
				}
				k--;
			}
			k = pos;
			pos--;
			k--;
		}
		return resultado;
	}
	
	public static ArrayList<Integer> multiplicar(ArrayList<Integer> num1, ArrayList<Integer> num2) {
	    int n1 = num1.size(), n2 = num2.size();
	    ArrayList<Integer> productosParciales = new ArrayList<>(Collections.nCopies(n2, 0));
	    ArrayList<Integer> resultado = new ArrayList<>(Collections.nCopies(n1 + n2, 0));

	    // calcular los productos parciales y almacenarlos en la lista
	    for (int i = 0; i < n2; i++) {
	        int acarreo = 0;
	        for (int j = 0; j < n1; j++) {
	            int producto = num1.get(n1 - 1 - j) * num2.get(n2 - 1 - i) + acarreo;
	            acarreo = producto / 10;
	            if (productosParciales.get(i + j) != null) {
	                producto += productosParciales.get(i + j);
	                acarreo += producto / 10;
	            }
	            productosParciales.set(i + j, producto % 10);
	        }
	        if (acarreo != 0) {
	            productosParciales.add(i + n1, acarreo);
	        }
	    }

	    // sumar los productos parciales para obtener el resultado final
	    int acarreo = 0;
	    for (int i = 0; i < resultado.size(); i++) {
	        int suma = acarreo;
	        for (int j = 0; j < n2 && j <= i; j++) {
	            if (i - j < n1) {
	                suma += num1.get(n1 - 1 - (i - j)) * num2.get(n2 - 1 - j);
	            }
	        }
	        resultado.set(resultado.size() - 1 - i, suma % 10);
	        acarreo = suma / 10;
	    }

	    // quitar los ceros a la izquierda del resultado
	    while (resultado.size() > 1 && resultado.get(resultado.size() - 1) == 0) {
	        resultado.remove(resultado.size() - 1);
	    }

	    // invertir el resultado para que el dígito más significativo esté al principio
	    Collections.reverse(resultado);

	    return resultado;
	}


	public static ArrayList<Integer> americano(ArrayList<Integer> arreglo1, ArrayList<Integer> arreglo2) {
	    int k = arreglo1.size() + arreglo2.size() - 1;
	    int pos = arreglo1.size() + arreglo2.size() - 1;
	    ArrayList<Integer> resultado = new ArrayList<>(Collections.nCopies(arreglo1.size() + arreglo2.size(), 0));
	    for (int i = arreglo1.size() - 1; i >= 0; i--) {
	        for (int j = arreglo2.size() - 1; j >= 0; j--) {
	            resultado.set(k, resultado.get(k) + arreglo1.get(i) * arreglo2.get(j));
	            if (resultado.get(k) > 9) {
	                resultado.set(k - 1, resultado.get(k - 1) + resultado.get(k) / 10);
	                resultado.set(k, resultado.get(k) % 10);
	            }
	            k--;
	        }
	        k = pos;
	        pos--;
	        k--;
	    }
	    // quitar los ceros a la izquierda del resultado
	    while (resultado.size() > 1 && resultado.get(resultado.size() - 1) == 0) {
	        resultado.remove(resultado.size() - 1);
	    }
	    // invertir el resultado para que el dígito más significativo esté al principio
	    Collections.reverse(resultado);
	    return resultado;
	}
}
