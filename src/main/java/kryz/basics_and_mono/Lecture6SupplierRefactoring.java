package kryz.basics_and_mono;

import kryz.util.Util;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

public class Lecture6SupplierRefactoring {
    public static void main(String[] args) throws InterruptedException {
        // nic będzie czekać, bo nie ma subscibera, więc to co w fromSupplier nie zostanie odpalone!
        getName();

        System.out.println("start");
        getName().subscribe(Util.onNext()); // blokuje, bo domyslnie w tym samym threadzie wszystko odpalane!
        System.out.println("end");

        // mozemy wymusic async
        System.out.println("start");
        getName()
                .subscribeOn(Schedulers.boundedElastic())
                .subscribe(Util.onNext()); // blokuje, bo domyslnie w tym samym threadzie wszystko odpalane!
        System.out.println("end");

        // mozemy tez odpalic cos async ale blokowac main thread i zwrocic do niego wartosc, bez subskrybowania
        String result = getName().subscribeOn(Schedulers.boundedElastic()).block();
        System.out.println(result);
    }

    private static Mono<String> getName() {
        System.out.println("Generating name");
        return Mono.fromSupplier(() -> {
            try {
                Util.sleep(3);
                return Util.faker().name().firstName();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).map(String::toUpperCase);
    }
}
