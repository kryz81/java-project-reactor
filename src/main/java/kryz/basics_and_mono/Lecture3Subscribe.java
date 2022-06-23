package kryz.basics_and_mono;

import kryz.util.Util;
import reactor.core.publisher.Mono;

public class Lecture3Subscribe {
    public static void main(String[] args) {
        Mono<String> mono = Mono.just("ball").map(item -> {
            throw new RuntimeException("Error happened");
        });

        // możemy obsłużyć error oraz jak emitowanie zakonczone

        // 1. pobranie emitowanej wartości
        mono.subscribe(value -> {
            System.out.println(value);
            // 2. gdy błąd
        }, err -> {
            System.out.println("Error caught: " + err.getMessage());
            // gdy emitowanie zakonczone
        }, () -> {
            System.out.println("Completed");
        });

        // po refactoringu
        mono.subscribe(Util.onNext(), Util.onError(), Util.onComplete());
    }
}
