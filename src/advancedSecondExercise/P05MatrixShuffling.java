package advancedSecondExercise;

import java.util.Scanner;

public class P05MatrixShuffling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String matrixSize = scanner.nextLine();
        int rows = Integer.parseInt(matrixSize.split("\\s+")[0]);
        int columns = Integer.parseInt(matrixSize.split("\\s+")[1]);
        String[][] matrix = new String[rows][columns];
        fillMatrix(matrix, scanner);
        String input = scanner.nextLine();
        while (!input.equals("END")) {
            if (validInput(input, matrix)) {
                shuffleMatrix(matrix,input);
                printMatrix(matrix);
            } else {
                System.out.println("Invalid input!");
            }


            input = scanner.nextLine();
        }
    }

    private static void shuffleMatrix(String[][] matrix, String input) {
        int row1 = Integer.parseInt(input.split("\\s+")[1]);
        int col1 = Integer.parseInt(input.split("\\s+")[2]);
        int row2 = Integer.parseInt(input.split("\\s+")[3]);
        int col2 = Integer.parseInt(input.split("\\s+")[4]);
        String firstElement = matrix[row1][col1];
        String secondElement = matrix[row2][col2];
        matrix[row1][col1] = secondElement;
        matrix[row2][col2] = firstElement;
    }

    private static boolean validInput(String input, String[][] matrix) {
        if (input.split("\\s+").length != 5) {
            return false;
        }
        String command = input.split("\\s+")[0];
        int row1 = Integer.parseInt(input.split("\\s+")[1]);
        int col1 = Integer.parseInt(input.split("\\s+")[2]);
        int row2 = Integer.parseInt(input.split("\\s+")[3]);
        int col2 = Integer.parseInt(input.split("\\s+")[4]);

        if (!command.equals("swap")) {
            return false;
        }
        if (row1 < 0 || row1 >= matrix.length || col1 < 0 || col1 >= matrix[0].length || row2 < 0 ||
                row2 >= matrix.length || col2 < 0 || col2 >= matrix[0].length) {
            return false;
        }
        return true;
    }

    private static void fillMatrix(String[][] matrix, Scanner scanner) {
        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = scanner.nextLine().split("\\s+");
        }
    }

    private static void printMatrix(String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println(); //свали курсора на следващия ред
        }
    }


}
