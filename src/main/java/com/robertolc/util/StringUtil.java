package com.robertolc.util;

public class StringUtil {

    /**
     * Descripción: Método que concatena un texto n veces
     * @param str: Recibe la cadena de texto
     * @param times: Recibe el número de veces
     * @return Devuelve str repetido por el valor de times.
     */
    public static String repeat(String str, int times){

        //Creamos una exception de tipo IllegarArgument cuando times sea un número negativo
        if (times < 0){
            throw new IllegalArgumentException("negative times not allowed");
        }
        String result = "";
        for (int i = 0; i < times; i++) {
            //Concatenamos str
            result  += str;
        }
        return result;
    }

    public static boolean isEmpty(String str){
        return str == null || str.trim().length() == 0;
    }
}
