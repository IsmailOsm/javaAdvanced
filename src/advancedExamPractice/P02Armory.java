package advancedExamPractice;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P02Armory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
        String[][] matrix = new String[size][];
        fillMatrix(matrix, scanner);
        int[] initialIndex = new int[2];
        findInitialIndex(matrix, initialIndex);
        int row = initialIndex[0];
        int column = initialIndex[1];
        List<Integer> mirrorIndex = new ArrayList<>();
        findMirror(matrix, mirrorIndex);
        int firstMirrorRow = 0;
        int firstMirrorCol = 0;
        int secondMirrorRow = 0;
        int secondMirrorCol = 0;
        if (!mirrorIndex.isEmpty()) {
            firstMirrorRow = mirrorIndex.get(0);
            firstMirrorCol = mirrorIndex.get(1);
            secondMirrorRow = mirrorIndex.get(2);
            secondMirrorCol = mirrorIndex.get(3);
        }
        int totalPrice = 0;
        while (true) {
            matrix[row][column] = "-";
            if (totalPrice > 64) {
                break;
            }
            String direction = scanner.nextLine();
            switch (direction) {
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

            if (!invalidIndex(matrix, row, column)) {
                break;
            } else if (Character.isDigit(matrix[row][column].charAt(0))) {
                int swordPrice = Integer.parseInt(matrix[row][column]);
                totalPrice += swordPrice;
                matrix[row][column] = "-";
            } else if (Character.isLetter(matrix[row][column].charAt(0))) {
                if (firstMirrorRow == row && firstMirrorCol == column) {
                    matrix[row][column] = "-";
                    row = secondMirrorRow;
                    column = secondMirrorCol;

                } else {
                    matrix[row][column] = "-";
                    row = firstMirrorRow;
                    column = firstMirrorCol;

                }
            }
        }
        if (totalPrice > 64) {
            matrix[row][column] = "A";
            System.out.println("Very nice swords, I will come back for more!");
        } else {
            System.out.println("I do not need more swords!");
        }
        System.out.printf("The king paid %d gold coins.%n", totalPrice);
        printMatrix(matrix);
    }

    private static void findMirror(String[][] matrix, List<Integer> indexes) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                if (matrix[row][col].equals("M")) {
                    indexes.add(row);
                    indexes.add(col);

                }
            }

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

    private static void fillMatrix(String[][] matrix, Scanner scanner) {
        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = scanner.nextLine().split("");
        }
    }

    private static boolean invalidIndex(String[][] matrix, int row, int column) {
        return row >= 0 && row < matrix.length && column >= 0 && column < matrix.length;
    }

    private static void printMatrix(String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                System.out.print(matrix[row][col] + "");
            }
            System.out.println();
        }
    }

}
