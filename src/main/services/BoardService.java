package main.services;

import main.Board;
import main.Player;

public interface BoardService {

    void fill(Board board);
    boolean hasWinner(Board board);
    Player getWinner(Board board);
}
