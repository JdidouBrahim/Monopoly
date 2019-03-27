public class SquareFactory {

    public static String[] names = new String[]{"Go", "White House", "Chicago Avenue", "Texas Avenue", "Utility", "College Avenue", "Burger King", "Nothing", "Holiday inn Hotel", "Go to jail", "Roll again", "Blue Mosque", "Railroads", "Luxury tax", "City Park", "Nothing", "Free Parking", "New York Avenue", "Colorado Avenue", "Income Tax", "Marvin Garden", "Nothing", "Red House", "Blue house", "Hilton hotel", "In jail", "Nothing", "Sheraton hotel", "Yellow house", "Washington Avenue", "Roll again", "Mall of arabia"};

    public static Square getSquare(int position) {
        if (position == 0) {
            return new GoSquare(names[position]);
        }
        else if (position == 4) {
            return new UtilitySquare(names[position], 100);
        }
        else if (position == 9) {
            return new JailSquare(names[position]);
        }
        else if (position == 9) {
            return new RailroadSquare(names[position], 100);
        }
        else if (position == 16) {
            return new VacationSquare(names[position]);
        }
        else if (position == 25) {
            return new GoToJailSquare(names[position]);
        }
        else if (position == 19) {
            return new IncomeTaxSquare(names[position]);
        }
        else if (position == 13) {
            return new LuxuryTaxSquare(names[position]);
        }
        else {
            return new HouseSquare(names[position] + " ", 300);
        }
    }
}
