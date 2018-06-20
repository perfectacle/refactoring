package com.company;

public class Rental {
    private Movie movie;
    private int daysRented;

    public Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    public Movie getMovie() {
        return movie;
    }

    public int getDaysRented() {
        return daysRented;
    }

    public double getCharge() {
        return movie.getCharge(getDaysRented());
    }

    public int getFrequentRenterPoints() {
        return getMovie().getFrequentRenterPoints(getDaysRented());
    }
}
