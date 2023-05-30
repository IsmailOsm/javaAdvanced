package advancedExamPractice;

import java.util.*;

public class P01RubberDuckDebugger {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] integerArr = Arrays .stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt) .toArray();
        int[] integerArr1 = Arrays .stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt) .toArray();
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < integerArr.length; i++) {
            queue.offer(integerArr[i]);
        }
        for (int i = 0; i < integerArr1.length; i++) {
            stack.push(integerArr1[i]);
        }
        int darthVader = 0;
        int thor = 0;
        int bigBlue = 0;
        int smallYellow = 0;

        while (!queue.isEmpty()) {

            int programmersTime = queue.pop();
            int taskValue = stack.poll();
            int totalValue = programmersTime * taskValue;
            if (totalValue > 240) {
                queue.offer(programmersTime);
                stack.push(taskValue-2);
            } else if (totalValue > 180) {
                smallYellow++;
            } else if (totalValue > 120) {
                bigBlue++;
            } else if (totalValue > 60) {
                thor++;
            } else if (totalValue >= 0) {
                darthVader++;
            }

        }
        System.out.println("Congratulations, all tasks have been completed! Rubber ducks rewarded:");
        System.out.printf("Darth Vader Ducky: %d\n" +
                "Thor Ducky: %d\n" +
                "Big Blue Rubber Ducky: %d\n" +
                "Small Yellow Rubber Ducky: %d",darthVader,thor,bigBlue,smallYellow);
    }
}
