package advancedFirstLab;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class simpleCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> inputElements = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());
        ArrayDeque<String> stack = new ArrayDeque<>();
        stack.addAll(inputElements);
        while (stack.size() > 1) {
            int firstNumber = Integer.parseInt(stack.pop());
            String operator = stack.pop();
            int nextNumber = Integer.parseInt(stack.pop());
            if (operator.equals("+")) {
                stack.push(String.valueOf(firstNumber + nextNumber));
            } else if (operator.equals("-")) {
                stack.push(String.valueOf(firstNumber - nextNumber));
            } else {

            }
        }
        System.out.println(stack.peek());

    }
}
