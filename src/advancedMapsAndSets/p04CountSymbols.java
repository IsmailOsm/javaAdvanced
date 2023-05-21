package advancedMapsAndSets;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class p04CountSymbols {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        char[] charactersArray = string.toCharArray();
        Map<Character, Integer> lettersMap = new TreeMap<>();
        for (char letter : charactersArray) {
            if (!lettersMap.containsKey(letter)) {
                lettersMap.put(letter, 0);
            }
            lettersMap.put(letter, lettersMap.get(letter) + 1);

        }
        lettersMap.entrySet().forEach(entry -> System.out.println(entry.getKey() + ":" + " "+entry.getValue()+" time/s"));
    }
}
