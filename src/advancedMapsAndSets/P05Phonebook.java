package advancedMapsAndSets;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class P05Phonebook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, String> phoneBook = new HashMap<>();
        String string = scanner.nextLine();
        while (!string.equals("search")) {

            String name = string.split("-")[0];
            String tlfNumber = string.split("-")[1];
            if (!phoneBook.containsKey(name)) {
                phoneBook.put(name, "");
            }
            phoneBook.put(name, tlfNumber);
            string = scanner.nextLine();
        }

        String search = scanner.nextLine();
        while (!search.equals("stop")) {
            String name = search;
            if (!phoneBook.containsKey(name)) {
                System.out.printf("Contact %s does not exist.%n", name);
            }else {
                System.out.printf("%s -> %s%n",name,phoneBook.get(name));
            }

            search = scanner.nextLine();
        }
    }
}
