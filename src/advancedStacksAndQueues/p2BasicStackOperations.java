package advancedStacksAndQueues;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class p2BasicStackOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] commandsArray = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        int[] integerArr = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < commandsArray[0]; i++) {
            stack.push(integerArr[i]);
        }
        for (int i = 0; i < commandsArray[1]; i++) {
            stack.pop();
        }
        if (stack.isEmpty()) {
            System.out.println(0);
        } else if (stack.contains(commandsArray[2])) {
            System.out.println("true");
        } else {
            int smallestNumber = Integer.MAX_VALUE;
            while (!stack.isEmpty()) {
                if (stack.peek() < smallestNumber) {
                    smallestNumber = stack.pop();
                } else {
                    stack.pop();
                }
            }
            System.out.println(smallestNumber);
        }
    }
}
