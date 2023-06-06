package advancedExamPractice;

import java.util.ArrayDeque;
import java.util.Scanner;


public class P02TheSquirrel {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int matrixSize = Integer.parseInt(scanner.nextLine());
        String[] commands = scanner.nextLine().split(", ");
        String[][] matrix = new String[matrixSize][];
        fillMatrix(matrix, scanner);
        int row = 0;
        int column = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j].equals("s")) {
                    row = i;
                    column = j;
                }
            }
        }
        boolean trap = false;
        boolean outOfField = false;
        int hazelnuts = 0;
        for (int i = 0; i < commands.length; i++) {

            if (hazelnuts == 3) {
                break;
            }
            String direction = commands[i];
            matrix[row][column] = "*";
            if (direction.equals("up")) {
                row--;
                if (indexValidator(matrix, row, column)) {
                    if (hazelnutCheck(matrix, row, column)) {
                        hazelnuts++;
                        matrix[row][column] = "*";
                    }
                } else {
                    outOfField = true;
                    break;
                }
                if (trapCheck(matrix, row, column)) {
                    trap = true;
                    break;
                }

            } else if (direction.equals("down")) {
                row++;

                if (indexValidator(matrix, row, column)) {
                    if (hazelnutCheck(matrix, row, column)) {
                        hazelnuts++;
                        matrix[row][column] = "*";
                    }
                } else {
                    outOfField = true;
                    break;
                }
                if (trapCheck(matrix, row, column)) {
                    trap = true;
                    break;
                }


            } else if (direction.equals("left")) {
                column--;

                if (indexValidator(matrix, row, column)) {
                    if (hazelnutCheck(matrix, row, column)) {
                        hazelnuts++;
                        matrix[row][column] = "*";
                    }
                } else {
                    outOfField = true;
                    break;
                }
                if (trapCheck(matrix, row, column)) {
                    trap = true;
                    break;
                }

            } else if (direction.equals("right")) {
                column++;

                if (indexValidator(matrix, row, column)) {
                    if (hazelnutCheck(matrix, row, column)) {
                        hazelnuts++;
                        matrix[row][column] = "*";
                    }
                } else {
                    outOfField = true;
                    break;
                }
                if (trapCheck(matrix, row, column)) {
                    trap = true;
                    break;
                }


            }
        }
        if (outOfField) {
            System.out.println("The squirrel is out of the field.");
        } else if (trap) {
            System.out.println("Unfortunately, the squirrel stepped on a trap...");
        } else if (hazelnuts == 3) {
            System.out.println("Good job! You have collected all hazelnuts!");
        } else {
            System.out.println("There are more hazelnuts to collect.");
        }
        System.out.printf("Hazelnuts collected: %d", hazelnuts);
    }

    private static boolean indexValidator(String[][] matrix, int row, int column) {
        return row >= 0 && row < matrix.length && column >= 0 && column < matrix[0].length;


    }

    private static boolean trapCheck(String[][] matrix, int row, int column) {
        return matrix[row][column].equals("t");

    }


    private static void fillMatrix(String[][] matrix, Scanner scanner) {
        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = scanner.nextLine().split("");
        }
    }

    private static boolean hazelnutCheck(String[][] matrix, int row, int column) {
        return matrix[row][column].equals("h");
    }
}
