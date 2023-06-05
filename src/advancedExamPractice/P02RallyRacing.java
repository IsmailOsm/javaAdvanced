package advancedExamPractice;

import java.util.Scanner;

public class P02RallyRacing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());
        String numberOfTheCar = scanner.nextLine();
        String[][] racetrack = new String[number][number];
        fillMatrix(racetrack, scanner);
        int firstTunnelRow = 0;
        int firstTunnelCol = 0;
        int secondTunnelRow = 0;
        int secondTunnelCol = 0;
        for (int row = 0; row < number; row++) {
            for (int col = 0; col < number; col++) {
                if (racetrack[row][col].equals("T")) {
                    if (firstTunnelRow == 0) {
                        firstTunnelRow = row;
                        firstTunnelCol = col;
                    } else {
                        secondTunnelRow = row;
                        secondTunnelCol = col;
                    }
                }
            }
        }
        String direction = scanner.nextLine();
        int row = 0;
        int column = 0;
        int km = 0;
        while (!direction.equals("End")) {
            if (direction.equals("left")) {
                column--;
                if (racetrack[row][column].equals(".")) {
                    km += 10;
                } else if (racetrack[row][column].equals("F")) {
                    km += 10;
                    racetrack[row][column] = "C";
                    break;
                } else if (racetrack[row][column].equals("T")) {
                    km += 30;
                    racetrack[row][column] = ".";
                    if (row == firstTunnelRow && column == firstTunnelCol) {
                        row = secondTunnelRow;
                        column = secondTunnelCol;
                    } else {
                        row = firstTunnelRow;
                        column = firstTunnelCol;
                    }
                    racetrack[row][column] = ".";
                }

            } else if (direction.equals("right")) {
                column++;
                if (racetrack[row][column].equals(".")) {
                    km += 10;
                } else if (racetrack[row][column].equals("F")) {
                    km += 10;
                    racetrack[row][column] = "C";
                    break;
                } else if (racetrack[row][column].equals("T")) {
                    km += 30;
                    racetrack[row][column] = ".";
                    if (row == firstTunnelRow && column == firstTunnelCol) {
                        row = secondTunnelRow;
                        column = secondTunnelCol;
                    } else {
                        row = firstTunnelRow;
                        column = firstTunnelCol;
                    }
                    racetrack[row][column] = ".";
                }

            } else if (direction.equals("up")) {
                row--;
                if (racetrack[row][column].equals(".")) {
                    km += 10;
                } else if (racetrack[row][column].equals("F")) {
                    km += 10;
                    racetrack[row][column] = "C";
                    break;
                } else if (racetrack[row][column].equals("T")) {
                    km += 30;
                    racetrack[row][column] = ".";
                    if (row == firstTunnelRow && column == firstTunnelCol) {
                        row = secondTunnelRow;
                        column = secondTunnelCol;
                    } else {
                        row = firstTunnelRow;
                        column = firstTunnelCol;
                    }
                    racetrack[row][column] = ".";
                }

            } else if (direction.equals("down")) {
                row++;
                if (racetrack[row][column].equals(".")) {
                    km += 10;
                } else if (racetrack[row][column].equals("F")) {
                    km += 10;
                    racetrack[row][column] = "C";
                    break;
                } else if (racetrack[row][column].equals("T")) {
                    km += 30;
                    racetrack[row][column] = ".";
                    if (row == firstTunnelRow && column == firstTunnelCol) {
                        row = secondTunnelRow;
                        column = secondTunnelCol;
                    } else {
                        row = firstTunnelRow;
                        column = firstTunnelCol;
                    }
                    racetrack[row][column] = ".";
                }

            }

            direction = scanner.nextLine();
        }
        if (direction.equals("End")) {
            racetrack[row][column] = "C";
            System.out.printf("Racing car %s DNF.%n", numberOfTheCar);
            System.out.printf("Distance covered %d km.%n", km);
            printMatrix(racetrack);
        } else {
            System.out.printf("Racing car %s finished the stage!%n", numberOfTheCar);
            System.out.printf("Distance covered %d km.%n", km);
            printMatrix(racetrack);
        }

    }

    private static void fillMatrix(String[][] matrix, Scanner scanner) {
        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = scanner.nextLine().split("\\s+");
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
