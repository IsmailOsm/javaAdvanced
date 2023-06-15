package advancedExamPractice;

import java.util.Scanner;

public class P02PawnWars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] matrixSize = scanner.nextLine().split("\\s+");
        int numberOfRows = Integer.parseInt(matrixSize[0]);
        String[][] matrix = new String[numberOfRows][];
        fillMatrix(matrix, scanner);
        int[] initialIndex = new int[2];
        findInitialIndex(matrix, initialIndex);
        int row = initialIndex[0];
        int column = initialIndex[1];


        String directions = scanner.nextLine();
        while (!directions.equals("Finish")) {

            switch (directions) {
                case "up":
                    row--;
                    break;
                case "down":
                    row++;
                    break;
                case "left":
                    column--;
                    break;
                case "right":
                    column++;
                    break;
                default:
                    break;
            }


            directions = scanner.nextLine();
        }


    }

    private static void fillMatrix(String[][] matrix, Scanner scanner) {
        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = scanner.nextLine().split("\\s+");
        }
    }

    private static void findInitialIndex(String[][] matrix, int[] index) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                if (matrix[row][col].equals("A")) {
                    index[0] = row;
                    index[1] = col;
                }
            }

        }
    }
    private static boolean invalidIndex(String[][] matrix, int row, int column) {
        return row >= 0 && row < matrix.length && column >= 0 && column < matrix.length;
    }
}
