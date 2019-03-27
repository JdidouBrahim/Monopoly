import java.util.Arrays;
import java.util.Scanner;

public class Board {
    int currentTurn = 0;
    int currentPlayer;
    int totalPlayers = 0;
    Player[] players;
    Square[] squares = new Square[32];

    Scanner scanner = new Scanner(System.in);

    public Board(int totalPlayers) {
        players = new Player[totalPlayers];
        this.totalPlayers = totalPlayers;
        getPlayersInformations();
        fillBoard();
    }

    private void fillBoard() {
        for (int i = 0; i < squares.length; i++) {
                squares[i] = SquareFactory.getSquare(i);
        }
    }

    private void getPlayersInformations() {
        for (int i = 0; i < players.length; i++) {
            try {
                System.out.printf("Enter Player %s Name :", players.length > 1 ? i + 1 : "");
                players[i] = new Player(i, scanner.next());
            } catch (Exception e) {
                System.err.println("Please Enter a valid name" + e.getMessage());
                return;
            }
        }
    }

    public Square movePlayer(Player player, int face) {
        return movePlayer(player, face, true);
    }

    public Square movePlayer(Player player, int face, boolean count) {
        if (player.isBrokeOut()) {
            return squares[player.getCurrentPosition()];
        }
        int newPosition = normalizePosition(player.getCurrentPosition() + face);
        player.setPosition(newPosition);
        MonopolyPrinter.printPlayerCurrentPosition(player,squares[newPosition]);
        squares[newPosition].doAction(player, this);
        if (player.getMoney().isBrokeOut()) {
            MonopolyPrinter.print(player, player.getName() + " has been broke out!");
            player.setBrokeOut(true);
        } else {
            if (count) {
                player.nextTurn();
            }
        }
        return squares[newPosition];
    }

    public void endGame() {
        printPlayersInformations();
        System.out.println("Enter 'Y' to end the game ");
        if ("Y".equals(scanner.next())) {
            System.exit(0);
        }
    }

    public void printPlayersInformations(){
        for(Player player : Arrays.asList(players)){
            System.out.println(player.toString());
        }
    }

    public boolean hasWinner() {
        int ingame = 0;
        for (Player player : players) {
            if (!player.isBrokeOut()) {
                ingame++;
            }
        }
        return ingame <= 1;
    }

    public Player getWinner() {
        if (!hasWinner()) {
            return null;
        }
        for (Player player : players) {
            if (!player.isBrokeOut()) {
                return player;
            }
        }
        return null;
    }

    public Player getMaxMoneyPlayer() {
        Player maxplayer = null;
        for (Player player : players) {
            if (maxplayer == null || maxplayer.getMoney().getMoney() < player.getMoney().getMoney()) {
                maxplayer = player;
            }
        }
        return maxplayer;
    }

    public int normalizePosition(int position) {
        return position % squares.length;
    }

    public Player getCurrentPlayer() {
        return players[currentPlayer==0?currentPlayer : currentPlayer-1];
    }
    public Player getSecondPlayer() {
        int index = currentTurn == 1 ? 2 : 1;
        return players[index-1];
    }


    public Player[] getPlayers() {
        return players;
    }

    public void nextTurn() {
       ++currentTurn;
    }

    public Player getPlayer(int id) {
        return players[id];
    }

    public int getTotalSquare() {
        return squares.length;
    }
}
