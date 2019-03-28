package main.models.squares.tax;

import main.Board;
import main.Player;
import main.models.squares.Square;

public abstract class TaxSquare extends Square {

    protected int tax;

    public TaxSquare(String name,int tax) {
        super(name);
        this.tax=tax;
    }

    @Override
    public void doAction(Player player, Board board) {
        System.out.println(player.getName() + " have to pay "+tax+"$ to the bank");
        player.getMoney().substractMoney(tax);
    }
}
