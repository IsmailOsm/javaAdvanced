package advancedExamPractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class P02TreasureHunt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] dimensions = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int rows = dimensions[0];
        String[][] map = new String[rows][];
        fillMatrix(map, scanner);
        int row = 0;
        int col = 0;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j].equals("Y")) {
                    row = i;
                    col = j;
                }
            }
        }
        String direction = scanner.nextLine();
        List<String> directionsList = new ArrayList<>();
        while (!direction.equals("Finish")) {

            if (direction.equals("up")) {
                row--;
                if (indexValidator(row, col, map) && treeFinder(row, col, map)) {

                    directionsList.add(direction);
                } else {
                    row++;
                }

            } else if (direction.equals("down")) {
                row++;
                if (indexValidator(row, col, map) && treeFinder(row, col, map)) {
                    directionsList.add(direction);

                } else {
                    row--;
                }

            } else if (direction.equals("right")) {
                col++;
                if (indexValidator(row, col, map) && treeFinder(row, col, map)) {
                    directionsList.add(direction);
                } else {
                    col--;
                }

            } else if (direction.equals("left")) {
                col--;
                if (indexValidator(row, col, map) && treeFinder(row, col, map)) {

                    directionsList.add(direction);

                } else {
                    col++;
                }

            }


            direction = scanner.nextLine();
        }
        if (map[row][col].equals("X")) {
            System.out.println("I've found the treasure!");
            System.out.print("The right path is ");
            System.out.print(String.join(", ", directionsList));
        } else {
            System.out.println("The map is fake!");
        }

    }

    private static boolean indexValidator(int row, int col, String[][] map) {
        return row >= 0 && row < map.length && col >= 0 && col < map[row].length;
    }

    private static void fillMatrix(String[][] matrix, Scanner scanner) {
        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = scanner.nextLine().split("\\s+");
        }
    }

    private static boolean treeFinder(int row, int col, String[][] map) {
        return !map[row][col].equals("T");
    }


}
