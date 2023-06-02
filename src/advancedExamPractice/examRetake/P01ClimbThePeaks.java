package advancedExamPractice.examRetake;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class P01ClimbThePeaks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] integerArr = Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt).toArray();
        int[] integerArr1 = Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt).toArray();
        ArrayDeque<Integer> foodPortions = new ArrayDeque<>();
        ArrayDeque<Integer> stamina = new ArrayDeque<>();
        for (int i = 0; i < integerArr.length; i++) {
            foodPortions.push(integerArr[i]);
        }
        for (int i = 0; i < integerArr1.length; i++) {
            stamina.offer(integerArr1[i]);
        }
        ArrayDeque<String> peaks = new ArrayDeque<>();
        peaks.offer("Vihren");
        peaks.offer("Kutelo");
        peaks.offer("Banski Suhodol");
        peaks.offer("Polezhan");
        peaks.offer("Kamenitza");

        ArrayDeque<Integer> peakHeights = new ArrayDeque<>();
        peakHeights.offer(80);
        peakHeights.offer(90);
        peakHeights.offer(100);
        peakHeights.offer(60);
        peakHeights.offer(70);
        while (!foodPortions.isEmpty()) {
            int portion = foodPortions.pop();
            int dailyStamina = stamina.poll();
            if (portion + dailyStamina >= peakHeights.peek()) {
                peakHeights.poll();
                if (peakHeights.isEmpty()) {
                    break;
                }
            }

        }
        if (peakHeights.size() == 5) {
            System.out.println("Alex failed! He has to organize his journey better next time -> @PIRINWINS");
        } else if (peakHeights.isEmpty()) {
            System.out.println("Alex did it! He climbed all top five Pirin peaks in one week -> @FIVEinAWEEK");
            System.out.println("Conquered peaks:");
            for (String peak : peaks) {
                System.out.println(peaks.poll());
            }
        } else {
            System.out.println("Alex failed! He has to organize his journey better next time -> @PIRINWINS");
            System.out.println("Conquered peaks:");
            for (int i = 0; i < 5 - peakHeights.size(); i++) {
                System.out.println(peaks.poll());
            }
        }
    }
}
