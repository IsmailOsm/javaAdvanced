package advancedSecondExercise;

import java.util.Scanner;

public class P01FillTheMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int matrixSize = Integer.parseInt(input.split(", ")[0]);
        String patternType = input.split(", ")[1];
        int[][] matrix = new int[matrixSize][matrixSize];
        switch (patternType) {
            case "A":
                fillMatrixA(matrix);
                printMatrix(matrix);
                break;
            case "B":
                fillMatrixB(matrix);
                printMatrix(matrix);
                break;
            default:
        }
    }

    private static void fillMatrixB(int[][] matrix) {
        int currentNumber = 1;
        for (int col = 0; col < matrix.length; col++) {
            if (col % 2 == 0) {
                for (int row = 0; row < matrix.length; row++) {
                    matrix[row][col] = currentNumber;
                    currentNumber++;
                }
            } else {
                for (int row = matrix.length - 1; row >=0; row--) {
                    matrix[row][col] = currentNumber;
                    currentNumber++;
                }
            }
        }
    }

    private static void printMatrix(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix.length; column++) {
                System.out.print(matrix[row][column] + " ");
            }
            System.out.println();
        }
    }

    private static void fillMatrixA(int[][] matrix) {
        int currentNumber = 1;
        for (int col = 0; col < matrix.length; col++) {
            for (int row = 0; row < matrix.length; row++) {
                matrix[row][col] = currentNumber;
                currentNumber++;
            }
        }
    }
}
