package advancedExamPractice;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class P01energyDrinks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr1 = Arrays.stream(scanner.nextLine().split(",\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        int[] arr2 = Arrays.stream(scanner.nextLine().split(",\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        ArrayDeque<Integer> caffeine = new ArrayDeque<>();
        ArrayDeque<Integer> energyDrinks = new ArrayDeque<>();
        for (int i = 0; i < arr1.length; i++) {
            caffeine.push(arr1[i]);
        }

        for (int i = 0; i < arr2.length; i++) {
            energyDrinks.offer(arr2[i]);
        }
        int totalCaffeine = 0;
        while (!caffeine.isEmpty() && !energyDrinks.isEmpty()) {

            int mgOfCaffeine = caffeine.pop();
            int drink = energyDrinks.poll();
            if (mgOfCaffeine * drink + totalCaffeine <= 300) {
                totalCaffeine += mgOfCaffeine * drink;
            } else {
                energyDrinks.offer(drink);
                totalCaffeine -= 30;
                if (totalCaffeine < 0) {
                    totalCaffeine = 0;
                }
            }

        }
        if (energyDrinks.isEmpty()){
            System.out.println("At least Stamat wasn't exceeding the maximum caffeine.");
            System.out.printf("Stamat is going to sleep with %d mg caffeine.",totalCaffeine);
        }else {
            Integer[] arr = energyDrinks.toArray(new Integer[0]);
            System.out.print("Drinks left: ");
            for (int i = 0; i < arr.length-1; i++) {
                System.out.print(arr[i]+", ");
            }
            System.out.println(arr[arr.length-1]);
            System.out.printf("Stamat is going to sleep with %d mg caffeine.",totalCaffeine);
        }
    }

    public static class P02NavyBattle {
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
}
