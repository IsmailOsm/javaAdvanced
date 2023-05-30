package advancedMultidimensionalArrays;

import java.util.Scanner;

public class P06StringMatrixRotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String rotation = scanner.nextLine();
        String value = rotation.replaceAll("[^0-9]","");
        int degrees = Integer.parseInt(value);
        
    }
}
