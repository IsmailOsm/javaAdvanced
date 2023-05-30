package advancedMapsAndSets;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P06FixEmails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, String> map = new LinkedHashMap<>();
        String input = scanner.nextLine();
        while (!input.equals("stop")) {
            String name = input;
            String email = scanner.nextLine();
            if (!email.endsWith("com") && !email.endsWith("uk") && !email.endsWith("us")) {
                map.put(name, email);
            }
            input = scanner.nextLine();
        }
        map.entrySet().forEach(entry -> System.out.println(entry.getKey() + " -> " + entry.getValue()));
    }
}
