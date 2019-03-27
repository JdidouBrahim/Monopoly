package main;

import main.utils.MonopolyPrinter;
import main.utils.MonopolyScanner;

import java.util.Scanner;

public class Monopoly {
    public static final int END_GAME_CHOICE = 3;
    Board board;
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
        while (choice != END_GAME_CHOICE) {
            MonopolyPrinter.choosePlayerMenu(board);
            processTurn(scanner.nextInt());
        }



		/*
        while (!isGameEnd() && !board.hasWinner()){
			if(!board.getCurrentPlayer().isBrokeOut()){
				int face = board.getCurrentPlayer().tossDie(die);
				board.movePlayer(board.getCurrentPlayer(), face);
			}
			board.nextTurn();
		}
		System.out.println("========");
		if(board.hasWinner()){
			System.out.println(board.getWinner().getName() + " is won by don't brokeout!");
		}else{
			System.out.println(board.getMaxMoneyPlayer().getName() + " is won by have most money!");
		}
		System.out.println("Game over!");
	}
	
	public boolean isGameEnd() {
		for(main.Player player:board.getPlayers()){
			if(player.getTotalWalk() < 20){ return false; }
		}
		return true;
		*/
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
        if (board.currentTurn == 0) {
            switch (choice) {
                case 1:
                    choosePlayer().play(board);
                    board.nextTurn();
                    break;
                case 2:
                    MonopolyPrinter.printBoard();
                    break;

                case 3:
                    board.endGame();
            }
        } else {
            switch (choice) {
                case 1:
                    board.getCurrentPlayer().play(board);
                    board.nextTurn();
                    break;
                case 2:
                    player = board.getSecondPlayer();
                    System.out.println(player.toString());
                    player.play(board);
                    board.nextTurn();
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
        String players = "";
        MonopolyPrinter.printPlayersChoices(board);
        board.currentPlayer =  scanner.nextInt();
        Player selectedPlayer = board.getCurrentPlayer();
        System.out.println(selectedPlayer.toString());
        return selectedPlayer;
    }

}
