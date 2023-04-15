package java.event;

import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class SearchJavaEvents {

    public static void printSortedJavaEvents(List<String> events) {
        // write your code here

        events.stream()
            .filter(s -> s.toUpperCase().contains("JAVA"))
            .sorted()
            .forEach(System.out::println);

        /* With a Predicate

        Predicate<String> hasAnyJava = str ->
                str.contains("java") || str.contains("Java") || str.contains("JAVA");

        events.stream()
                .filter(hasAnyJava)
                .sorted()
                .forEach(System.out::println);
         */
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> events = Stream
                .iterate(1, i -> scanner.hasNextLine(), i -> i + 1)
                .map(i -> scanner.nextLine())
                .collect(Collectors.toList());

        printSortedJavaEvents(events);
    }
}
