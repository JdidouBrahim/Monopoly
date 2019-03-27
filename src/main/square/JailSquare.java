package main.square;

import main.Board;
import main.utils.MonopolyPrinter;
import main.Player;

public class JailSquare extends Square {
    public JailSquare(String name) {
        super(name);
    }

    @Override
    public void doAction(Player player, Board board) {
        MonopolyPrinter.print(player, player.getName() + " has been Jail and lost 500 money");
        player.getMoney().substractMoney(500);
        board.movePlayer(player, -player.getCurrentPosition(), false);
    }
}
