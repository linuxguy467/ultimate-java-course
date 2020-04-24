package com.matthem.streams;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamsDemo {
  public static void show() {
    var stream = Stream.of(List.of(1, 2, 3), List.of(4, 5, 6));
    stream.flatMapToInt(list -> list.stream().mapToInt(n -> n))
          .forEach(System.out::println);

    var movies = List.of(
      new Movie("a", 10, Genre.THRILLER, 13.45),
      new Movie("b", 20, Genre.ACTION, 22.56),
      new Movie("c", 30, Genre.ACTION, 30.76)
    );

    var result = movies.stream()
        .collect(Collectors.groupingBy(
            Movie::getGenre,
            Collectors.mapping(
                  Movie::getTitle,
                  Collectors.joining(", "))));
    System.out.println(result);

    var result1 = movies.stream()
        .collect(Collectors.partitioningBy(
            m -> m.getLikes() > 20,
            Collectors.mapping(Movie::getTitle,
                Collectors.joining(", "))));
    System.out.println(result1);

    // Calculate average price of Movies for each genre
    // 1) Group by genre
    // 2) Calculate average price for each Movie in that genre
    var result2 = movies.stream()
        .collect(Collectors.groupingBy(
                  Movie::getGenre,
                  Collectors.averagingDouble(Movie::getPrice)));
    System.out.println(result2);

    // Create an IntStream from [1, 5)
    IntStream.range(1, 5)
             .forEach(System.out::println);

//        .filter(m -> m.getLikes() > 10)
//        .map(Movie::getTitle)
//        .collect(Collectors.joining(", "));
//
//    System.out.println(result);

//    Predicate<Movie> isPopular = m -> m.getLikes() > 10;

    // 1000 movies
    // 10 per page
    // 3rd page
    // skip(20) = skip( (page - 1) * pageSize )
    // limit(10) = limit(pageSize)

    // [10, 20, 30]
    // [30, 30]
    // [60]

    var sum = movies.stream()
        .map(Movie::getLikes)
        .reduce(0, Integer::sum);

    System.out.println(sum);

//    var result = movies.stream()
//        .max(Comparator.comparing(Movie::getLikes))
//        .get();
//
//    System.out.println(result.getTitle());
//          .filter(m -> m.getLikes() > 10)
//          .peek(m -> System.out.println("filtered: " + m.getTitle()))
//          .map(Movie::getTitle)
//          .peek(t -> System.out.println("mapped: " + t))
//          .forEach(System.out::println);
//          .map(Movie::getLikes)
//          .distinct()
//          .forEach(System.out::println);
//          .sorted(Comparator.comparing(Movie::getTitle).reversed())
//          .forEach(m -> System.out.println(m.getTitle()));
//          .skip(20)
//          .limit(10)
//          .dropWhile(m -> m.getLikes() < 30)
//          .forEach(m -> System.out.println(m.getTitle()));
//          .filter(isPopular)
//          .mapToInt(Movie::getLikes)
//          .forEach(System.out::println);

    // Imperative Programming O(n)
//    int count = 0;
//    for(var movie : movies)
//      if(movie.getLikes() > 100_000)
//        count++;

    // Declarative (Functional) Programming
//    var count2 = movies.stream()
//        .filter(movie -> movie.getLikes() > 100_000)
//        .count();
//
//    System.out.println(count);
//    System.out.println(count2);
  }
}
