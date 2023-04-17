package advancedFirstLab;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class matchingBrackets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputLine = scanner.nextLine();
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < inputLine.length(); i++) {
            char symbol = inputLine.charAt(i);
            if (symbol == '(') {
                stack.push(i);
            } else if (symbol == ')') {
                int index = stack.pop();
                String substring = inputLine.substring(index, i + 1);
                System.out.println(substring);
            }
        }
    }
}
