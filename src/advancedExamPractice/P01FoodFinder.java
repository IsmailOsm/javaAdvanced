package advancedExamPractice;

import java.util.*;

public class P01FoodFinder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] firstArr = scanner.nextLine().split("\\s+");
        String[] arrayTwo = scanner.nextLine().split("\\s+");
        ArrayDeque<String> queueVowels = new ArrayDeque<>();
        ArrayDeque<String> stackConsonats = new ArrayDeque<>();
        List<String> list2 = new ArrayList<>();
        list2.add("");
        list2.add("");
        list2.add("");
        list2.add("");
        List<String> list = new ArrayList<>();
        list.add("pear");
        list.add("flour");
        list.add("pork");
        list.add("olive");
        for (int i = 0; i < firstArr.length; i++) {
            queueVowels.offer(firstArr[i]);
        }
        for (int i = 0; i < arrayTwo.length; i++) {
            stackConsonats.push(arrayTwo[i]);
        }
        while (!stackConsonats.isEmpty()) {
            String poll = queueVowels.poll();
            String pop = stackConsonats.pop();

            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).contains(poll) && !list2.get(i).contains(poll)) {
                    String word = list2.get(i);
                    String replace = word + poll;
                    list2.set(i, replace);


                }
                if (list.get(i).contains(pop) && !list2.get(i).contains(pop)) {
                    String word = list2.get(i);
                    String replace = word + pop;
                    list2.set(i, replace);

                }

            }
            queueVowels.offer(poll);
        }
        ArrayDeque<String> queue = new ArrayDeque<>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).length() == list2.get(i).length()) {
                queue.offer(list.get(i));
            }
        }
        System.out.printf("Words found: %d%n", queue.size());
        while (!queue.isEmpty()){
            System.out.println(queue.poll());
        }
    }
}
