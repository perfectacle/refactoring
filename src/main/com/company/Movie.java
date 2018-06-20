package com.company;

public interface Movie {
    String getTitle();
    void setTitle(String title);
    double getCharge(int daysRented);
    int getFrequentRenterPoints(int daysRented);
}
