package com.matthem.streams;

import java.math.BigDecimal;
import java.math.RoundingMode;

public final class Movie {
    private final String title;
    private final int likes;
    private final Genre genre;
    private final double price;

    public Movie(String title, int likes, Genre genre, double price) {
        this.title = title;
        this.likes = likes;
        this.genre = genre;
        this.price = new BigDecimal(price).setScale(2, RoundingMode.HALF_UP).doubleValue();
    }

    public String getTitle() {
        return title;
    }

    public int getLikes() {
        return likes;
    }

    public Genre getGenre() {
        return genre;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return title;
    }
}
