package kryz.flux;

import kryz.util.Util;
import reactor.core.publisher.Flux;

public class Lecture1FluxIntro {
    public static void main(String[] args) {
        Flux<String> flux = Flux.just("one", "two");
        flux.subscribe(Util.onNext());
    }

}
