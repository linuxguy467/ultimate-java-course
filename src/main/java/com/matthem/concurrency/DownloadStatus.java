package com.matthem.concurrency;

import java.util.concurrent.atomic.LongAdder;

public class DownloadStatus {
  private boolean isDone;
//  private AtomicInteger totalBytes = new AtomicInteger();
//  private int totalBytes;
  private LongAdder totalBytes = new LongAdder();
  private int totalFiles;
//  private Object totalBytesLock = new Object();
//  private Object totalFilesLock = new Object();
//  private Lock lock = new ReentrantLock();

  public void incrementTotalBytes() {
//    lock.lock();
//    try {
//      totalBytes++;
//    } finally {
//      lock.unlock();
//    }
//    synchronized (totalBytesLock) {
//      totalBytes++;
//    }
//    totalBytes.getAndIncrement(); // a++
//    totalBytes.incrementAndGet(); // ++a
    totalBytes.increment();
//    totalBytes++;
  }

  public void incrementTotalFiles() {
    totalFiles++;
  }

  public int getTotalBytes() {
    return totalBytes.intValue(); // sum()
//    return totalBytes;
  }

  public int getTotalFiles() {
    return totalFiles;
  }

  public boolean isDone() {
    return isDone;
  }

  public void done() {
    isDone = true;
  }
}
