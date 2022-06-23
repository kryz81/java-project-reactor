package kryz.flux;

import kryz.util.Util;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import reactor.core.publisher.Flux;

import java.util.concurrent.atomic.AtomicReference;

class MySubscriber<T> implements Subscriber<T> {

    private AtomicReference<Subscription> atomicReference = new AtomicReference<>();

    @Override
    public void onSubscribe(Subscription subscription) {
        System.out.println("Received subscription");
        atomicReference.set(subscription);
        subscription.request(3);
    }

    @Override
    public void onNext(T t) {
        System.out.println("onNext: " + t);
    }

    @Override
    public void onError(Throwable throwable) {
        System.out.println("onError: " + throwable.getMessage());
    }

    @Override
    public void onComplete() {
        System.out.println("onComplete");
    }
}

public class Lecture5Subscription {
    public static void main(String[] args) throws InterruptedException {
        Flux<Integer> publisher = Flux.range(1, 10).log();

        // customowa implementacja subscribera
        publisher.subscribeWith(new MySubscriber<>());

        Util.sleep(3);
    }
}
