package com.company;

public class ChildrensMovie implements Movie {
    private String title;

    public ChildrensMovie(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public double getCharge(int daysRented) {
        double result = 1.5;
        if(daysRented > 3) result += (daysRented - 3) * 1.5;

        return result;
    }

    @Override
    public int getFrequentRenterPoints(int daysRented) {
        return 1;
    }
}
