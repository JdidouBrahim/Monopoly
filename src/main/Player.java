package main;

import main.utils.MonopolyPrinter;
import main.utils.SquareFactory;

public class Player {

    private int id;
    private String name;
    private int totalWalk = 0;
    private int position = 0;
    private int rounds=0;
    private boolean brokeout = false;
    private Money money = new Money(1500);

    public Player(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getTotalWalk() {
        return totalWalk;
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
        this.position  = this.position+position;
        if(this.position > SquareFactory.names.length ){
            System.out.println(getName()+" passes through the GO cell and earned 200$\nCurrent Credit : "+this.getMoney().money);
            getMoney().addMoney(200);
            this.position=Math.abs(position - SquareFactory.names.length);
            ++rounds;
        }
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

    public int getRounds() {
        return rounds;
    }

    public void setRounds(int rounds) {
        this.rounds = rounds;
    }
}
