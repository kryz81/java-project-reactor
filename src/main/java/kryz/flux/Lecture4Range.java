package kryz.flux;

import kryz.util.Util;
import reactor.core.publisher.Flux;

public class Lecture4Range {
    public static void main(String[] args) {
        // użycie range + logowanie zdarzeń
        Flux<Integer> items = Flux.range(3, 5).log();
        items.subscribe(Util.onNext());
    }
}
