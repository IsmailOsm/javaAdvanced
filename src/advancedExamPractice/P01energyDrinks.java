package advancedExamPractice;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class P01energyDrinks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr1 = Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt).toArray();
        int[] arr2 = Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt).toArray();
        ArrayDeque<Integer> caffeine = new ArrayDeque<>();
        ArrayDeque<Integer> energyDrinks = new ArrayDeque<>();
        for (int i = 0; i < arr1.length; i++) {
            caffeine.push(arr1[i]);
        }

        for (int i = 0; i < arr2.length; i++) {
            energyDrinks.offer(arr2[i]);
        }

    }
}
