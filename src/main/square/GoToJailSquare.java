package main.square;

import main.Board;
import main.utils.MonopolyPrinter;
import main.Player;

public class GoToJailSquare extends Square {
    public GoToJailSquare(String name) {
        super(name);
    }

    @Override
    public void doAction(Player player, Board board) {
        MonopolyPrinter.print(player, player.getName() + " has go to Jail");
        board.movePlayer(player, -player.getCurrentPosition(), false);
    }
}
