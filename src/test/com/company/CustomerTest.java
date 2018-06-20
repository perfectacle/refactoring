package com.company;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("커스토머 테스트")
class CustomerTest {
    @Test
    @DisplayName("테스트 스테이트먼트")
    public void testStatement() throws InstantiationException, IllegalAccessException {
        Customer customer = new Customer("냥");
        customer.addRental(buildRental("냐", 0, 3));
        customer.addRental(buildRental("냐앙", 1, 1));
        customer.addRental(buildRental("니나노", 2, 3));
        customer.addRental(buildRental("니나노누누", 2, 4));

        assertThat(customer.statement(), is("냥 고객님의 대여 기록\n" +
                                                    "\t냐\t3.5\n" +
                                                    "\t냐앙\t3.0\n" +
                                                    "\t니나노\t1.5\n" +
                                                    "\t니나노누누\t3.0\n" +
                                                    "누적 대여로: 11.0\n" +
                                                    "적립 포인트: 4"));
    }

    private Rental buildRental(String title, int priceCode, int daysRented) throws IllegalAccessException, InstantiationException {
        Movie movie = MovieSelector.from(priceCode);
        movie.setTitle(title);

        return new Rental(movie, daysRented);
    }
}