package com.matthem.executors;

public record Quote(String site, int price) {
  @Override
  public String toString() {
    return "Quote{" +
        "site='" + site + '\'' +
        ", price=" + price +
        '}';
  }
}