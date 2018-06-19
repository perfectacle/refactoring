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
        StringBuilder result = new StringBuilder(getName() + " 고객님의 대여 기록\n");

        rentals.forEach(aRental -> result.append("\t")
                                         .append(aRental.getMovie().getTitle())
                                         .append("\t")
                                         .append(aRental.getCharge())
                                         .append("\n"));

        result.append("누적 대여로: ")
              .append(getTotalCharge())
              .append("\n")
              .append("적립 포인트: ")
              .append(getFrequentRenterPoints());

        return result.toString();
    }

    private int getFrequentRenterPoints() {
        return rentals.stream().mapToInt(Rental::getFrequentRenterPoints).sum();
    }

    private double getTotalCharge() {
        return rentals.stream().mapToDouble(Rental::getCharge).sum();
    }
}
