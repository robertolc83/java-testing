package com.robertolc.util;

public class PasswordUtil {

    public enum SecurityLevel{
        WEAK,MEDIUM,STRONG
    }

    public static SecurityLevel assessPassword(String password){

        if (password.length() < 8){
            return SecurityLevel.WEAK;
        }
        //Usamos el método matches para comparar la cadena con una expresión regular
        //[a-zA-Z]+ letras minusculas y mayusculas incluso si están repetidas
        if (password.matches("[a-zA-Z]+")){
            return SecurityLevel.WEAK;
        }
        //Validamos que cntenga letras y números varias veces
        if (password.matches("[a-zA-Z0-9]+")){
            return SecurityLevel.MEDIUM;
        }

        return SecurityLevel.STRONG;
    }
}
