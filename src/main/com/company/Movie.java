package com.company;

public interface Movie {
    String getTitle();
    double getCharge(int daysRented);
    int getFrequentRenterPoints(int daysRented);
}
