package kryz.basics_and_mono;

import kryz.util.Util;
import reactor.core.publisher.Mono;

import java.util.concurrent.Callable;

public class Lecture5FromSupplier {
    public static void main(String[] args) {
        // uzywamy just jesli mamy juz jakies dane i chcemy od razu utworzyc mono z nich
        Mono<String> mono = Mono.just(getName());
        mono.subscribe(Util.onNext());

        // tutaj dane beda dopiero zwracane przez jakiegos Suppliera, wiec dopiero odpalony jak zrobimy subscribe
        Mono<String> mono1 = Mono.fromSupplier(Lecture5FromSupplier::getName);
        mono1.subscribe(Util.onNext());

        // można z interfejsu Callable
        Callable<String> stringCallable = Lecture5FromSupplier::getName;
        Mono<String> mono2 = Mono.fromCallable(stringCallable);
        mono2.subscribe(Util.onNext());

    }

    private static String getName() {
        System.out.println("Generating name");
        return Util.faker().name().firstName();
    }
}
