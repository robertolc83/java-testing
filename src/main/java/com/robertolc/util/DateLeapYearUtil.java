package com.robertolc.util;

public class DateLeapYearUtil {
    /**
     * Descripción: Método que calcula si un año es bisiesto
     * @param year
     * @return
     */
    public static boolean isLeapYear(int year){
        //Validamos que sea divisible por 4 pero no por 100
        //Validamos si el año es divisible por 400
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
}
