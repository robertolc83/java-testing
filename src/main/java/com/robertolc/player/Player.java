package com.robertolc.player;

public class Player {
    private Dice dice;
    private int minNumberToWin;

    //Constructor
    public Player(Dice dice, int minNumberToWin) {
        this.dice = dice;
        this.minNumberToWin = minNumberToWin;
    }

    /**
     * Descripción: Método que simula que un jugador tira un dado que devuelve un número aleatorio
     * y compara el número del dado con el parametro minNumberToWIn
     * @return regresa un true o false si el dado es menos a minNumberToWin
     */
    public boolean play(){
        int diceNumber = this.dice.roll();
        return diceNumber > this.minNumberToWin;
    }
}
