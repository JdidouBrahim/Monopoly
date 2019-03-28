package main.services.impl;

import main.Board;
import main.Die;
import main.Player;
import main.models.squares.Square;
import main.services.BoardService;
import main.services.PlayerService;
import main.utils.MonopolyPrinter;
import main.utils.MonopolyScanner;
import main.validators.PlayerNameValidator;

public class DefaultPlayerService implements PlayerService {

    private Die die = new Die();
    private BoardService boardService = new DefaultBoardService();

    @Override
    public void play(Board board) {
            MonopolyPrinter.printActionMenu();
            switch (MonopolyScanner.getScanner().nextInt()) {
                case 1:
                    // you can fix the face value heire for test
                    int face =die.toss();
                    movePlayer(board.getCurrentPlayer(),board, face);
                    System.out.println(board.getCurrentPlayer().toString());
                    break;
                case 2:
                    MonopolyPrinter.printBoard();
                    break;
                case 3:
                    board.endGame();
        }
    }

    @Override
    public Player[] readPlayersInformations(int totalPlayers) {
        Player[] players = new Player[totalPlayers];
        for (int i = 0; i < totalPlayers; i++) {
            try {
                System.out.printf("Enter Player %s Name :", players.length > 1 ? i + 1 : "");
                String name = PlayerNameValidator.validate(MonopolyScanner.getScanner().next());
                players[i] = new Player(i+1, name);
            } catch (Exception e) {
                System.err.println("Please Enter a valid name" + e.getMessage());
                return null;
            }
        }
        return players;
    }

    public Square movePlayer(Player player,Board board, int face) {
        return movePlayer(player,board, face, true);
    }

    public Square movePlayer(Player player,Board board, int face, boolean count) {
        if (player.isBrokeOut()) {
            return board.getSquares()[player.getCurrentPosition()];
        }
        int currentPosition = player.getCurrentPosition();
        int newPosition = board.normalizePosition(currentPosition + face);
        player.setPosition(newPosition);
        if(!fromJailToGO(currentPosition,newPosition)){
            board.getSquares()[newPosition].doAction(player, board);
        }
        if (player.getMoney().isBrokeOut()) {
            MonopolyPrinter.print(player, player.getName() + " has been broke out!");
            player.setBrokeOut(true);
        } else {
            if (count) {
                player.nextTurn();
            }
        }
        return board.getSquares()[newPosition];
    }
    @Override
    public void printPlayersInformations(Board board) {
        for(Player player : board.getPlayers()){
            System.out.println(player.toString());
        }
    }

    private boolean fromJailToGO(int currentPosition,int newPosition) {
        return currentPosition ==9 && newPosition==0;
    }

}
