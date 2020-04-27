package com.matthem.executors;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

public class CompletableFuturesDemo {
  private static int toFahrenheit(int celsius) {
    return (int) (celsius * 1.8) + 32;
  }

  private static CompletableFuture<String> getUserEmailAsync() {
    return CompletableFuture.supplyAsync(() -> "email");
  }

  private static CompletableFuture<String> getPlaylistAsync(String email) {
    return CompletableFuture.supplyAsync(() -> "playlist");
  }

  public static void show() {
    Supplier<Integer> task = () -> 1;
    var future = CompletableFuture.supplyAsync(task);
    try {
      future.get();
    } catch (InterruptedException | ExecutionException e) {
      e.printStackTrace();
    }
    var futureA = CompletableFuture.supplyAsync(() -> 1);
    futureA.thenRunAsync(() -> {
      System.out.println(Thread.currentThread().getName());
      System.out.println("Done");
    });
    futureA.thenAcceptAsync(result -> {
      System.out.println(Thread.currentThread().getName());
      System.out.println(result);
    });

    try {
      Thread.sleep(2000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    var future1 = CompletableFuture.supplyAsync(() -> {
      System.out.println("Getting the current weather");
      throw new IllegalStateException();
    });

    try {
      var temperature = future1.exceptionally(ex -> 1).get();
      System.out.println(temperature);
    } catch (InterruptedException | ExecutionException e) {
      e.printStackTrace();
    }
    var future2 = CompletableFuture.supplyAsync(() -> 20);
    future2
      .thenApply(CompletableFuturesDemo::toFahrenheit)
      .thenAccept(System.out::println);
    getUserEmailAsync()
      .thenCompose(CompletableFuturesDemo::getPlaylistAsync)
      .thenAccept(System.out::println);
    var first = CompletableFuture
          .supplyAsync(() -> "20USD")
          .thenApply(str -> Integer.parseInt(str.replace("USD", "")));

    var second = CompletableFuture.supplyAsync(() -> 0.9);

    System.out.println("Calculating...");

    first
      .thenCombine(second, (price, exchangeRate) -> price * exchangeRate)
      .thenAccept(System.out::println);
    var first1 = CompletableFuture.supplyAsync(() -> 1);
    var second1 = CompletableFuture.supplyAsync(() -> 2);
    var third1 = CompletableFuture.supplyAsync(() -> 3);

    var all = CompletableFuture.allOf(first1, second1, third1);
    all.thenRun(() -> {
      try {
        var firstResult = first1.get();
        System.out.println(firstResult);
      } catch (InterruptedException | ExecutionException e) {
        e.printStackTrace();
      }
      System.out.println("All tasks completed successfully");
    });
    var first2 = CompletableFuture.supplyAsync(() -> {
      LongTask.simulate();
      return 20;
    });

    var second2 = CompletableFuture.supplyAsync(() -> 20);

    CompletableFuture
          .anyOf(first2, second2)
          .thenAccept(System.out::println);
    var future3 = CompletableFuture.supplyAsync(() -> {
      LongTask.simulate();
      return 1;
    });

    try {
      var result = future3
          .completeOnTimeout(1, 1, TimeUnit.SECONDS)
          .get();
      System.out.println(result);
    } catch (InterruptedException | ExecutionException e) {
      e.printStackTrace();
    }
  }
}
