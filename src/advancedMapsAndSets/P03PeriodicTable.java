package advancedMapsAndSets;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class P03PeriodicTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfCompounds = Integer.parseInt(scanner.nextLine());
        Set<String> compoundSet = new TreeSet<>();
        for (int i = 0; i < numberOfCompounds; i++) {
            String[] stringArr = scanner.nextLine().split("\\s+");
            compoundSet.addAll(Arrays.asList(stringArr));
        }
        compoundSet.forEach(element -> System.out.print(element + " "));
    }
}
