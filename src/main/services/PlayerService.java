package main.services;

import main.Board;
import main.Player;
import main.models.squares.Square;

public interface PlayerService {

    void play(Board board);
    Player[] readPlayersInformations(int totalPlayers);
    void printPlayersInformations(Board board);
    Square movePlayer(Player player, Board board, int face, boolean count);
}
