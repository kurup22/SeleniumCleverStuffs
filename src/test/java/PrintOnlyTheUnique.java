import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PrintOnlyTheUnique {

    public static void main(String[] args) {
        Stream<Integer> num=Stream.of(22,33,22,33,55,4,66,7,8,8);

        Map<Integer,Long> freqMap=num.collect(Collectors.groupingBy(n->n, Collectors.counting()));

        freqMap.entrySet().stream()
                .filter(s -> s.getValue() == 1)
                .map(Map.Entry::getKey)
                .forEach(System.out::println);

        int a=freqMap.entrySet().stream()
                .filter(s -> s.getValue() == 2)
                .map(Map.Entry::getKey).sorted().
                skip(2).findFirst().orElse(0);

   System.out.println(" "+a);
    }
}
