package advancedExamPractice;

import java.lang.reflect.Array;
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
}
