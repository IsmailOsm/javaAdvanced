package advancedStacksAndQueues;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class P04BasicQueueOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] commandsArr = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        int[] integerArr = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for (Integer number : integerArr) {
            queue.offer(number);
        }
        for (int i = 1; i <= commandsArr[1]; i++) {
            queue.poll();
        }
        if (queue.size() == 0) {
            System.out.println(0);
        } else if (queue.contains(commandsArr[2])) {
            System.out.println("true");
        } else {
            int minNumber = Integer.MAX_VALUE;
            while (!queue.isEmpty()) {
                if (queue.peek() < minNumber) {
                    minNumber = queue.peek();
                    queue.poll();
                } else {
                    queue.poll();
                }
            }
            System.out.println(minNumber);
        }
    }
}
