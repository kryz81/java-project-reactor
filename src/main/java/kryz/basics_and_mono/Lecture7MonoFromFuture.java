package kryz.basics_and_mono;

import kryz.util.Util;
import reactor.core.publisher.Mono;

import java.util.concurrent.CompletableFuture;

public class Lecture7MonoFromFuture {
    public static void main(String[] args) throws InterruptedException {
        Mono<String> mono = Mono.fromFuture(getName());
        mono.subscribe(Util.onNext());
        Util.sleep(1);
    }

    private static CompletableFuture<String> getName() {
        return CompletableFuture.supplyAsync(() -> Util.faker().name().fullName());
    }
}
