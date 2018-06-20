package com.company;

public class MovieSelector {
    public static Class<? extends Movie> from(int code) {
        switch(MovieCode.from(code)) {
            case REGULAR: return RegularMovie.class;
            case NEW_RELEASE: return NewReleaseMovie.class;
            case CHILDREN: return ChildrensMovie.class;
            default: throw new IllegalArgumentException("invalid code: " + code);
        }
    }
}
