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
            double thisAmount = amountFor(aRental);

            frequentRenterPoints++;

            if((aRental.getMovie().getPriceCode() == Movie.NEW_RELEASE) && (aRental.getDaysRented() > 1)) {
                frequentRenterPoints++;
            }

            result.append("\t")
                  .append(aRental.getMovie().getTitle())
                  .append("\t")
                  .append(thisAmount)
                  .append("\n");
            totalAmount += thisAmount;
        }

        result.append("누적 대여로: ")
              .append(totalAmount)
              .append("\n")
              .append("적립 포인트: ")
              .append(frequentRenterPoints);

        return result.toString();
    }

    private double amountFor(Rental aRental) {
        double result = 0;

        switch (aRental.getMovie().getPriceCode()) {
            case Movie.REGULAR:
                result += 2;

                if(aRental.getDaysRented() > 2) result += (aRental.getDaysRented() - 2) * 1.5;

                break;
            case Movie.NEW_RELEASE:
                result += aRental.getDaysRented() * 3;

                break;
            case Movie.CHILDRENS:
                result += 1.5;

                if(aRental.getDaysRented() > 3) result += (aRental.getDaysRented() - 3) * 1.5;

                break;
        }

        return result;
    }
}
