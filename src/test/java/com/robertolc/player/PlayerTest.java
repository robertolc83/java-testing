package com.robertolc.player;

import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class PlayerTest {
    @Test
    public void loses_when_dice_number_is_too_low() {
        /*Utilizamos Mockito.mock para crear un objeto de la clase Dice
        y poder controlar con Mockito sus metodos en este caso roll
        que devuelve un número aleatorio y para el caso de un test necesitamos
        tener control del resultado que va arrojar roll por esa razón creamos un mock de Dice*/
        Dice dice = Mockito.mock(Dice.class);
        //forzamos a que roll devuelva un valor de 2
        Mockito.when(dice.roll()).thenReturn(2);

        Player player = new Player(dice,3);
        assertFalse(player.play());
    }

    @Test
    public void wins_when_dice_number_is_big() {
        /*Utilizamos Mockito.mock para crear un objeto de la clase Dice
        y poder controlar con Mockito sus metodos en este caso roll
        que devuelve un número aleatorio y para el caso de un test necesitamos
        tener control del resultado que va arrojar roll por esa razón creamos un mock de Dice*/
        Dice dice = Mockito.mock(Dice.class);
        //forzamos a que roll devuelva un valor de 2
        Mockito.when(dice.roll()).thenReturn(4);

        Player player = new Player(dice,3);
        assertTrue(player.play());
    }
}