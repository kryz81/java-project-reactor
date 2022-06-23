package kryz.flux;

import kryz.util.Util;
import reactor.core.publisher.Flux;

public class Lecture2MultipleSubscribers {
    public static void main(String[] args) {
        Flux<String> flux = Flux.just("one", "two", "three");

        // wiele subscriberow, kazdy dostanie wszystkie itemy
        flux.subscribe((val -> System.out.println("Sub 1: " + val)));
        flux.subscribe((val -> System.out.println("Sub 2: " + val)));
        flux.subscribe((val -> System.out.println("Sub 3: " + val)));
    }
}
