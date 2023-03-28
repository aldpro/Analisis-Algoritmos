package co.edu.analisis.model.methods;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class MatrizTXT {

    public static void main(String[] args) {

        int[] numeroValues = generarElevado(12);

        int j = 1;
        	for (int n : numeroValues) {
                String fileName = "Matriz " + j + ".txt";
                generarMatrix(n, fileName);
                System.out.println("Matriz generada para n = " + n + " en el archivo " + fileName);
                j ++;
            }
        
    }

    public static int[] generarElevado(int n) {

        int[] powersOfTwo = new int[n];

        for (int i = 0; i < n; i++) {
            powersOfTwo[i] = (int) Math.pow(2, i+1);
        }

        return powersOfTwo;

    }

    public static void generarMatrix(int n, String fileName) {

        int[][] matrix = new int[n][n];

        Random rand = new Random();

        try {
            FileWriter writer = new FileWriter(fileName);

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = rand.nextInt(9000) + 1000; // Generar un numero aleatorio de al menos 4 digitos
                    writer.write(matrix[i][j] + "\t");
                }
                writer.write("\n");
            }

            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
