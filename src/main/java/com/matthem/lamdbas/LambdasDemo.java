package com.matthem.lamdbas;

import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntSupplier;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.ToIntFunction;
import java.util.function.UnaryOperator;

public class LambdasDemo {
    public LambdasDemo(String message) {
    }
    public void print(String message) {}
    public static void show() {
        greet(System.out::println);
        var demo = new LambdasDemo("");
        greet(demo::print);
        greet(demo::print);
        greet(LambdasDemo::new);
        greet(LambdasDemo::new);
        // Class/Object::method
        List<Integer> list = List.of(1, 2, 3);

        // Imperative Programming (for, if/else, switch/case)
        for (var item : list)
            System.out.println(item);

        // Declarative Programming
        list.forEach(System.out::println);
        List<String> list1 = List.of("a", "b", "c");
        Consumer<String> print = System.out::println;
        Consumer<String> printUpperCase = item -> System.out.println(item.toUpperCase());

        list1.forEach(print.andThen(printUpperCase).andThen(print));
        Supplier<Integer> getRandom = () -> (int) (Math.random() * 32);
        IntSupplier getRandom1 = () -> (int) (Math.random() * 32);
        var random = getRandom.get();
        System.out.println(random);
        var random1 = getRandom1.getAsInt();
        System.out.println(random1);
        Function<String, Integer> map = String::length;
        ToIntFunction<String> map1 = String::length;
        var length = map.apply("Sky");
        System.out.println(length);
        var length1 = map1.applyAsInt("Sky");
        System.out.println(length1);
        // "key:value"
        // first: "key=value"
        // second: "{key=value}"
        Function<String, String> replaceColon = str -> str.replace(":", "=");
        Function<String, String> addBraces = str -> "{" + str+ "}";

        var result = replaceColon
                    .andThen(addBraces)
                    .apply("key:value");

        result = addBraces.compose(replaceColon).apply("key:value");

        System.out.println(result);
        // "sky"
        Predicate<String> isLongThan5 = str -> str.length() > 5;
        var result4 = isLongThan5.test("sky");
        System.out.println(result4);
        Predicate<String> hasLeftBrace = str -> str.startsWith("{");
        Predicate<String> hasRightBrace = str -> str.endsWith("}");

        // && || !
        var hasLeftAndRightBraces = hasLeftBrace.and(hasRightBrace);
        hasLeftAndRightBraces.test("{key:value}");
        // a, b -> a+b -> square
        BinaryOperator<Integer> add = Integer::sum;
        Function<Integer, Integer> square = a -> a * a;

        var result5 = add.andThen(square).apply(1, 2);
        System.out.println(result5);
        UnaryOperator<Integer> squareUnary = n -> n * n;
        UnaryOperator<Integer> increment = n -> n + 1;

        var result6 = increment.andThen(squareUnary).apply(1);
        System.out.println(result6);
    }

    private static void greet(Printer printer) {
        printer.print("Hello World");
    }
}
