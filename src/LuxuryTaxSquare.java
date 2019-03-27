public class LuxuryTaxSquare extends Square {

    public LuxuryTaxSquare(String name) {
        super(name);
    }

    @Override
    public void doAction(Player player, Board board) {
        MonopolyPrinter.print(player, player.getName() + " have to pay 200$ to the bank");
        player.getMoney().substractMoney(200);
    }
}
