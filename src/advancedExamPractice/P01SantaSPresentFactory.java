package advancedExamPractice;

import java.util.*;
import java.util.stream.Collectors;

public class P01SantaSPresentFactory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> materials = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).forEach(materials::push);
        ArrayDeque<Integer> magicValues = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toCollection(ArrayDeque::new));
        Map<String, Integer> map = new TreeMap<>();
        while (!materials.isEmpty() && !magicValues.isEmpty()) {
            int material = materials.peek();
            int magic = magicValues.peek();
            int magicLevel = material * magic;
            if (magicLevel == 150) {
                map.putIfAbsent("Doll", 0);
                map.put("Doll", map.get("Doll") + 1);
                materials.pop();
                magicValues.poll();

            } else if (magicLevel == 250) {
                map.putIfAbsent("Wooden train", 0);
                map.put("Wooden train", map.get("Wooden train") + 1);
                materials.pop();
                magicValues.poll();

            } else if (magicLevel == 300) {
                map.putIfAbsent("Teddy bear", 0);
                map.put("Teddy bear", map.get("Teddy bear") + 1);
                materials.pop();
                magicValues.poll();

            } else if (magicLevel == 400) {
                map.putIfAbsent("Bicycle", 0);
                map.put("Bicycle", map.get("Bicycle") + 1);
                materials.pop();
                magicValues.poll();

            } else if (magicLevel < 0) {
                int current = material + magic;
                materials.pop();
                magicValues.poll();
                materials.push(current);

            } else if (magicLevel > 0) {
                int current = material + 15;
                materials.pop();
                magicValues.poll();
                materials.push(current);

            } else {
                if (material == 0) {
                    materials.pop();
                }
                if (magic == 0) {
                    magicValues.poll();
                }
            }
        }
        if ((map.containsKey("doll") && map.containsKey("Wooden train"))
                || (map.containsKey("Teddy bear")) && map.containsKey("Bicycle")) {
            System.out.println("The presents are crafted! Merry Christmas!");

        } else {
            System.out.println("No presents this Christmas!");
        }
        if (!materials.isEmpty()) {
            System.out.print("Materials left: ");
            System.out.print(materials.stream().map(String::valueOf).collect(Collectors.joining(", ")));
            System.out.println();

        } else if (!magicValues.isEmpty()) {
            System.out.print("Magic left: ");
            System.out.print(magicValues.stream().map(String::valueOf).collect(Collectors.joining(", ")));
            System.out.println();
        }
        map.entrySet().forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));
    }
}
