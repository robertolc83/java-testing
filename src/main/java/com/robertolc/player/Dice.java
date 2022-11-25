package com.robertolc.player;

import java.util.Random;

public class Dice {
    private int sides;

    //Constructor
    public Dice(int sides) {
        this.sides = sides;
    }

    /**
     * Descripción: Método que simula tirar un dado
     *
     * @Param sides Parametro int que define el número de caras del dado
     * @return devuelve un número de 0 a sides
     */
    public int roll(){
        //Devuelve números random de 1 a sides
        return new Random().nextInt(sides)+1;
    }
}
