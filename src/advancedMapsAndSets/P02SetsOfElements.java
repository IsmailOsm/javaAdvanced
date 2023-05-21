package advancedMapsAndSets;

import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class P02SetsOfElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String setsSize = scanner.nextLine();
        int firstSetSize = Integer.parseInt(setsSize.split("\\s+")[0]);
        int secondSetSize = Integer.parseInt(setsSize.split("\\s+")[1]);
        Set<Integer> firstSet = new LinkedHashSet<>();
        Set<Integer> secondSet = new LinkedHashSet<>();
        for (int i = 0; i < firstSetSize; i++) {
            int elements = Integer.parseInt(scanner.nextLine());
            firstSet.add(elements);
        }
        for (int i = 0; i < secondSetSize; i++) {
            int elements = Integer.parseInt(scanner.nextLine());
            secondSet.add(elements);
        }
        firstSet.retainAll(secondSet);
        firstSet.forEach(el-> System.out.print(el + " "));
    }
}
