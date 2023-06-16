package advancedExamPractice;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P01DatingApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> malesStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).forEach(malesStack::push);
        ArrayDeque<Integer> femalesQueue = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));
        int matches = 0;
        while (!malesStack.isEmpty() && !femalesQueue.isEmpty()) {
            int male = malesStack.peek();
            int female = femalesQueue.peek();
            if (male <= 0 || female <= 0) {
                if (male <= 0) {
                    malesStack.pop();
                } else {
                    femalesQueue.poll();
                }
            } else if (male % 25 == 0 || female % 25 == 0) {
                if (male % 25 == 0) {
                    malesStack.pop();
                    malesStack.pop();
                } else {
                    femalesQueue.poll();
                    femalesQueue.poll();
                }
            } else if (male == female) {
                matches++;
                malesStack.pop();
                femalesQueue.poll();
            } else {
                femalesQueue.poll();
                malesStack.pop();
                malesStack.push(male - 2);
            }
        }
        System.out.printf("Matches: %d%n", matches);
        System.out.print("Males left: ");
        if (malesStack.isEmpty()) {
            System.out.println("none");
        } else {
            System.out.print(malesStack.stream().map(String::valueOf)
                    .collect(Collectors.joining(", ")));
            System.out.println();
        }
        System.out.print("Females left: ");
        if (femalesQueue.isEmpty()){
            System.out.println("none");
        }else {
            System.out.print(femalesQueue.stream().map(String::valueOf)
                    .collect(Collectors.joining(", ")));
        }
    }
}
