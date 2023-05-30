package advancedStacksAndQueues;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class P03MaximumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int numberOfCommands = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < numberOfCommands; i++) {
            int[] commandsArray = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();
            if (commandsArray[0] == 1) {
                stack.push(commandsArray[1]);

            } else if (commandsArray[0] == 2) {
                stack.pop();
            } else if (commandsArray[0] == 3) {
                int maxElement = Integer.MIN_VALUE;
                Integer[] arr = stack.toArray(new Integer[0]);
                for (int j = 0; j < arr.length ; j++) {
                    if (arr[j] > maxElement) {
                        maxElement = arr[j];
                    }
                }
                System.out.println(maxElement);
            }
        }
    }
}
