package advancedExamPractice;

import java.util.Scanner;

public class P02StickyFingers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int matrixSize = Integer.parseInt(scanner.nextLine());
        String[] directions = scanner.nextLine().split(",");
        String[][] matrix = new String[matrixSize][];
        fillMatrix(matrix, scanner);
        int stolenMoney = 0;
        boolean flag = false;
        int row = 0;
        int column = 0;
        for (int rows = 0; rows < matrixSize; rows++) {
            for (int col = 0; col < matrixSize; col++) {
                if (matrix[rows][col].equals("D")) {
                    row = rows;
                    column = col;
                }
            }
        }

        for (int i = 0; i < directions.length; i++) {
            String move = directions[i];
            matrix[row][column] = "+";
            if (move.equals("up")) {
                row--;
                if (!validIndex(matrix, row, column)) {
                    System.out.println("You cannot leave the town, there is police outside!");
                    row++;
                } else if (matrix[row][column].equals("$")) {
                    System.out.printf("You successfully stole %d$.%n", row * column);
                    stolenMoney += row * column;
                } else if (matrix[row][column].equals("P")) {
                    matrix[row][column] = "#";
                    flag = true;
                    break;
                }

            } else if (move.equals("down")) {
                row++;
                if (!validIndex(matrix, row, column)) {
                    System.out.println("You cannot leave the town, there is police outside!");
                    row--;
                } else if (matrix[row][column].equals("$")) {
                    System.out.printf("You successfully stole %d$.%n", row * column);
                    stolenMoney += row * column;
                } else if (matrix[row][column].equals("P")) {
                    matrix[row][column] = "#";
                    flag = true;
                    break;
                }

            } else if (move.equals("left")) {
                column--;
                if (!validIndex(matrix, row, column)) {
                    System.out.println("You cannot leave the town, there is police outside!");
                    column++;
                } else if (matrix[row][column].equals("$")) {
                    System.out.printf("You successfully stole %d$.%n", row * column);
                    stolenMoney += row * column;
                } else if (matrix[row][column].equals("P")) {
                    matrix[row][column] = "#";
                    flag = true;
                    break;
                }

            } else if (move.equals("right")) {
                column++;
                if (!validIndex(matrix, row, column)) {
                    System.out.println("You cannot leave the town, there is police outside!");
                    column--;
                } else if (matrix[row][column].equals("$")) {
                    System.out.printf("You successfully stole %d$.%n", row * column);
                    stolenMoney += row * column;
                } else if (matrix[row][column].equals("P")) {
                    matrix[row][column] = "#";
                    flag = true;
                    break;
                }

            }
        }

        if (flag) {
            System.out.printf("You got caught with %d$, and you are going to jail.%n", stolenMoney);
        } else {
            matrix[row][column]="D";
            System.out.printf("Your last theft has finished successfully with %d$ in your pocket.%n", stolenMoney);
        }
        printMatrix(matrix);
    }


    private static boolean validIndex(String[][] matrix, int row, int column) {
        return row >= 0 && row < matrix.length && column >= 0 && column < matrix.length;
    }

    private static void fillMatrix(String[][] matrix, Scanner scanner) {
        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = scanner.nextLine().split("\\s+");
        }
    }
    private static void printMatrix(String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

}
