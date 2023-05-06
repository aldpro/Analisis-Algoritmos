package co.edu.uniquindio.analisis.proyecto2.metodos;

public class MultiplicacionAmericanaDinamica {

    //Metodo a la americana Dinamico
    private int[] datos;

    public Arreglo(int[] datos) {
        this.datos = datos;
    }

    public int[] multiplicacionAmericana(MultiplicacionAmericanaDinamica otro) {
        int[] arreglo1 = this.datos;
        int[] arreglo2 = otro.datos;
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

