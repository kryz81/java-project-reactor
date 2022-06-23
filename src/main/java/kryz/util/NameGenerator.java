package kryz.util;

import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;

public class NameGenerator {

/*    public static List<String> getNames(int count) throws InterruptedException {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            list.add(getName());
        }
        return list;
    }*/

    public static Flux<String> getNames(int count) {
        return Flux.range(0, count).map(i -> {
            try {
                return getName();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
    }

    private static String getName() throws InterruptedException {
        Util.sleep(1);
        System.out.println("Generating name");
        return Util.faker().name().fullName();
    }
}
