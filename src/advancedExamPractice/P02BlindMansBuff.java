package advancedExamPractice;

import java.util.Scanner;


public class P02BlindMansBuff {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] matrixSize = scanner.nextLine().split("\\s+");
        int numberOfRows = Integer.parseInt(matrixSize[0]);
        int numberOfColumns = Integer.parseInt(matrixSize[1]);
        String[][] matrix = new String[numberOfRows][numberOfColumns];
        fillMatrix(matrix, scanner);
        int initialRow = 0;
        int initialColumn = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col].equals("B")) {
                    initialRow = row;
                    initialColumn = col;

                }
            }
        }
        String input = scanner.nextLine();
        int moves = 0;
        int touchedPeople = 0;
        while (!input.equals("Finish")) {
            if (touchedPeople == 3) {
                break;
            }
            if (input.equals("up")) {
                initialRow--;
                if (!invalidIndex(matrix, initialRow, initialColumn)
                        || ObstacleCheck(matrix, initialRow, initialColumn)) {
                    initialRow++;
                } else if (personCheck(matrix, initialRow, initialColumn)) {
                    touchedPeople++;
                    moves++;
                } else {
                    moves++;
                }

            } else if (input.equals("down")) {
                initialRow++;
                if (!invalidIndex(matrix, initialRow, initialColumn)
                        || ObstacleCheck(matrix, initialRow, initialColumn)) {
                    initialRow--;
                } else if (personCheck(matrix, initialRow, initialColumn)) {
                    touchedPeople++;
                    moves++;
                } else {
                    moves++;
                }

            } else if (input.equals("left")) {
                initialColumn--;
                if (!invalidIndex(matrix, initialRow, initialColumn)
                        || ObstacleCheck(matrix, initialRow, initialColumn)) {
                    initialColumn++;
                } else if (personCheck(matrix, initialRow, initialColumn)) {
                    touchedPeople++;
                    moves++;
                } else {
                    moves++;
                }

            } else if (input.equals("right")) {
                initialColumn++;
                if (!invalidIndex(matrix, initialRow, initialColumn)
                        || ObstacleCheck(matrix, initialRow, initialColumn)) {
                    initialColumn--;
                } else if (personCheck(matrix, initialRow, initialColumn)) {
                    touchedPeople++;
                    moves++;
                } else {
                    moves++;
                }

            }

            input = scanner.nextLine();
        }
        System.out.println("Game over!");
        System.out.printf("Touched opponents: %d Moves made: %d", touchedPeople, moves);
    }

    private static boolean personCheck(String[][] matrix, int row, int column) {
        return matrix[row][column].equals("P");
    }

    private static boolean ObstacleCheck(String[][] matrix, int row, int column) {
        return matrix[row][column].equals("O");
    }

    private static boolean invalidIndex(String[][] matrix, int row, int column) {
        return row >= 0 && row < matrix.length && column >= 0 && column < matrix.length;
    }


    private static void fillMatrix(String[][] matrix, Scanner scanner) {
        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = scanner.nextLine().split("\\s+");
        }
    }

}
