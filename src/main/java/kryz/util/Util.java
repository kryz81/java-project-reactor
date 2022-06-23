package kryz.util;

import com.github.javafaker.Faker;

import java.util.function.Consumer;

public class Util {

    private static final Faker FAKER = Faker.instance();

    public static Consumer<Object> onNext() {
        return o -> System.out.println("Received: " + o);
    }

    public static Consumer<Throwable> onError() {
        return o -> System.out.println("Error: " + o.getMessage());
    }

    public static Runnable onComplete() {
        return () -> System.out.println("Completed");
    }

    public static Faker faker() {
        return FAKER;
    }

    public static void sleep(int sec) throws InterruptedException {
        Thread.sleep(sec);
    }
}
