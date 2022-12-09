package com.robertolc.util;

import com.robertolc.enums.RomanNumeral;

import javax.jws.soap.SOAPBinding;
import java.util.Arrays;
import java.util.List;

public class RomanNumeralsUtil {
    /**
     * Descripción: Método que convierte un número arábigo a romano.
     * @param n recibe un número aábigo
     * @return Regresa un número romano
     */
    public static String arabicToRoman(int n){


        StringBuilder collator = new StringBuilder();
        //Obtenemos la lista de los enum
        //[M, CM, D, CD, C, XC, L, XL, X, IX, V, IV, I]
        List<RomanNumeral> romanNumerals = RomanNumeral.getRomanNumerals();


        //Valida que el número sea menor a 4000 debido a que el formato cambia
        if (n > 0 && n < 4000) {

            int i = 0;
            while (n > 0 && i < romanNumerals.size()){

                //Recorremos la lista de romanNumerals por posición
                //[M, CM, D, CD, C, XC, L, XL, X, IX, V, IV, I]
                RomanNumeral currentRoman = romanNumerals.get(i);

                //validamos si el número es mayor o igual al valor del enum ejemplo M = 1000
                if(n >= currentRoman.getValue()){

                    //Se asigna el valor de currentRoman a collator
                    collator.append(currentRoman);

                    //se resta a n el valor del currentRoman porque ya fue asignado
                    n -= currentRoman.getValue();
                } else {
                    i++;
                }
            }
            //System.out.println(collator.toString());
            String roman = collator.toString();

            return roman;

        } else {
            throw new IllegalArgumentException(n + "no está en el rango (0-4000)");
        }
    }
}
