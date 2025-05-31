package model;

import java.util.Random;

public class Dice {

    private int numberOfDice;

    public Dice(int numberOfDice) {
        this.numberOfDice = numberOfDice;
    }

    public int getNumberOfDice() {
        return numberOfDice;
    }

    public void setNumberOfDice(int numberOfDice) {
        this.numberOfDice = numberOfDice;
    }

    public int rollDice() {
        int diceCount = 0;
        while (numberOfDice > 0) {
            int min = 1;
            int max = 6;
            Random random = new Random();
            int randomDiceNum = random.nextInt(max - min + 1) + min;
            diceCount += randomDiceNum;
            //System.out.println(randomDiceNum);
            numberOfDice--;
        }
        //System.out.println(diceCount);
        return diceCount;
    }

    public static void main(String[] args) {
        Dice dice = new Dice(1);
        System.out.println(dice.rollDice());
    }



}
