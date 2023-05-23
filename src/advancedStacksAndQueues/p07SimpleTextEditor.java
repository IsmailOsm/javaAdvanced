package advancedStacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class p07SimpleTextEditor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());
        ArrayDeque<String> stack = new ArrayDeque<>();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < number; i++) {
            String input = scanner.nextLine();
            int commandType = Integer.parseInt(input.split("\\s+")[0]);
            switch (commandType) {
                case 1:
                    stack.push(stringBuilder.toString());
                    String text = input.split("\\s+")[1];
                    stringBuilder.append(text);
                    break;
                case 2:
                    stack.push(stringBuilder.toString());
                    int count = Integer.parseInt(input.split("\\s+")[1]);
                    for (int j = 0; j < count; j++) {
                       stringBuilder.deleteCharAt(stringBuilder.length() - 1);
                    }

                    break;
                case 3:
                    int index = Integer.parseInt(input.split("\\s+")[1]);
                    System.out.println(stringBuilder.charAt(index - 1));
                    break;
                case 4:
                   stringBuilder=new StringBuilder(stack.pop());

                    break;
                default:
                    break;
            }

        }
    }
}
