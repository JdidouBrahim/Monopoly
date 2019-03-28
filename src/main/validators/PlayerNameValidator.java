package main.validators;

import main.utils.MonopolyScanner;

public class PlayerNameValidator {

    public static String  validate(String name) {
        String validName=name;
        while (validName.isEmpty() || validName.length() > 8){
            System.err.println("Name length should be between in [1-8] \nPlease Try again");
            validName = MonopolyScanner.getScanner().next();
        }
        return validName;
    }
}
