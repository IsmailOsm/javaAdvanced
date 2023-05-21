package advancedMapsAndSets;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class p01UniqueUsernames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfUserNAmes = Integer.parseInt(scanner.nextLine());
        Set<String> usernamesSet = new LinkedHashSet<>();
        for (int i = 0; i < numberOfUserNAmes; i++) {
            String username = scanner.nextLine();
            usernamesSet.add(username);
        }
        for (String username: usernamesSet) {
            System.out.println(username);
        }
    }
}
