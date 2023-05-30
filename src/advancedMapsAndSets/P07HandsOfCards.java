package advancedMapsAndSets;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P07HandsOfCards {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Map<String, Integer>> map = new LinkedHashMap<>();
        String input = scanner.nextLine();
        while (!input.equals("JOKER")) {
            String name = input.split(": ")[0];
            String[] cards = input.split(": ")[1].split(", ");
            if (!map.containsKey("name")) {
                map.put(name, new HashMap<>());
            }
            Map<String, Integer> secondMap = new HashMap<>();
            for (int i = 0; i < cards.length; i++) {
                String card = cards[i];
                int cardPower = 1;
                int cardType = 1;
                if (card.endsWith("S")) {
                    cardType = 4;
                } else if (card.endsWith("H")) {
                    cardType = 3;
                } else if (card.endsWith("D")) {
                    cardType = 2;
                }
                if (card.startsWith("10")) {
                    cardPower = 10;
                } else if (card.startsWith("J")) {
                    cardPower = 11;
                } else if (card.startsWith("Q")) {
                    cardPower = 12;
                } else if (card.startsWith("K")) {
                    cardPower = 13;
                } else if (card.startsWith("A")) {
                    cardPower = 14;
                } else {
                    cardPower = Integer.parseInt("" + card.toCharArray()[0]);
                }
                int totalPower = cardPower * cardType;
                secondMap.put(card, totalPower);
            }
            map.put(name, secondMap);

            input = scanner.nextLine();
        }

    }
}
