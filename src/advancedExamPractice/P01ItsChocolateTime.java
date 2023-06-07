package advancedExamPractice;

import java.util.*;

public class P01ItsChocolateTime {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[] milkArray = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToDouble(Double::parseDouble).toArray();
        double[] cocoaArray = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToDouble(Double::parseDouble).toArray();
        ArrayDeque<Double> milkQuantity = new ArrayDeque<>();
        ArrayDeque<Double> cocoaQuantity = new ArrayDeque<>();
        for (Double element : milkArray) {
            milkQuantity.offer(element);
        }
        for (Double element : cocoaArray) {
            cocoaQuantity.push(element);
        }
        Map<String, Integer> map = new TreeMap<>();
        while (!milkQuantity.isEmpty() && !cocoaQuantity.isEmpty()) {
            double milk = milkQuantity.poll();
            double cocoa = cocoaQuantity.pop();
            int cocoaPercentage = (int) Math.round(cocoa / (cocoa + milk) * 100);
            if (cocoaPercentage == 30) {
                if (!map.containsKey("Milk Chocolate")) {
                    map.put("Milk Chocolate", 0);
                }
                map.put("Milk Chocolate", map.get("Milk Chocolate") + 1);
            } else if (cocoaPercentage == 50) {
                if (!map.containsKey("Dark Chocolate")) {
                    map.put("Dark Chocolate", 0);
                }
                map.put("Dark Chocolate", map.get("Dark Chocolate") + 1);
            } else if (cocoaPercentage == 100) {
                if (!map.containsKey("Baking Chocolate")) {
                    map.put("Baking Chocolate", 0);
                }
                map.put("Baking Chocolate", map.get("Baking Chocolate") + 1);
            } else {
                milkQuantity.offer(milk + 10);
            }
        }
        if (map.size() == 3) {
            System.out.println("It’s a Chocolate Time. All chocolate types are prepared.");
        } else {
            System.out.println("Sorry, but you didn't succeed to prepare all types of chocolates.");
        }
        map.entrySet().forEach(entry -> System.out.println("# " + entry.getKey() + " --> " + entry.getValue()));
    }
}
