package advancedExamPractice;

import java.util.*;

public class P01Blacksmith {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] steelArr = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        int[] carbonArr = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        ArrayDeque<Integer> steelAmount = new ArrayDeque<>();
        ArrayDeque<Integer> carbonAmount = new ArrayDeque<>();
        for (int i = 0; i < steelArr.length; i++) {
            steelAmount.offer(steelArr[i]);
        }
        for (int i = 0; i < carbonArr.length; i++) {
            carbonAmount.push(carbonArr[i]);
        }
        Map<String, Integer> map = new TreeMap<>();
        int swordMade = 0;
        while (!steelAmount.isEmpty() && !carbonAmount.isEmpty()) {
            int steel = steelAmount.poll();
            int carbon = carbonAmount.pop();
            int mix = steel + carbon;
            switch (mix) {
                case 70:
                    swordMade++;
                    if (!map.containsKey("Gladius")) {
                        map.put("Gladius", 0);
                    }
                    map.put("Gladius", map.get("Gladius") + 1);
                    break;
                case 80:
                    swordMade++;
                    if (!map.containsKey("Shamshir")) {
                        map.put("Shamshir", 0);
                    }
                    map.put("Shamshir", map.get("Shamshir") + 1);
                    break;
                case 90:
                    swordMade++;
                    if (!map.containsKey("Katana")) {
                        map.put("Katana", 0);
                    }
                    map.put("Katana", map.get("Katana") + 1);

                    break;
                case 110:
                    swordMade++;
                    if (!map.containsKey("Sabre")) {
                        map.put("Sabre", 0);
                    }
                    map.put("Sabre", map.get("Sabre") + 1);

                    break;
                default:
                    carbonAmount.push(carbon + 5);

                    break;
            }

        }
        if (map.isEmpty()) {
            System.out.println("You did not have enough resources to forge a sword.");
        } else {
            System.out.printf("You have forged %d swords.%n", swordMade);
        }
        if (steelAmount.isEmpty()) {
            System.out.println("Steel left: none");
        } else {
            System.out.print("Steel left: ");
            while (!steelAmount.isEmpty()) {
                if (steelAmount.size() == 1) {
                    System.out.println(steelAmount.poll());
                } else {
                    System.out.print(steelAmount.poll() + ", ");
                }
            }
        }
        if (carbonAmount.isEmpty()) {
            System.out.println("Carbon left: none");
        } else {
            System.out.print("Carbon left: ");
            while (!carbonAmount.isEmpty()) {
                if (carbonAmount.size() == 1) {
                    System.out.println(carbonAmount.pop());
                } else {
                    System.out.print(carbonAmount.pop() + ", ");
                }
            }
        }
        map.entrySet().forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));
    }
}
