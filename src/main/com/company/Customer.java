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

        for (Rental rental : rentals) {
            double thisAmount = 0;

            switch (rental.getMovie().getPriceCode()) {
                case Movie.REGULAR:
                    thisAmount += 2;

                    if(rental.getDaysRented() > 2) thisAmount += (rental.getDaysRented() - 2) * 1.5;

                    break;
                case Movie.NEW_RELEASE:
                    thisAmount += rental.getDaysRented() * 3;

                    break;
                case Movie.CHILDRENS:
                    thisAmount += 1.5;

                    if(rental.getDaysRented() > 3) thisAmount += (rental.getDaysRented() - 3) * 1.5;

                    break;
            }

            frequentRenterPoints++;

            if((rental.getMovie().getPriceCode() == Movie.NEW_RELEASE) && (rental.getDaysRented() > 1)) {
                frequentRenterPoints++;
            }

            result.append("\t")
                  .append(rental.getMovie().getTitle())
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
}
