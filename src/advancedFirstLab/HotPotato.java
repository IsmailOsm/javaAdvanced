package advancedFirstLab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class HotPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] names = scanner.nextLine().split("\\s+");
        int n = Integer.parseInt(scanner.nextLine());
        ArrayDeque<String> queue = new ArrayDeque<>();
        for (String name : names) {
            queue.offer(name);
        }
        while (queue.size() > 1) {
            for (int i = 1; i < n; i++) {
                String kid = queue.poll();
                queue.offer(kid);
            }
            String removed = queue.poll();
            System.out.println("Removed " + removed);
        }
        System.out.println("Last is " + queue.poll());
    }
}
