package co.edu.analisis.model;

import java.util.HashMap;

public class Metodo {

	private HashMap<Integer, String> nombres;

    public Metodo() {
        nombres = new HashMap<>();
        nombres.put(1, "NaivStandard");
        nombres.put(2, "NaivOnArray");
        nombres.put(3, "NaivKahan");
        nombres.put(4, "NaivLoopUnrollingTwo");
        nombres.put(5, "NaivLoopUnrollingThree");
        nombres.put(6, "NaivLoopUnrollingFour");
        nombres.put(7, "WinogradOriginal");
        nombres.put(8, "WinogradScaled");
        nombres.put(9, "StrassenNaiv");
        nombres.put(10, "StrassenWinograd");
        nombres.put(11, "SequentialBlockThreeIII");
        nombres.put(12, "SequentialBlockThreeIV");
        nombres.put(13, "SequentialBlockThreeV");
        nombres.put(14, "ParallelBlockFourIII");
        nombres.put(15, "ParallelBlockFourIV");
        nombres.put(16, "ParallelBlockFourV");
    }

    public String obtenerNombre(int numero) {
        return nombres.get(numero);
    }
}
