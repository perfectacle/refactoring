package com.company;

public class RegularMovie implements Movie {
    private String title;

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public double getCharge(int daysRented) {
        double result = 2;
        if(daysRented > 2) result += (daysRented - 2) * 1.5;

        return result;
    }

    @Override
    public int getFrequentRenterPoints(int daysRented) {
        return 1;
    }
}
