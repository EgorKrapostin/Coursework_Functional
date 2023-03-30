import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        String input = "yourapp the quick brown fox jumps over the lazy dog";

        long output = Arrays.stream(input
                        .split(" "))
                .count();
        System.out.println("В тексте " + output + " слов");

        Map<String, Long> out = new HashMap<>();
        Arrays.stream(input.split(" "))
                .collect(Collectors.groupingBy(k -> k, () -> out,
                        Collectors.counting()));
        out.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(10)
                .forEach(System.out::println);
    }
}