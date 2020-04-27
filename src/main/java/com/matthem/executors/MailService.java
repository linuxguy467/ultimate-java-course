package com.matthem.executors;

import java.util.concurrent.CompletableFuture;

public class MailService {
  private void send() {
    LongTask.simulate();
    System.out.println("Mail was sent.");
  }

  public CompletableFuture<Void> sendAsync() {
    return CompletableFuture.runAsync(this::send);
  }
}
