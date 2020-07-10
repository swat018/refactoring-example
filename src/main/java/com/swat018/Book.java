package com.swat018;

import java.lang.annotation.Inherited;
import java.util.function.DoubleToIntFunction;

public class Book {

    public static String A = "A";

    private String B = "B";

    private void c() {
        System.out.println("C");
    }

    public int sum(int left, int right) {
        return left + right;
    }

    public Book() {

    }

    public Book(String b) {
        B = b;
    }
}
