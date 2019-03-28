package main.services.impl;

import main.Board;
import main.Player;
import main.models.squares.Square;
import main.services.BoardService;
import main.services.PlayerService;
import main.utils.MonopolyScanner;
import main.utils.SquareFactory;

public class DefaultBoardService implements BoardService{

    @Override
    public void fill(Board board) {
        int squaresCount = board.getSquares().length;
        Square[] squares = new Square[squaresCount];
        for (int i = 0; i < squaresCount; i++) {
            squares[i] = SquareFactory.getSquare(i);
        }
        board.setSquares(squares);
    }

    @Override
    public boolean hasWinner(Board board) {
        int ingame = 0;
        for (Player player : board.getPlayers()) {
            if (!player.isBrokeOut()) {
                ingame++;
            }
        }
        return ingame <= 1;
    }

    @Override
    public Player getWinner(Board board) {
        for (Player player : board.getPlayers()) {
            if (!player.isBrokeOut()) {
                return player;
            }
        }
        return getMaxMoneyPlayer(board);
    }

    private Player getMaxMoneyPlayer(Board board) {
        Player maxplayer = null;
        for (Player player : board.getPlayers()) {
            if (maxplayer == null || maxplayer.getMoney().getMoney() < player.getMoney().getMoney()) {
                maxplayer = player;
            }
        }
        return maxplayer;
    }
}
