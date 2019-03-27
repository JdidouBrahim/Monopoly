package main.square;

import java.util.Random;
import main.Board;
import main.utils.MonopolyPrinter;
import main.Player;

public class VacationSquare extends Square {
    public VacationSquare(String name) {
        super(name);
    }

    @Override
    public void doAction(Player player, Board board) {
        Random rand = new Random();
        Square square = board.movePlayer(player, rand.nextInt(board.getTotalSquare()), false);
        MonopolyPrinter.print(player, player.getName() + " has go to vacation at " + square.getName());
    }
}
