public class IncomeTaxSquare extends Square {

    public IncomeTaxSquare(String name) {
        super(name);
    }

    @Override
    public void doAction(Player player, Board board) {
        MonopolyPrinter.print(player, player.getName() + " have to pay 100$ to the bank");
        player.getMoney().substractMoney(100);
    }
}
