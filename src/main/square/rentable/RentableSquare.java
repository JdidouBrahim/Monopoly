package main.square.rentable;

import main.Board;
import main.Player;
import main.square.Square;

public abstract class RentableSquare extends Square {

    protected int rent;

    RentableSquare(String name,int rent){
        super(name);
        this.rent=rent;
    }

    @Override
    public void doAction(Player player, Board board) {
        System.out.println(player.getName()+" Souhld pay rent :"+rent+"$");
        player.getMoney().substractMoney(rent);
    }
}
