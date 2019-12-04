package com.johnlu.exercise;

import org.junit.Assert;
import org.junit.Test;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StringsFilter {
    public static void main(String[] args) {
        Integer i1 = new Integer(11);
        Integer i2 = new Integer(11);
        Assert.assertTrue(i1 == i2);
    }
    @Test
    public void test1() {
        Integer i1 = 11;
        Integer i2 = new Integer(11);
        Assert.assertTrue(i2 == i1);
    }
}
