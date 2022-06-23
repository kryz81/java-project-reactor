package kryz.flux;

import kryz.util.NameGenerator;
import kryz.util.Util;
import reactor.core.publisher.Flux;

import java.util.List;

public class Lecture6FluxVsList {
    public static void main(String[] args) throws InterruptedException {
        // List<String> names = NameGenerator.getNames(3);
        Flux<String> names = NameGenerator.getNames(3);
        names.subscribe(Util.onNext());
    }
}
