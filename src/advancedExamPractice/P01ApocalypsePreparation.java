package advancedExamPractice;

import java.util.*;
import java.util.stream.Collectors;

public class P01ApocalypsePreparation {
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
        List<Map.Entry<String, Integer>> sortedMap =
                new ArrayList<>(map.entrySet());
        Collections.sort(sortedMap,
                Comparator.comparing(Map.Entry<String, Integer>::getValue).reversed().
                        thenComparing(Map.Entry<String, Integer>::getKey));
        if (medicament.isEmpty() && textiles.isEmpty()) {
            System.out.println("Textiles and medicaments are both empty.");
            sortedMap.forEach((entry) -> System.out.println(entry.getKey() + " - " + entry.getValue()));
        } else if (medicament.isEmpty()) {
            System.out.println("Medicaments are empty.");
            sortedMap.forEach((entry) -> System.out.println(entry.getKey() + " - " + entry.getValue()));
            System.out.print("Textiles left: ");
            while (!textiles.isEmpty()) {
                if (textiles.size() == 1) {
                    System.out.print(textiles.poll());
                } else {
                    System.out.print(textiles.poll() + ", ");
                }
            }

        } else {
            System.out.println("Textiles are empty.");
            sortedMap.forEach((entry) -> System.out.println(entry.getKey() + " - " + entry.getValue()));
            System.out.print("Medicaments left: ");
            while (!medicament.isEmpty()) {
                if (medicament.size()==1){
                    System.out.print(medicament.pop());
                }else {
                    System.out.print(medicament.pop()+", ");
                }
            }

        }

    }
}
