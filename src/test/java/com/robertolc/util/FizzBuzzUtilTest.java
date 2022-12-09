package com.robertolc.util;

import org.junit.Test;

import static org.junit.Assert.*;

public class FizzBuzzUtilTest {
    @Test
    public void return_fizz_when_number_is_divisible_by_3() {
        assertEquals("fizz",FizzBuzzUtil.fizzbuzz(3));
        assertEquals("fizz",FizzBuzzUtil.fizzbuzz(6));
    }

    @Test
    public void return_buzz_when_number_is_divisible_by_5() {
        assertEquals("buzz",FizzBuzzUtil.fizzbuzz(5));
        assertEquals("buzz",FizzBuzzUtil.fizzbuzz(10));
    }

    @Test
    public void return_fizzbuzz_when_number_is_divisible_by_3_and_5() {
        assertEquals("fizzbuzz",FizzBuzzUtil.fizzbuzz(15));
        assertEquals("fizzbuzz",FizzBuzzUtil.fizzbuzz(30));
    }

    @Test
    public void return_same_number_when_number_is_not_divisible_by_3_and_5() {
        assertEquals("2",FizzBuzzUtil.fizzbuzz(2));
        assertEquals("16",FizzBuzzUtil.fizzbuzz(16));
    }

}