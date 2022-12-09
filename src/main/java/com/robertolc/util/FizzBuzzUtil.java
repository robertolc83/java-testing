package com.robertolc.util;

public class FizzBuzzUtil {
    /**
     * Descripción:
     * Si el número es divisible por 3, retorna “Fizz”
     * Si el número es divisible por 5, retorna “Buzz”
     * Si el número es divisible por 3 y por 5, retorna “FizzBuzz”
     * En otro caso, retorna el mismo número
     * @param n recibe un número
     * @return Retorna la cadena de acuerdo a las reglas del negocio descritas en la descripción
     */
    public static String fizzbuzz(int n){

        /*
        if(n % 3 == 0 && n % 5 == 0){
            return "fizzbuzz";
        } else if(n % 3 == 0){
            return "fizz";
        } else if(n % 5 == 0){
            return "buzz";
        } else {
            return String.valueOf(n);
        }
        */

        //Refactorizando y optimizando el código
        String result = "";
        if(n % 3 == 0) result += "fizz";
        if(n % 5 == 0) result += "buzz";

        return result.isEmpty() ? String.valueOf(n) : result;
    }
}
