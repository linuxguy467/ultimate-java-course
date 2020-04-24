package com.matthem.streams;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CreatingStreamsDemo {
  public static void show() {
//    Collection<Integer> x;
//    x.stream();
//    var list = new ArrayList<>();
//    list.stream();
    int[] numbers = { 1, 2, 3 };
    Arrays.stream(numbers)
        .forEach(System.out::println);
    var intStream = IntStream.of(1, 2, 3, 4);
    System.out.println(
        intStream.filter(n -> n >= 3)
                 .sum()
    );

    Stream.generate(Math::random)
          .limit(5)
          .forEach(System.out::println);

    Stream.iterate(1, n -> n + 1)
        .limit(10)
        .forEach(System.out::println);
  }
}
