package advancedExamPractice;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class P01KAT {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr1 = Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt).toArray();
        int[] arr2 = Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt).toArray();
        ArrayDeque<Integer> licensePlates = new ArrayDeque<>();
        ArrayDeque<Integer> cars = new ArrayDeque<>();
        for (int i = 0; i < arr1.length; i++) {
            licensePlates.offer(arr1[i]);
        }
        for (int i = 0; i < arr2.length; i++) {
            cars.push(arr2[i]);
        }
        int days = 0;
        int registeredCars = 0;
        while (!licensePlates.isEmpty() && !cars.isEmpty()) {
            days++;
            int plates = licensePlates.poll();
            int numberOfCars = cars.pop();
            if (numberOfCars > plates / 2) {
                registeredCars += plates / 2;
                cars.offer(numberOfCars - plates / 2);

            } else if (numberOfCars < plates / 2) {
                registeredCars += numberOfCars;
                licensePlates.offer(plates - numberOfCars * 2);

            } else {
                registeredCars += numberOfCars;
            }
        }
        System.out.printf("%d cars were registered for %d days!%n", registeredCars, days);
        if (cars.isEmpty() && !licensePlates.isEmpty()) {
            int platesLeft = 0;
            while (!licensePlates.isEmpty()) {
                platesLeft += licensePlates.poll();
            }
            System.out.printf("%d license plates remain!%n", platesLeft);
        } else if (licensePlates.isEmpty() && !cars.isEmpty()) {
            int carsLeft = 0;
            while (!cars.isEmpty()) {
                carsLeft += cars.pop();
            }
            System.out.printf("%d cars remain without license plates!",carsLeft);
        } else {
            System.out.println("Good job! There is no queue in front of the KAT!");
        }
    }
}
