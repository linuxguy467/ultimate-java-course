package finalsection;

import java.util.function.BiFunction;
import java.util.function.Consumer;

public class Lambdas {
    public static void main(String[] args) {
/*        Predicate<Integer> isDivisibleBy5 = number -> number % 5 == 0;
        Predicate<Integer> isDivisibleBy3 = number -> number % 3 == 0;

        Consumer<Integer> fizzBuzz = number -> {
            if(isDivisibleBy5.and(isDivisibleBy3).test(number)) {
                System.out.println("FizzBuzz");
                return;
            }
            if(isDivisibleBy5.test(number)) {
                System.out.println("Fizz");
                return;
            }
            if(isDivisibleBy3.test(number)) {
                System.out.println("Buzz");
                return;
            }
            System.out.println(number);
        };

        for (int i = 1; i < 101; i++)
            fizzBuzz.accept(i);*/

        int AlexAge = 20;

        BiFunction<String, Integer, String> upperCaseName = (name, age) -> {
            // logic
            if(name.isBlank()) throw new IllegalArgumentException("");
            System.out.println(age);
            return name.toUpperCase();
        };

        System.out.println(upperCaseName.apply("Alex", AlexAge));
    }

    class Service {
        Consumer<String> blah = s -> {
        };
    }
}
