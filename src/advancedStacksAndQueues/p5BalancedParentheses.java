package advancedStacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class p5BalancedParentheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        boolean flag = true;
        if (string.length() % 2 == 1){

        }
            for (int i = 0; i < string.length(); i++) {
                if (string.length() % 2 == 1){
                    System.out.println("NO");
                    flag = false;
                    break;
                }
                char symbol = string.charAt(i);
                if (symbol == '{' || symbol == '[' || symbol == '(') {
                    stack.push(i);
                } else {
                    int index = i;
                    char closingBracket = string.charAt(i);
                    char openingBracket = string.charAt(stack.peek());
                    stack.pop();
                    if (openingBracket == '(') {
                        if (closingBracket == ')') {

                        } else {
                            System.out.println("NO");
                            flag = false;
                            break;
                        }

                    } else if (openingBracket == '{') {
                        if (closingBracket == '}') {

                        } else {
                            System.out.println("NO");
                            flag = false;
                            break;
                        }

                    } else if (openingBracket == '[') {
                        if (closingBracket == ']') {

                        } else {
                            System.out.println("NO");
                            flag = false;
                            break;
                        }

                    }


                }
            }
        if (flag) {
            System.out.println("YES");
        }
    }
}
