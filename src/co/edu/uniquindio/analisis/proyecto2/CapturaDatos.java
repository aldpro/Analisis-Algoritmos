package co.edu.uniquindio.analisis.proyecto2;

import co.edu.analisis.model.methods.NaivStandard;
import co.edu.uniquindio.analisis.proyecto2.metodos.MultiplicacionAmericanaEstatica;

public class CapturaDatos {
    public Object[] consultaMetodo(int[] arregloa, int[] arreglob, int metodo) {
        Object[] ejecucion = null;

        switch (metodo) {
            case 1:
                ejecucion = capturaNaivStandard(matrizn, matrizm);
                break;
            case 2:
                ejecucion = capturaNaivOnArray(matrizn, matrizm);
                break;
            case 3:
                ejecucion = capturaNaivKahan(matrizn, matrizm);
                break;
            case 4:
                ejecucion = capturaNaivLoopUnrollingTwo(matrizn, matrizm);
                break;
            case 5:
                ejecucion = capturaNaivLoopUnrollingThree(matrizn, matrizm);
                break;
            case 6:
                ejecucion = capturaNaivLoopUnrollingFour(matrizn, matrizm);
                break;
            case 7:
                ejecucion = capturaWinogradOriginal(matrizn, matrizm);
                break;
            case 8:
                ejecucion = capturaWinogradScaled(matrizn, matrizm);
                break;
            case 9:
                ejecucion = capturaStrassenNaiv(matrizn, matrizm);
                break;
            case 10:
                ejecucion = capturaStrassenWinograd(matrizn, matrizm);
                break;
            case 11:
                ejecucion = capturaSequentialBlockThreeThree(matrizn, matrizm);
                break;
            case 12:
                ejecucion = capturaSequentialBlockThreeFour(matrizn, matrizm);
                break;
            case 13:
                ejecucion = capturaSequentialBlockThreeFive(matrizn, matrizm);
                break;
            case 14:
                ejecucion = capturaParallelBlockFourThree(matrizn, matrizm);
                break;
            case 15:
                ejecucion = capturaParallelBlockFourFour(matrizn, matrizm);
                break;
            default:
                ejecucion = null;
                break;
        }
        return ejecucion;
    }

    public Object[] capturaTiempoAmericanaEstatica(int[] a, int[] b){

        MultiplicacionAmericanaEstatica metodo = new MultiplicacionAmericanaEstatica();

        int[] resultadoMultiplicacion;

        long inicioTiempo = System.nanoTime();

        resultadoMultiplicacion = metodo.multiplicacionAmericana(a, b);

        long finTiempo = System.nanoTime();
        long tiempo = finTiempo - inicioTiempo;

        Object[] respuesta = { tiempo, resultadoMultiplicacion };

        return respuesta;
    }
}
