package co.edu.uniquindio.analisis.proyecto2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Aplicacion {

    public static void main(String[] args) {
        int n=10;
        for (int i = 1; i <= 8; i++) {
            int[] a = leerCasosPruebas("Caso" + i + ".txt", n);

            System.out.println("Test case " + i + ":");
            System.out.println("a = " + Arrays.toString(a));
            System.out.println();
            n +=500;
        }
    }

    private static int[] leerCasosPruebas(String fileName, int n) {
        int[] array = new int[n];
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line = reader.readLine();
            String[] digits = line.substring(1, line.length() - 1).split(", ");
            for (int i = 0; i < n; i++) {
                array[i] = Integer.parseInt(digits[i]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return array;
    }


}
