package main.models.squares;


import main.Board;
import main.utils.MonopolyPrinter;
import main.Player;

public class GoSquare extends Square {
    public GoSquare(String name) {
        super(name);
    }

    @Override
    public void doAction(Player player, Board board) {
        MonopolyPrinter.print(player, player.getName() + " is at Go... Giving 200$");
        player.getMoney().addMoney(200);
    }
}
