package com.company;

public class MovieSelector {
    public static Movie from(int code) {
        switch(MovieCode.from(code)) {
            case REGULAR: return new RegularMovie();
            case NEW_RELEASE: return new NewReleaseMovie();
            case CHILDREN: return new ChildrensMovie();
            default: throw new IllegalArgumentException("invalid code: " + code);
        }
    }
}
