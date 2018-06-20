package com.company;

public class Movie {
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;
    public static final int CHILDRENS = 2;

    private String title;
    private Price price;

    public Movie(String title, int priceCode) {
        this.title = title;
        setPrice(priceCode);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Price getPrice() {
        return price;
    }

    public void setPrice(int priceCode) {
        switch (priceCode) {
            case REGULAR:
                price = new RegualrPrice();
                break;
            case NEW_RELEASE:
                price = new NewReleasePrice();
                break;
            case CHILDRENS:
                price = new ChildrensPrice();
                break;
            default:
                throw new IllegalArgumentException("invalid code: " + priceCode);
        }
    }

    public int getPriceCode() {
        return price.getPriceCode();
    }

    public double getCharge(int daysRented) {
        double result = 0;

        switch (getPriceCode()) {
            case Movie.REGULAR:
                result += 2;

                if(daysRented > 2) result += (daysRented - 2) * 1.5;

                break;
            case Movie.NEW_RELEASE:
                result += daysRented * 3;

                break;
            case Movie.CHILDRENS:
                result += 1.5;

                if(daysRented > 3) result += (daysRented - 3) * 1.5;

                break;
        }

        return result;
    }

    public int getFrequentRenterPoints(int daysRented) {
        return (getPriceCode() == Movie.NEW_RELEASE) && (daysRented> 1) ? 2 : 1;
    }
}
