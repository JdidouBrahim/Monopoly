import java.util.Scanner;

public class MonopolyScanner {

    private static Scanner scanner;

    public static Scanner getScanner(){
        if (scanner == null){
            return scanner=new Scanner(System.in);
        }
        return scanner;
    }
}
