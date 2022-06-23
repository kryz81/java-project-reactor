package kryz.basics_and_mono;

import reactor.core.publisher.Mono;

public class Lecture2Mono {
    public static void main(String[] args) {
        // tworzymy publisher typu Mono
        Mono<Integer> mono = Mono.just(1);

        // NIC nie jest emitowane, dopóki nie dodamy choć jednego subscibera
        mono.subscribe(value -> System.out.println("Received: " + value));
    }
}
