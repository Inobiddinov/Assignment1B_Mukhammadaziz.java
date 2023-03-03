import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class FoodOrder {
    Scanner scan = new Scanner(System.in);
    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    Date date = new Date();
    int choosenPackage = 0, numOfPackage = 0,addArrows = 0,
            extraArrows = 0, drinks = 0,reOrder = 0;
    final double PRICEFORONE = 19.90, PRICEFORTWO = 39.90, PRICEFORFAMILY = 59.90,PRICEFORDRINK = 2,
            PRICEFORARROW = 10;
    double total =0, packagePrice =0, sst = 0,additionalItems = 0;

    public void displayMenu() {
        System.out.println("Welcome to Sunway Archery");
        System.out.println((formatter.format(date)));
        System.out.println("1. One Player Package [RM19.90]");
        System.out.println("2. Two Players Package [RM39.90]");
        System.out.println("3. Family Package [RM59.90]");
    }

    public void order() {
        while (true) {
            System.out.print("Enter Your Choice[1-3] ");
            choosenPackage = scan.nextInt();
            switch (choosenPackage) {
                case 1 : {
                    System.out.println("You have Selected One Player Package\n");
                    System.out.println("Enter number of package: ");
                    numOfPackage = scan.nextInt();
                    System.out.println("Do you want to add extra arrows[1-yes , 2-no] : ");
                    addArrows = scan.nextInt();
                    System.out.println("How many arrows do you want to add [10-arrows [RM10]]: ");
                    extraArrows = scan.nextInt();
                    System.out.println("How many drinks you want to buy[RM2 per person]: ");
                    drinks = scan.nextInt();
                    packagePrice =(numOfPackage * PRICEFORONE);
                    additionalItems = (addArrows *PRICEFORARROW)+(drinks*PRICEFORDRINK);
                    sst = ((packagePrice + additionalItems) % 6);
                    total =(packagePrice + additionalItems +sst);
                }
                case 2 : {
                    System.out.println("You have Selected Two Player Package\n");
                    System.out.println("Enter number of package: ");
                    numOfPackage = scan.nextInt();
                    System.out.println("Do you want to add extra arrows[1-yes , 2-no] : ");
                    addArrows = scan.nextInt();
                    System.out.println("How many arrows do you want to add [10-arrows [RM10]]: ");
                    extraArrows = scan.nextInt();
                    System.out.println("How many drinks you want to buy[RM2 per person]: ");
                    drinks = scan.nextInt();
                    packagePrice =(numOfPackage * PRICEFORTWO);
                    additionalItems = (addArrows *PRICEFORARROW)+(drinks*PRICEFORDRINK);
                    sst = ((packagePrice + additionalItems) % 6);
                    total =(packagePrice + additionalItems +sst);
                }
                case 3 : {
                    System.out.println("You have Selected Family Package\n");
                    System.out.println("Enter number of package: ");
                    numOfPackage = scan.nextInt();
                    System.out.println("Do you want to add extra arrows[1-yes , 2-no] : ");
                    addArrows = scan.nextInt();
                    System.out.println("How many arrows do you want to add [10-arrows [RM10]]: ");
                    extraArrows = scan.nextInt();
                    System.out.println("How many drinks you want to buy[RM2 per person]: ");
                    drinks = scan.nextInt();
                    packagePrice =(numOfPackage * PRICEFORFAMILY);
                    additionalItems = (addArrows * PRICEFORARROW)+(drinks * PRICEFORDRINK);
                    sst = ((packagePrice + additionalItems) % 6);
                    total =(packagePrice + additionalItems +sst);
                }
                default : break;
            }
            System.out.println();
            do {
                System.out.print("Do you wish to order anything else [1 - 2] : ");
                reOrder = scan.nextInt();
                if (reOrder == 1) {
                    order();
                } else if (reOrder == 2) {
                    generateBill();
                    System.exit(1);
                } else {
                    System.out.println("Invalid Choice");
                }
            }while(reOrder == 1 || reOrder == 2);

        }
    }
    public void generateBill()
    {
        System.out.println();
        System.out.println("***************** Thankyou for ordering ******************");
        System.out.println("****************Your Bill is : " +total+"*****************");
    }

}