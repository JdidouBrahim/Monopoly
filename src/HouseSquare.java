import java.util.Scanner;

public class HouseSquare extends Square {

    public static final String YES = "Y";
    int price;
    int owner = -1;
    Scanner scanner = new Scanner(System.in);

    public HouseSquare(String name, int price) {
        super(name);
        this.price = price;
    }

    @Override
    public void doAction(Player player, Board board) {
        String playerChoice;
        if (owner < 0) {
            System.out.println("To buy " + getName() + " Please Enter Y");
            playerChoice = scanner.next();

            if (YES.equals(playerChoice)) {
                System.out.println(player.getName() + " buy " + getName() + " for " + price);
                owner = player.getID();
                player.getMoney().substractMoney(price);
            } else {
                System.out.println(player.getName() + " don't want to buy " + getName());
            }
        } else {
            if (owner != player.getID()) {
                int lost = price * 70 / 100;
                MonopolyPrinter.print(player, player.getName() + " lost " + lost + " money to " + board.getPlayer(owner).getName());
                player.getMoney().substractMoney(lost);
                board.getPlayer(owner).getMoney().addMoney(lost);
            } else {
                System.out.println("You already own this Square");
            }
        }
    }

    public void setOwner(int owner) {
        this.owner = owner;
    }

    public int getPrice() {
        return price;
    }
}
