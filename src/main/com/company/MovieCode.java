package com.company;

import java.util.stream.Stream;

public enum  MovieCode {
    REGULAR(0), NEW_RELEASE(1), CHILDREN(2);

    MovieCode(int code) {
        this.code = code;
    }
    private int code;

    public static MovieCode from(int code) {
        return Stream.of(MovieCode.values())
                     .filter(movieCode -> movieCode.code == code)
                     .findFirst()
                     .orElseThrow(() -> new IllegalArgumentException("invalid code: " + code));
    }
}
