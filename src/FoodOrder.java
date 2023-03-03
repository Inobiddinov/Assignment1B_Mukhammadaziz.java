import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class FoodOrder {
    Scanner scan = new Scanner(System.in);
    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    Date date = new Date();
    int onePlayerPackage = 0,twoPlayerPackage = 0,threePlayerPackage = 0, choiceForPackage = 0,numOfPackage = 0,
    extraArrows = 0,drinks = 0;
    final double PRICEFORONE = 19.90,PRICEFORTWO = 39.90,PRICEFORFAMILY = 59.90;

    public void displayMenu(){
        System.out.println("Welcome to Sunway Archery");
        System.out.println((formatter.format(date)));
        System.out.println("1. One Player Package RM19.90");
        System.out.println("2. Two Players Package RM39.90");
        System.out.println("3. Family Package RM59.90");
    }




}
