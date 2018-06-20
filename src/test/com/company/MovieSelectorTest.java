package com.company;

import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MovieSelectorTest {

    @Test
    void from() {
        Movie regular = MovieSelector.from(0);
        Movie newRelease = MovieSelector.from(1);
        Movie children = MovieSelector.from(2);

        assertTrue(regular instanceof RegularMovie);
        assertTrue(newRelease instanceof NewReleaseMovie);
        assertTrue(children instanceof ChildrensMovie);
    }

    @Test
    void fromInvalidCode() {
        assertThrows(IllegalArgumentException.class, () -> MovieSelector.from(3), "invalid code: 3");
    }
}