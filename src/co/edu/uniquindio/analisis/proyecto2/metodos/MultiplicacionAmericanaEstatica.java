package co.edu.uniquindio.analisis.proyecto2.metodos;

public class MultiplicacionAmericanaEstatica {


    //Metodo a la americana estatico
    public static int[] multiplicacionAmericana(int[] arreglo1, int[] arreglo2) {
        int[] resultado = new int[arreglo1.length + arreglo2.length];

        for (int i = arreglo1.length - 1; i >= 0; i--) {
            for (int j = arreglo2.length - 1; j >= 0; j--) {
                resultado[i + j + 1] += arreglo1[i] * arreglo2[j];
                resultado[i + j] += resultado[i + j + 1] / 10;
                resultado[i + j + 1] %= 10;
            }
        }

        return resultado;
    }
}
