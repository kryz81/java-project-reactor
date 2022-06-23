package kryz.basics_and_mono.assignment1;

import kryz.util.Util;
import reactor.core.publisher.Mono;

public class Assignment1 {
    public static void main(String[] args) {
        Mono<String> reader = FileService.read("pom.xml");
        reader.subscribe(Util.onNext(), Util.onError());
    }
}
