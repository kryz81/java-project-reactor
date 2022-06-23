package kryz.flux;

import kryz.util.Util;
import reactor.core.publisher.Flux;

import java.util.List;

public class Lecture3FluxFromList {
    public static void main(String[] args) {
        List<Integer> list = List.of(1, 2, 3);
        Flux<Integer> flux = Flux.fromIterable(list);

        flux.subscribe(Util.onNext());
    }
}
