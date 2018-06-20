package com.company;

import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MovieCodeTest {

    @Test
    void from() {
        MovieCode regular = MovieCode.from(0);
        MovieCode newRelease = MovieCode.from(1);
        MovieCode children = MovieCode.from(2);

        assertThat(regular, is(MovieCode.REGULAR));
        assertThat(newRelease, is(MovieCode.NEW_RELEASE));
        assertThat(children, is(MovieCode.CHILDREN));
    }

    @Test
    void fromInvalidCode() {
        assertThrows(IllegalArgumentException.class, () -> MovieCode.from(3), "invalid code: 3");
    }
}