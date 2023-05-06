package co.edu.uniquindio.analisis.proyecto2.metodos;

public class MultiplicacionEgipcia {

    public static int[] egipcio(int[] arreglo1, int[] arreglo2) {

        // Calcular el tamaño del resultado
        int resultadoTamano = arreglo1.length + arreglo2.length - 1;

        // Inicializar el arreglo de resultado
        int[] resultado = new int[resultadoTamano];

        // Llamada recursiva al método egipcioAux
        egipcioAux(arreglo1, arreglo2, resultado, 0, 0);

        return resultado;
    }

    // Método auxiliar recursivo para el algoritmo egipcio
    private static void egipcioAux(int[] arreglo1, int[] arreglo2, int[] resultado, int i, int j) {

        // Caso base
        if (i >= arreglo1.length || j >= arreglo2.length) {
            return;
        }

        // Realizar la multiplicación y sumar al resultado parcial
        resultado[i + j] += arreglo1[i] * arreglo2[j];

        // Llamar recursivamente a egipcioAux con los nuevos valores de i y j
        egipcioAux(arreglo1, arreglo2, resultado, i + 1, j);
        egipcioAux(arreglo1, arreglo2, resultado, i, j + 1);
    }

}
