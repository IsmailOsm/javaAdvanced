package advancedFirstLab;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class decimalToBinaryConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int decimalNumber = Integer.parseInt(scanner.nextLine());
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        if (decimalNumber == 0) {
            System.out.println(0);
        } else if (decimalNumber < 0) {

        } else {
            while (decimalNumber > 0) {
                stack.push(decimalNumber % 2);
                decimalNumber = decimalNumber / 2;
            }
        }
        for (Integer item:stack) {
            System.out.print(item);
        }
    }
}
