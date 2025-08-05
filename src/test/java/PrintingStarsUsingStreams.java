import java.util.stream.IntStream;

public class PrintingStarsUsingStreams {

    public static void main(String[] args) {
        // Create a stream of integers from 1 to 5
        int height = 5;

        IntStream.rangeClosed(1, height)
                .mapToObj(i -> " ".repeat(height - i) + "*".repeat(2 * i - 1))
                .forEach(System.out::println);
    }
}
