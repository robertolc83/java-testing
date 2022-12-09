package com.robertolc.util;

import org.junit.Test;

import static org.junit.Assert.*;

public class RomanNumeralsUtilTest {
    @Test
    public void convert_a_arabic_number_to_roman() {

        assertEquals("I",RomanNumeralsUtil.arabicToRoman(1));
        assertEquals("II",RomanNumeralsUtil.arabicToRoman(2));
        assertEquals("III",RomanNumeralsUtil.arabicToRoman(3));
        assertEquals("V",RomanNumeralsUtil.arabicToRoman(5));
        assertEquals("VI",RomanNumeralsUtil.arabicToRoman(6));
        assertEquals("VII",RomanNumeralsUtil.arabicToRoman(7));
        assertEquals("X",RomanNumeralsUtil.arabicToRoman(10));
        assertEquals("XI",RomanNumeralsUtil.arabicToRoman(11));
        assertEquals("XV",RomanNumeralsUtil.arabicToRoman(15));
        assertEquals("XVI",RomanNumeralsUtil.arabicToRoman(16));
        assertEquals("L",RomanNumeralsUtil.arabicToRoman(50));
        assertEquals("LI",RomanNumeralsUtil.arabicToRoman(51));
        assertEquals("LV",RomanNumeralsUtil.arabicToRoman(55));
        assertEquals("LVI",RomanNumeralsUtil.arabicToRoman(56));
        assertEquals("LX",RomanNumeralsUtil.arabicToRoman(60));
        assertEquals("LXX",RomanNumeralsUtil.arabicToRoman(70));
        assertEquals("LXXX",RomanNumeralsUtil.arabicToRoman(80));
        assertEquals("LXXXI",RomanNumeralsUtil.arabicToRoman(81));
        assertEquals("LXXXV",RomanNumeralsUtil.arabicToRoman(85));
        assertEquals("LXXXVI",RomanNumeralsUtil.arabicToRoman(86));
        assertEquals("CXXVI",RomanNumeralsUtil.arabicToRoman(126));
        assertEquals("MMDVII",RomanNumeralsUtil.arabicToRoman(2507));

        assertEquals("IV",RomanNumeralsUtil.arabicToRoman(4));
        assertEquals("IX",RomanNumeralsUtil.arabicToRoman(9));
        assertEquals("XIV",RomanNumeralsUtil.arabicToRoman(14));
        assertEquals("XIX",RomanNumeralsUtil.arabicToRoman(19));
        assertEquals("XXIV",RomanNumeralsUtil.arabicToRoman(24));
        assertEquals("XL",RomanNumeralsUtil.arabicToRoman(40));
        assertEquals("XLIX",RomanNumeralsUtil.arabicToRoman(49));
        assertEquals("XC",RomanNumeralsUtil.arabicToRoman(90));
        assertEquals("XCIX",RomanNumeralsUtil.arabicToRoman(99));
        assertEquals("CD",RomanNumeralsUtil.arabicToRoman(400));
        assertEquals("CM",RomanNumeralsUtil.arabicToRoman(900));
    }
}