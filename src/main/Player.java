package main;

import main.utils.MonopolyPrinter;
import main.utils.SquareFactory;

import java.util.Scanner;

public class Player {
    int id;
    String name;
    int totalWalk = 0;
    int position = 0;
    boolean brokeout = false;
    Money money = new Money(1500);

    Die die = new Die();
    Scanner scanner = new Scanner(System.in);

    public Player(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public void play(Board board){
        MonopolyPrinter.printActionMenu();
        switch ( scanner.nextInt()) {
            case 1:
               int face = this.tossDie(die);
                board.movePlayer(this, face);
                System.out.println(this.toString());
                break;
            case 2:
                MonopolyPrinter.printBoard();
                break;
            case 3:
                board.endGame();
        }
    }

    public int getTotalWalk() {
        return totalWalk;
    }

    public int tossDie(Die die) {
        int face = die.getFace();
        System.out.println(getName() + " toss a die... Face is " + face);
        return face;
    }

    public int getCurrentPosition() {
        return position;
    }

    @Override
    public String toString() {
        return String.format("*****************\n" +
                             "Name : %s\n" +
                             "Current Cell : %s\n" +
                             "Money %d\n",
                             this.name, SquareFactory.names[this.position], this.money.money);
    }

    public void setPosition(int position) {
        this.position = position;
        MonopolyPrinter.printPlayerCurrentPosition(this,SquareFactory.getSquare(position));
    }

    public void nextTurn() {
        totalWalk++;
    }

    public String getName() {
        return name;
    }

    public Money getMoney() {
        return money;
    }

    public int getID() {
        return id;
    }

    public boolean isBrokeOut() {
        return brokeout;
    }

    public void setBrokeOut(boolean brokeout) {
        this.brokeout = brokeout;
    }
}
