package com.company;

import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MovieSelectorTest {

    @Test
    void from() {
        Class<? extends Movie> regular = MovieSelector.from(0);
        Class<? extends Movie> newRelease = MovieSelector.from(1);
        Class<? extends Movie> children = MovieSelector.from(2);

        assertThat(regular.getName(), is(RegularMovie.class.getName()));
        assertThat(newRelease.getName(), is(NewReleaseMovie.class.getName()));
        assertThat(children.getName(), is(ChildrensMovie.class.getName()));
    }

    @Test
    void fromInvalidCode() {
        assertThrows(IllegalArgumentException.class, () -> MovieSelector.from(3), "invalid code: 3");
    }
}