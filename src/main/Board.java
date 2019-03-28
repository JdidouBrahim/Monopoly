package main;

import main.models.squares.Square;
import main.services.BoardService;
import main.services.PlayerService;
import main.services.impl.DefaultBoardService;
import main.services.impl.DefaultPlayerService;
import main.utils.MonopolyScanner;

import java.util.Arrays;
import java.util.Optional;

public class Board {

    private boolean isFirstTurn = true;
    private int currentPlayer;
    private int totalPlayers = 0;
    private Player[] players;
    private Square[] squares = new Square[32];
    private PlayerService playerService;
    private BoardService boardService;

    public Board(int totalPlayers) {
        playerService= new DefaultPlayerService();
        boardService = new DefaultBoardService();
        this.totalPlayers=totalPlayers;
        players = playerService.readPlayersInformations(totalPlayers);
        boardService.fill(this);
    }

    public void endGame(){
        playerService.printPlayersInformations(this);
        System.out.println("Enter 'Y' to end the game ");
        if ("Y".equalsIgnoreCase(MonopolyScanner.getScanner().next())) {
            System.exit(0);
        }
    }

    public int normalizePosition(int position) {
        return position % squares.length;
    }

    public Player getCurrentPlayer() {
        return players[currentPlayer==0?currentPlayer : currentPlayer-1];
    }

    public Player getSecondPlayer() {
        currentPlayer = getCurrentPlayer().getID() == 1 ? 2 : 1;
        return getCurrentPlayer();
    }


    public Player[] getPlayers() {
        return players;
    }

    public Optional<Player> getPlayer(int id){
       return Arrays.stream(players).filter(player -> player.getID()==id).findFirst();
    }

    public int getTotalSquare() {
        return squares.length;
    }

    public boolean isFirstTurn() {
        return isFirstTurn;
    }

    public void setFirstTurn(boolean firstTurn) {
        isFirstTurn = firstTurn;
    }

    public void setCurrentPlayer(int currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public int getTotalPlayers() {
        return totalPlayers;
    }

    public void setTotalPlayers(int totalPlayers) {
        this.totalPlayers = totalPlayers;
    }

    public void setPlayers(Player[] players) {
        this.players = players;
    }

    public Square[] getSquares() {
        return squares;
    }

    public void setSquares(Square[] squares) {
        this.squares = squares;
    }
}
