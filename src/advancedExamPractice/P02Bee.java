package advancedExamPractice;

import java.util.Scanner;

public class P02Bee {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());
        String[][] matrix = new String[number][];
        fillMatrix(matrix, scanner);
        int row = -1;
        int col = -1;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[i][j].equals("B")) {
                    row = i;
                    col = j;
                }
            }
        }
        boolean flag = false;
        int pollinate = 0;
        String direction = scanner.nextLine();
        while (!direction.equals("End")) {
            matrix[row][col] = ".";
            switch (direction) {
                case "up":
                    row--;
                    if (validIndex(matrix, row, col) && matrix[row][col].equals("O")) {
                        matrix[row][col] = ".";
                        row--;
                    }
                    break;
                case "down":
                    row++;
                    if (validIndex(matrix, row, col) && matrix[row][col].equals("O")) {
                        matrix[row][col] = ".";
                        row++;
                    }
                    break;
                case "left":
                    col--;
                    if (validIndex(matrix, row, col) && matrix[row][col].equals("O")) {
                        matrix[row][col] = ".";
                        col--;
                    }

                    break;
                case "right":
                    col++;
                    if (validIndex(matrix, row, col) && matrix[row][col].equals("O")) {
                        matrix[row][col] = ".";
                        col++;
                    }

                    break;
            }
            if (!validIndex(matrix, row, col)) {
                flag = true;
                break;
            } else if (matrix[row][col].equals("f")) {
                pollinate++;
            }
            direction = scanner.nextLine();
        }
        if (flag) {
            System.out.println("The bee got lost!");
        }
        if (validIndex(matrix, row, col)) {

            matrix[row][col] = "B";
        }

        if (pollinate >= 5) {
            System.out.printf("Great job, the bee manage to pollinate %d flowers!%n", pollinate);
        } else {
            System.out.printf("The bee couldn't pollinate the flowers, she needed %d flowers more%n", 5 - pollinate);
        }
        printMatrix(matrix);
    }

    private static void fillMatrix(String[][] matrix, Scanner scanner) {
        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = scanner.nextLine().split("");
        }
    }

    private static boolean validIndex(String[][] matrix, int row, int col) {
        return row >= 0 && row < matrix.length && col >= 0 && col < matrix.length;
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
