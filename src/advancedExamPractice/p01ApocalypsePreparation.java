package advancedExamPractice;

import java.util.*;
import java.util.stream.Collectors;

public class p01ApocalypsePreparation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> integerList = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> integerList1 = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
        ArrayDeque<Integer> textiles = new ArrayDeque<>();
        ArrayDeque<Integer> medicament = new ArrayDeque<>();
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < integerList.size(); i++) {
            textiles.offer(integerList.get(i));
        }
        for (int i = 0; i < integerList1.size(); i++) {
            medicament.push(integerList1.get(i));
        }
        while (!textiles.isEmpty() && !medicament.isEmpty()) {

            int textile = textiles.poll();
            int medic = medicament.pop();
            int combined = textile + medic;
            if (combined == 100) {
                if (!map.containsKey("MedKit")) {
                    map.put("MedKit", 0);
                }
                map.put("MedKit", map.get("MedKit") + 1);

            } else if (combined == 40) {
                if (!map.containsKey("Bandage")) {
                    map.put("Bandage", 0);
                }
                map.put("Bandage", map.get("Bandage") + 1);
            } else if (combined == 30) {
                if (!map.containsKey("Patch")) {
                    map.put("Patch", 0);
                }
                map.put("Patch", map.get("Patch") + 1);
            } else if (combined > 100) {
                if (!map.containsKey("MedKit")) {
                    map.put("MedKit", 0);
                }
                map.put("MedKit", map.get("MedKit") + 1);
                int nextElement = medicament.pop();
                int excessValue = combined - 100;
                medicament.push(nextElement + excessValue);

            } else {
                medicament.push(medic + 10);
            }

        }
        Map<String, Integer> sortedMap = map.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, TreeMap::new));
        if (medicament.isEmpty() && textiles.isEmpty()) {
            System.out.println("Textiles and medicaments are both empty.");
            sortedMap.forEach((key, value) -> System.out.println(key + " - " + value));
        } else if (medicament.isEmpty()) {
            System.out.println("Medicaments are empty.");
            sortedMap.forEach((key, value) -> System.out.println(key + " - " + value));
            int rest = 0;
            while (!textiles.isEmpty()) {
                rest += textiles.poll();
            }
            System.out.printf("Textiles left: %d%n", rest);
        } else {
            System.out.println("Textiles are empty.");
            sortedMap.forEach((key, value) -> System.out.println(key + " - " + value));
            int rest = 0;
            while (!medicament.isEmpty()) {
                rest += medicament.pop();
            }
            System.out.printf("Medicaments left: %d%n", rest);
        }

    }
}
