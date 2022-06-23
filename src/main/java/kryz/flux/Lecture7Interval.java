package kryz.flux;

import kryz.util.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class Lecture7Interval {
    public static void main(String[] args) {
        Flux
                .interval(Duration.ofSeconds(1))
                .subscribe(Util.onNext());
    }
}
