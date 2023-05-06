package co.edu.uniquindio.analisis.proyecto2.metodos;

public class MultiplicacionInglesaDinamica {
    //Metodo dinamico a la inglesa

    public class Arreglo {

        private int[] arreglo;

        public Arreglo(int[] arreglo) {
            this.arreglo = arreglo;
        }

        public int[] getArreglo() {
            return arreglo;
        }

        public void setArreglo(int[] arreglo) {
            this.arreglo = arreglo;
        }

        public int getElemento(int indice) {
            return arreglo[indice];
        }

        public void setElemento(int indice, int valor) {
            arreglo[indice] = valor;
        }

        public int getLongitud() {
            return arreglo.length;
        }

        public void imprimir() {
            for (int i = 0; i < arreglo.length; i++) {
                System.out.print(arreglo[i] + " ");
            }
            System.out.println();
        }

        public Arreglo multiplicacionInglesa(Arreglo otro) {
            int[] a = this.arreglo;
            int[] b = otro.arreglo;

            int[] resultado = new int[a.length + b.length];

            for (int i = b.length - 1; i >= 0; i--) {
                int carry = 0;
                for (int j = a.length - 1; j >= 0; j--) {
                    int temp = b[i] * a[j] + resultado[i + j + 1] + carry;
                    resultado[i + j + 1] = temp % 10;
                    carry = temp / 10;
                }
                resultado[i] += carry;
            }

            return new Arreglo(resultado);
        }

    }
}
