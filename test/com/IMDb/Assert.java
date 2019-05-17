package com.IMDb;

import java.util.Objects;

final public class Assert {

    private Assert() {
    }

    public static void equals(Object result, Object expected) {
        if (!Objects.equals(result, expected)) {
            throw new AssertionError("Expected result was - " + expected + " ,but was - " + result);
        }
    }

    public static void fail() {
        throw new AssertionError("Test is failed");
    }

}
