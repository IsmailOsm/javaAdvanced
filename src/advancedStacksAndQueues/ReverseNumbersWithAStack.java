package advancedStacksAndQueues;

import java.util.*;
import java.util.stream.Collectors;

public class ReverseNumbersWithAStack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        List<Integer> integerList = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
        Collections.reverse(integerList);
        stack.addAll(integerList);
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }
}
