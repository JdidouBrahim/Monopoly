package main;

import java.util.Random;


public class Die {

    public int toss() {
        int face = getFace();
        System.out.println("Toss a die... Face is " + face);
        return face;
    }

    public int getFace() {
        Random rand = new Random();
        int face = 1 + rand.nextInt(6);
        return face;
    }
}
