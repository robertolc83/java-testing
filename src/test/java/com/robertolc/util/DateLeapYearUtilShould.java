package com.robertolc.util;


import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class DateLeapYearUtilShould {
    /*
    Todos los años divisibles por 400 son bisiestos (1600, 2000, 2400)
    Todos los años divisibles por 100 pero NO por 400 NO son bisiestos (1700, 1800, 1900)
    Todos los años divisibles por 4 son bisiestos pero no por 100 (1996, 2004, 2012)
    Todos los años que NO son divisibles por 4 NO son bisiestos (2017, 2018, 2019)
     */

    @Test
    public void return_true_when_year_is_divisible_by_400() {
        assertThat(DateLeapYearUtil.isLeapYear(1600), is(true));
        assertThat(DateLeapYearUtil.isLeapYear(2000), is(true));
        assertThat(DateLeapYearUtil.isLeapYear(2400), is(true));
    }

    @Test
    public void return_false_when_year_is_divisible_by_100_but_not_by_400() {
        assertThat(DateLeapYearUtil.isLeapYear(1700), is(false));
        assertThat(DateLeapYearUtil.isLeapYear(1800), is(false));
        assertThat(DateLeapYearUtil.isLeapYear(1900), is(false));
    }

    @Test
    public void return_true_when_year_is_divisible_by_4_but_not_by_100() {
        assertThat(DateLeapYearUtil.isLeapYear(1996), is(true));
        assertThat(DateLeapYearUtil.isLeapYear(2004), is(true));
        assertThat(DateLeapYearUtil.isLeapYear(2012), is(true));
    }

    @Test
    public void return_false_when_year_is_not_divisible_by_4() {
        assertThat(DateLeapYearUtil.isLeapYear(2017), is(false));
        assertThat(DateLeapYearUtil.isLeapYear(2018), is(false));
        assertThat(DateLeapYearUtil.isLeapYear(2019), is(false));
    }
}