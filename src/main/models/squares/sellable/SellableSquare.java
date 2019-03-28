package main.models.squares.sellable;

import java.util.Scanner;
import main.Board;
import main.models.squares.Square;
import main.utils.MonopolyPrinter;
import main.Player;

public  class SellableSquare extends Square {

    int price;
    int rent ;
    int owner = -1;
    Scanner scanner = new Scanner(System.in);

    public SellableSquare(String name, int price,int rent) {
        super(name);
        this.price = price;
        this.rent=rent;
    }

    @Override
    public void doAction(Player player, Board board) {
        if (owner < 0) {
            System.out.println("To buy " + getName() + " Please Enter Y - Otherwise press N");

            if ("Y".equalsIgnoreCase( scanner.next())) {
                System.out.println(player.getName() + " buy " + getName() + " for " + price);
                owner = player.getID();
                player.getMoney().substractMoney(price);
            } else {
                System.out.println(player.getName() + " don't want to buy " + getName());
            }
        } else {
            if (owner != player.getID()) {
                int lost = rent;
                MonopolyPrinter.print(player, player.getName() + " lost " + lost + " money to " + board.getPlayer(owner).get().getName());
                player.getMoney().substractMoney(lost);
                board.getPlayer(owner).get().getMoney().addMoney(lost);
            } else {
                System.out.println("You own the cell . No action is needed");
            }
        }
    }

    public void setOwner(int owner) {
        this.owner = owner;
    }

    public int getPrice() {
        return price;
    }
}
