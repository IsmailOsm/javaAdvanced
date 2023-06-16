package advancedExamPractice;

import java.util.Scanner;


public class P02BookWorm {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        int number = Integer.parseInt(scanner.nextLine());
        String[][] matrix = new String[number][];
        fillMatrix(matrix, scanner);
        int row = -1;
        int col = -1;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[i][j].equals("P")) {
                    row = i;
                    col = j;
                }
            }
        }
        StringBuilder builder = new StringBuilder(string);
        String direction = scanner.nextLine();
        while (!direction.equals("end")) {
            matrix[row][col] = "-";
            switch (direction) {
                case "up":
                    row--;
                    if (!validIndex(matrix, row, col)) {
                        row++;
                        builder.deleteCharAt(builder.length() - 1);
                    }

                    break;
                case "down":
                    row++;
                    if (!validIndex(matrix, row, col)) {
                        row--;
                        builder.deleteCharAt(builder.length() - 1);
                    }

                    break;
                case "left":
                    col--;
                    if (!validIndex(matrix, row, col)) {
                        col++;
                        builder.deleteCharAt(builder.length() - 1);
                    }

                    break;
                case "right":
                    col++;
                    if (!validIndex(matrix, row, col)) {
                        col--;
                        builder.deleteCharAt(builder.length() - 1);
                    }

                    break;
            }
            if (!matrix[row][col].equals("-")) {
                builder.append(matrix[row][col]);
                matrix[row][col] = "-";
            }

            direction = scanner.nextLine();
        }
        matrix[row][col] = "P";
        System.out.println(builder.toString());
        printMatrix(matrix);

    }

    private static boolean validIndex(String[][] matrix, int row, int col) {
        return row >= 0 && row < matrix.length && col >= 0 && col < matrix.length;
    }

    private static void fillMatrix(String[][] matrix, Scanner scanner) {
        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = scanner.nextLine().split("");
        }
    }
    private static void printMatrix(String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }


}
