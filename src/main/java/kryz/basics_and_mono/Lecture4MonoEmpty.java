package kryz.basics_and_mono;

import kryz.util.Util;
import reactor.core.publisher.Mono;

public class Lecture4MonoEmpty {
    public static void main(String[] args) {
        userRepository(1).subscribe(
          Util.onNext(), // odpali, gdy mono nie puste
          Util.onError(), // odpali, gdy mono wzwraca error
          Util.onComplete() // odpali mono niepuste lub puste i nie zwraca error
        );
    }

    private static Mono<String> userRepository(int userId) {
        if (userId == 1) {
            return Mono.just(Util.faker().name().firstName());
        } else if (userId == 2) {
            // zwrócenie pustego mono
            return Mono.empty();
        } else {
            // trigger mono error
            return Mono.error(new RuntimeException("User not found"));
        }
    }
}
