package co.edu.analisis.model.methods;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class MatrizTxt {

    public static void main(String[] args) {

        int[] nValues = generatePowersOfTwo(12);

        for (int n : nValues) {
            String fileName = "matriz_" + n + ".txt";
            generateMatrix(n, fileName);
            System.out.println("Matriz generada para n = " + n + " en el archivo " + fileName);
        }
    }

    public static int[] generatePowersOfTwo(int n) {

        int[] powersOfTwo = new int[n];

        for (int i = 0; i < n; i++) {
            powersOfTwo[i] = (int) Math.pow(2, i+1);
        }

        return powersOfTwo;

    }

    public static void generateMatrix(int n, String fileName) {

        int[][] matrix = new int[n][n];

        Random rand = new Random();

        try {
            FileWriter writer = new FileWriter(fileName);

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = rand.nextInt(9000) + 1000; // Generar un número aleatorio de al menos 4 dígitos
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
