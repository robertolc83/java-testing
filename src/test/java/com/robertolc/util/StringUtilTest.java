package com.robertolc.util;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class StringUtilTest {
    /**
     * Método test que valida una iteración
     */
    @Test
    public void repeat_string_once() {
        Assert.assertEquals("hola", StringUtil.repeat("hola",1));
    }
    /**
     * Método test que valida una n iteraciones
     */
    @Test
    public void repeat_string_multiple_times() {
        Assert.assertEquals("holaholahola", StringUtil.repeat("hola",3));
    }
    /**
     * Método test que valida 0 iteraciones
     */
    @Test
    public void repeat_string_zero_times() {
        Assert.assertEquals("", StringUtil.repeat("hola",0));
    }
    /**
     * Método test que valida si times es un número negativo
     * donde le indicamos a la etiqueta @Test que esperamos una excepción de tipo
     * IllegalArgument
     */
    @Test(expected = IllegalArgumentException.class)
    public void repeat_string_negative_times() {
        StringUtil.repeat("hola",-1);
    }

    @Test
    public void return_false_if_string_is_not_empty() {
        assertFalse(StringUtil.isEmpty(" palabra "));
    }

    @Test
    public void return_true_if_string_is_empty() {
        assertTrue(StringUtil.isEmpty(""));
    }

    @Test
    public void return_true_if_string_have_spaces() {
        assertTrue(StringUtil.isEmpty("   "));
    }

    @Test
    public void return_true_if_string_is_null() {
        assertTrue(StringUtil.isEmpty(null));
    }
}