package co.edu.uniquindio.analisis.proyectosegundo;

import java.util.HashMap;

public class Metodo {

	private HashMap<Integer, String> nombres;

    public Metodo() {
        nombres = new HashMap<>();
        nombres.put(1, "Americano Iterativo [estatico]");
        nombres.put(2, "Americano Iterativo [dinamico]");
        nombres.put(3, "Americano Recursivo [estatico]");
        nombres.put(4, "Americano Recursivo [dinamico]");
        nombres.put(5, "Inglesa Iterativo [estatico]");
        nombres.put(6, "Inglesa Iterativo [dinamico]");
        nombres.put(7, "Inglesa Recursivo [estatico]");
        nombres.put(8, "Inglesa Recursivo [dinamico]");
        nombres.put(9, "Rusa");
        nombres.put(10, "Hindu");
        nombres.put(11, "Egipcia");
        nombres.put(12, "Karatsuba");
        nombres.put(13, "Representado Cadena");
        nombres.put(14, "Divide y Venceras-I");
        nombres.put(15, "Divide y Venceras-II");
    }

    public String obtenerNombre(int numero) {
        return nombres.get(numero);
    }
}
