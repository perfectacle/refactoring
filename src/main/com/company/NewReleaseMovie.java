package com.company;

public class NewReleaseMovie implements Movie {
    private String title;

    public NewReleaseMovie(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public double getCharge(int daysRented) {
        return daysRented * 3;
    }

    @Override
    public int getFrequentRenterPoints(int daysRented) {
        return (daysRented > 1) ? 2 : 1;
    }
}