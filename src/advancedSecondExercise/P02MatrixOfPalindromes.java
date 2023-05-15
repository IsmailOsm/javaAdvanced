package advancedSecondExercise;

import java.util.Scanner;

public class P02MatrixOfPalindromes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = scanner.nextInt();
        int columns = scanner.nextInt();
        String[][] matrix = new String[rows][columns];
        fillingMatrix(matrix, rows, columns);
        printingMatrix(matrix, rows, columns);
    }

    private static void printingMatrix(String[][] matrix, int rows, int columns) {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < columns; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }


    private static void fillingMatrix(String[][] matrix, int rows, int columns) {
        char firstLetter = 'a';
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < columns; col++) {
                String palindrome = "" + firstLetter + (char) (firstLetter + col) + firstLetter;
                matrix[row][col] =palindrome;
            }
            firstLetter++;

        }
    }
}
