package kryz.basics_and_mono;

import com.github.javafaker.Faker;

public class FakerDemo {
    public static void main(String[] args) {
        System.out.println(Faker.instance().name().fullName());
    }
}
