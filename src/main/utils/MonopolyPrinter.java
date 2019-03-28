package main.utils;

import main.Board;
import main.Player;
import main.models.squares.Square;

public class MonopolyPrinter {

    public static void print(Player player, String msg) {
        System.out.println(" [Turn" + (player.getTotalWalk() + 1) + "] \n " +
                "[Position : " + player.getCurrentPosition() + "] \n" +
                "[Credit $" + player.getMoney().getMoney() + "] \n" +
                msg + "\n");
    }

    public static void printPlayerCurrentPosition(Player player, Square square) {
        System.out.printf("Celle : %s \nOwner : %s\n", square.getName(), player.getName());
    }

    public static void choosePlayerMenu(Board board) {
        String menu;
        if (board.isFirstTurn()) {
            menu = String.format("***********************\n" +
                    "1)Select a player to play\n" +
                    "2)Show the board\n" +
                    "3)End the game");
        } else {
            menu = String.format("***********************\n" +
                    "1) Play again\n");
            if(board.getTotalPlayers()>1){
                menu = menu.concat("2) Second Player\n");
            }
             menu = menu.concat(
                    "3) Show the board\n" +
                    "4) End the game");
        }
        System.out.println(menu);
    }

    public static void printPlayersChoices(Board board){
        String result="";
        for (int i = 0; i < board.getPlayers().length; i++) {
            result = result.concat(i + 1 + ": " + board.getPlayers()[i].getName() + "\n");
        }
         if(!result.isEmpty()) System.out.println("Please select a player : \n" + result);
    }

    public static void printActionMenu() {
        System.out.println("***********************\n" +
                "1) Roll a dice\n" +
                "2) Show the board\n" +
                "3) End the game");
    }

    public static void nextTurnMenu() {
        System.out.println("1) Play again\n" +
                "2) Second Player\n" +
                "3) Show the board\n" +
                "4) End the game");
    }

    public static void printBoard(){
        System.out.println("" +
                 "_______________________________________________________________________________________________________________________________\n"+
                "|                  |  White    |  Chicago  |   Texas   |           |  College  |  Burger  |          |  Holiday |               |\n"+
                "|      Go  -->     |  House    |  Avenue   |   Avenue  |  Utility  |  Avenue   |  King    |  Nothing |    in    |   Go to jail  |\n" +
                "|__________________|___________|___________|___________|___________|___________|__________|__________|___Hotel__|_______________|\n" +
                "|    Mall of       |                                                                                            |               |\n"+
                "|    Arabia        |                                                                                            |   Roll again  |\n" +
                "|__________________|                                                                                            |_______________|\n" +
                "|                  |                                                                                            |               |\n"+
                "|    Roll again    |                                                                                            |   Blue Mosque |\n" +
                "|__________________|                                                                                            |_______________|\n" +
                "|   Washington     |                                                                                            |               |\n"+
                "|    Avenue        |                                                                                            |   Railsroad   |\n" +
                "|__________________|                                                                                            |_______________|\n" +
                "|                  |                                                                                            |               |\n"+
                "|   Yellow house   |                                                                                            |   Luxury Tax  |\n" +
                "|__________________|                                                                                            |_______________|\n" +
                "|                  |                                                                                            |               |\n"+
                "|   Sheraton hotel |                                                                                            |   City Park   |\n" +
                "|__________________|                                                                                            |_______________|\n" +
                "|                  |                                                                                            |               |\n"+
                "|   Nothing        |                                                                                            |   Nothing     |\n" +
                "|__________________|____________________________________________________________________________________________|_______________|\n" +
                "|                  |   Hilton  |    Blue   |    Red    |           |  Marvin   |   Income | Colorado | New York |    Free       |\n"+
                "|   In Jail        |   hotel   |    House  |    House  |  Nothing  |  Garden   |   Tax    | Avenue   | Avenue   |    Parking    |\n" +
                "|__________________|___________|___________|___________|___________|___________|__________|__________|__________|_______________|\n");

    }
}
