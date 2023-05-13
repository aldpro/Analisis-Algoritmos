package co.edu.uniquindio.analisis.proyecto2.metodos;

import java.util.ArrayList;
import java.util.List;

public class MultiplicacionInglesaDinamica {
    //Metodo dinamico a la inglesa
    public class Arreglo {

        public int[] multiplicaInglesa(int[] arreglo1, int[] arreglo2) {
            List<Integer> temp = new ArrayList<>();
            int acarreo = 0;

            for (int i = arreglo2.length - 1; i >= 0; i--) {
                for (int j = arreglo1.length - 1; j >= 0; j--) {
                    int pos = arreglo1.length + arreglo2.length - 2 - i - j;
                    if (pos >= temp.size()) {
                        temp.add(0);
                    }
                    temp.set(pos, temp.get(pos) + arreglo2[i] * arreglo1[j]);
                }
            }

            int[] resultado = new int[temp.size()];

            for (int i = temp.size() - 1; i >= 0; i--) {
                int val = temp.get(i) + acarreo;
                acarreo = val / 10;
                resultado[i] = val % 10;
            }

            if (acarreo > 0) {
                int[] resultadoFinal = new int[resultado.length + 1];
                resultadoFinal[0] = acarreo;
                System.arraycopy(resultado, 0, resultadoFinal, 1, resultado.length);
                return resultadoFinal;
            } else {
                return resultado;
            }
        }
    }

    //Esta implementación es dinámica porque el tamaño del arreglo resultante no está predeterminado, sino que
    // se adapta dinámicamente al tamaño de los números que se están multiplicando. En otras palabras,
    // no es necesario saber de antemano el tamaño máximo del resultado, sino que se crea un arreglo del
    // tamaño adecuado una vez que se ha realizado la multiplicación. Además, se utiliza una lista dinámica
    // (ArrayList) en lugar de un arreglo estático para almacenar temporalmente los resultados parciales de
    // la multiplicación, lo que permite agregar elementos dinámicamente según sea necesario.
}
