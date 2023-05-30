package advancedDefiningClasses.P01;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<Person> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] info = scanner.nextLine().split("\\s+");
            String name = info[0];
            int age = Integer.parseInt(info[1]);
            Person person = new Person(name, age);
            list.add(person);
        }
        list = list.stream().filter(person -> person.getAge() > 30).collect(Collectors.toList());
        list.sort(Comparator.comparing(person -> person.getName()));
        for (Person person: list) {
            System.out.println(person.toString());
        }
    }
}
