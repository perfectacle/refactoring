package com.company;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String name;
    private List<Rental> rentals = new ArrayList<>();

    public Customer(String name) {
        this.name = name;
    }

    public void addRental(Rental rental) {
        rentals.add(rental);
    }

    public String getName() {
        return name;
    }

    public String statement() {
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        StringBuilder result = new StringBuilder(getName() + " 고객님의 대여 기록\n");

        for (Rental aRental : rentals) {
            frequentRenterPoints++;

            if((aRental.getMovie().getPriceCode() == Movie.NEW_RELEASE) && (aRental.getDaysRented() > 1)) {
                frequentRenterPoints++;
            }

            result.append("\t")
                  .append(aRental.getMovie().getTitle())
                  .append("\t")
                  .append(aRental.getCharge())
                  .append("\n");
            totalAmount += aRental.getCharge();
        }

        result.append("누적 대여로: ")
              .append(totalAmount)
              .append("\n")
              .append("적립 포인트: ")
              .append(frequentRenterPoints);

        return result.toString();
    }
}
