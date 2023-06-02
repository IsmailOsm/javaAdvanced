package advancedExamPractice.examRetake;

import java.util.Scanner;

public class P02NavyBattle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());
        String[][] matrix = new String[number][number];
        fillMatrix(matrix, scanner);
        int row = 0;
        int column = 0;
        for (int rows = 0; rows < number; rows++) {
            for (int col = 0; col < number; col++) {
                if (matrix[rows][col].equals("S")) {
                    row = rows;
                    column = col;
                }
            }

        }
        int mines = 0;
        int battleShip = 0;
        while (true) {
            matrix[row][column] = "-";
            String direction = scanner.nextLine();
            if (mines == 3 || battleShip == 3) {
                matrix[row][column] = "S";
                break;
            } else if (direction.equals("up")) {
                row--;
                if (matrix[row][column].equals("*")) {
                    mines++;
                    matrix[row][column] = "-";
                } else if (matrix[row][column].equals("C")) {
                    battleShip++;
                    matrix[row][column] = "-";
                }

            } else if (direction.equals("down")) {
                row++;
                if (matrix[row][column].equals("*")) {
                    mines++;
                    matrix[row][column] = "-";
                } else if (matrix[row][column].equals("C")) {
                    battleShip++;
                    matrix[row][column] = "-";
                }

            } else if (direction.equals("left")) {
                column--;
                if (matrix[row][column].equals("*")) {
                    mines++;
                    matrix[row][column] = "-";
                } else if (matrix[row][column].equals("C")) {
                    battleShip++;
                    matrix[row][column] = "-";
                }

            } else if (direction.equals("right")) {
                column++;
                if (matrix[row][column].equals("*")) {
                    mines++;
                    matrix[row][column] = "-";
                } else if (matrix[row][column].equals("C")) {
                    battleShip++;
                    matrix[row][column] = "-";
                }
            }

        }
        if (battleShip == 3) {
            System.out.println("Mission accomplished, U-9 has destroyed all battle cruisers of the enemy!");
            printMatrix(matrix);
        } else if (mines == 3) {
            System.out.printf("Mission failed, U-9 disappeared! Last known coordinates [%d, %d]!%n", row, column);
            printMatrix(matrix);
        }

    }

    private static void fillMatrix(String[][] matrix, Scanner scanner) {
        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = scanner.nextLine().split("");
        }
    }

    private static void printMatrix(String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                System.out.print(matrix[row][col] + "");
            }
            System.out.println(); //свали курсора на следващия ред
        }
    }


}
