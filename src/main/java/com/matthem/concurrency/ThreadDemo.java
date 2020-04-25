package com.matthem.concurrency;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class ThreadDemo {
  public static void show() {
//    Thread thread = new Thread(new DownloadFileTask());
//    thread.start();
//
//    try {
//      Thread.sleep(1000);
//    } catch (InterruptedException e) {
//      e.printStackTrace();
//    }
//
//    thread.interrupt();
//    try {
//      thread.join();
//    } catch (InterruptedException e) {
//      e.printStackTrace();
//    }
//    System.out.println("File is ready to be scanned");
//    System.out.println(Thread.currentThread().getName());

    var status = new DownloadStatus();
    List<Thread> threads = new ArrayList<>();
//    List<DownloadFileTask> tasks = new ArrayList<>();

    for (var i = 0; i < 10; ++i) {
//      var task = new DownloadFileTask();
//      tasks.add(task);

      var thread = new Thread(new DownloadFileTask(status));
      thread.start();
      threads.add(thread);
    }

    for (var thread : threads) {
      try {
        thread.join();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }

//    var totalBytes = tasks.stream()
//        .map(t -> t.getStatus().getTotalBytes())
//        .reduce(Integer::sum);

//    System.out.println(status.getTotalBytes());
//    var status = new DownloadStatus();
//    var thread1 = new Thread(new DownloadFileTask(status));
//    var thread2 = new Thread(() -> {
//      while (!status.isDone()) {
//        synchronized (status) {
//          try {
//            status.wait();
//          } catch (InterruptedException e) {
//            e.printStackTrace();
//          }
//        }
//      }
//      System.out.println(status.getTotalBytes());
//    });
//
//    thread1.start();
//    thread2.start();
    Collection<Integer> collection =
        Collections.synchronizedCollection(new ArrayList<>());

    var thread1 = new Thread(() -> {
      collection.addAll(Arrays.asList(1, 2, 3));
    });

    var thread2 = new Thread(() -> {
      collection.addAll(Arrays.asList(4, 5, 6));
    });

    thread1.start();
    thread2.start();

    try {
      thread1.join();
      thread2.join();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    System.out.println(collection);
  }
}
