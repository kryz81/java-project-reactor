package kryz.basics_and_mono;

import java.util.stream.Stream;

public class Lecture1Stream {
    public static void main(String[] args) {
        Stream<Integer> stream = Stream.of(1, 2, 3);
        stream.map(val -> {
            try {
                Thread.sleep(1000);
                return val * 2;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        });
        System.out.println(stream);
    }
}
