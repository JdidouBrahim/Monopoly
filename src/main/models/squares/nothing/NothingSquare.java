package main.models.squares.nothing;

import main.Board;
import main.Player;
import main.models.squares.Square;

public class NothingSquare extends Square {

    public NothingSquare(String name) {
        super(name);
    }

    @Override
    public void doAction(Player player, Board board) {
        System.out.println("Nothing to do ....");
    }
}
