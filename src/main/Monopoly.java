package main;

import main.services.BoardService;
import main.services.impl.DefaultBoardService;
import main.services.impl.DefaultPlayerService;
import main.services.PlayerService;
import main.utils.MonopolyPrinter;
import main.utils.MonopolyScanner;

import java.util.Scanner;

public class Monopoly {

    public static final int END_GAME_CHOICE = 3;
    Board board;
    private PlayerService playerService = new DefaultPlayerService();
    private BoardService boardService=new DefaultBoardService();
    Scanner scanner = MonopolyScanner.getScanner();

    public Monopoly(int totalPlayers) {
        board = new Board(totalPlayers);
    }

    public static void main(String[] args) {
        System.out.println("\t************ Monopoly ************\n");
        int totalPlayers = getNumberOfPlayers();
        Monopoly game = new Monopoly(totalPlayers);
        game.startGame();
    }

    public void startGame() {
        int choice = 100;
        while (choice != END_GAME_CHOICE && (!isGameEnd() || boardService.hasWinner(board))) {
            MonopolyPrinter.choosePlayerMenu(board);
            processTurn(scanner.nextInt());
        }
        System.out.println("Game Over ... Winner is "+boardService.getWinner(board).getName());
    }

    public boolean isGameEnd() {
        for (main.Player player : board.getPlayers()) {
            if (player.getRounds()>= 2 ) {
                return true;
            }
        }
        return false;
    }



    private static int getNumberOfPlayers() {
        int totalPlayers = 0;
        while (totalPlayers < 1 || totalPlayers > 2) {
            try {
                System.out.println("\t How many people are playing?");
                System.out.print("\t Players (1 - 2): ");
                totalPlayers = MonopolyScanner.getScanner().nextInt();
            } catch (Exception e) {
                System.err.println("Error: Number too large.");
                continue;
            }
            if (totalPlayers > 2) {
                System.err.println("Maximum number of players is 2");
            }
            if (totalPlayers < 1) {
                System.err.println("Minimum number of players is 1");
            }
        }
        return totalPlayers;
    }

    private void processTurn(int choice) {
        Player player;
        if (board.isFirstTurn()) {
            switch (choice) {
                case 1:
                    choosePlayer();
                    playerService.play(board);
                    break;
                case 2:
                    MonopolyPrinter.printBoard();
                    break;

                case 3:
                    board.endGame();
            }
            board.setFirstTurn(Boolean.FALSE);
        } else {
            switch (choice) {
                case 1:
                    playerService.play(board);
                    break;
                case 2:
                    player = board.getSecondPlayer();
                    System.out.println(player.toString());
                    playerService.play(board);

                    break;
                case 3:
                    MonopolyPrinter.printBoard();
                    break;

                case 4:
                    board.endGame();
                    break;
            }
        }
    }


    private Player choosePlayer() {
        MonopolyPrinter.printPlayersChoices(board);
        board.setCurrentPlayer(scanner.nextInt());
        Player selectedPlayer = board.getCurrentPlayer();
        System.out.println(selectedPlayer.toString());
        return selectedPlayer;
    }

}
