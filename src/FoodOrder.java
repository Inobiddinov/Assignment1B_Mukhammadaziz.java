import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class FoodOrder {
    Scanner scan = new Scanner(System.in);
    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    Date date = new Date();
    int choosenPackage = 0, numOfPackage = 0,addArrows = 0,
            extraArrows = 0, drinks = 0,reOrder = 0,arrowForPackage = 0,extraArr= 0;
    final double PRICEFORONE = 19.90, PRICEFORTWO = 39.90, PRICEFORFAMILY = 59.90,PRICEFORDRINK = 2,
            PRICEFORARROW = 10;
    double total =0, packagePrice =0, sst = 0,additionalItems = 0;
    String packageForDisplay =null;

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
                    if(addArrows != 2){
                    System.out.println("How many arrows do you want to add [10-arrows [RM10]]: ");
                    extraArrows = scan.nextInt();}
                    System.out.println("How many drinks you want to buy[RM2 per person]: ");
                    drinks = scan.nextInt();
                    packagePrice =(numOfPackage * PRICEFORONE);
                    additionalItems = (addArrows *PRICEFORARROW)+(drinks*PRICEFORDRINK);
                    sst = ((packagePrice + additionalItems) % 6);
                    total =(packagePrice + additionalItems +sst);
                    packageForDisplay = "one-player package *"+numOfPackage;
                    arrowForPackage = 20;
                    extraArr = (int) (extraArrows * PRICEFORARROW);
                    arrowForPackage = arrowForPackage + extraArr;

                }
                case 2 : {
                    System.out.println("You have Selected Two Player Package\n");
                    System.out.println("Enter number of package: ");
                    numOfPackage = scan.nextInt();
                    System.out.println("Do you want to add extra arrows[1-yes , 2-no] : ");
                    addArrows = scan.nextInt();
                    if(addArrows != 2){
                    System.out.println("How many arrows do you want to add [10-arrows [RM10]]: ");
                    extraArrows = scan.nextInt();}
                    System.out.println("How many drinks you want to buy[RM2 per person]: ");
                    drinks = scan.nextInt();
                    packagePrice =(numOfPackage * PRICEFORTWO);
                    additionalItems = (addArrows *PRICEFORARROW)+(drinks*PRICEFORDRINK);
                    sst = ((packagePrice + additionalItems) % 6);
                    total =(packagePrice + additionalItems +sst);
                    packageForDisplay = "two-player package *"+numOfPackage;
                    arrowForPackage = 50;
                    extraArr = (int) (extraArrows * PRICEFORARROW);
                    arrowForPackage = arrowForPackage + extraArr;


                }
                case 3 : {
                    System.out.println("You have Selected Family Package\n");
                    System.out.println("Enter number of package: ");
                    numOfPackage = scan.nextInt();
                    System.out.println("Do you want to add extra arrows[1-yes , 2-no] : ");
                    addArrows = scan.nextInt();
                    if(addArrows != 2){
                    System.out.println("How many arrows do you want to add [10-arrows [RM10]]: ");
                    extraArrows = scan.nextInt();}
                    System.out.println("How many drinks you want to buy[RM2 per person]: ");
                    drinks = scan.nextInt();
                    packagePrice =(numOfPackage * PRICEFORFAMILY);
                    additionalItems = (extraArrows * PRICEFORARROW)+(drinks * PRICEFORDRINK);
                    sst = ((packagePrice + additionalItems) % 6);
                    total =(packagePrice + additionalItems +sst);
                    packageForDisplay = "Family package *"+numOfPackage;
                    arrowForPackage = 100;
                    extraArr = (int) (extraArrows * PRICEFORARROW);
                    arrowForPackage = arrowForPackage + extraArr;
                }
                default : break;
            }
            generateBill();
            System.out.println();

        }
    }
    public void generateBill()
    {
        System.out.println("***Sunway Archery***");
        System.out.println((formatter.format(date)));
        System.out.println(packageForDisplay);
        if(extraArrows == 0 && drinks == 0) {
            System.out.printf("\nTotal Arrows:  %d",arrowForPackage);
        }
        else if(extraArrows == 0 && drinks > 0) {
            System.out.printf("Number of Drinks: %d\n",drinks);
            System.out.printf("\nTotal Arrows:  %d\n",arrowForPackage);
        }
        else{
            System.out.printf("Number of additional arrow: %d\n",extraArrows);
            System.out.printf("Number of Drinks: %d\n",drinks);
            System.out.printf("\nTotal Arrows:  %d\n\n",arrowForPackage);
        }

              System.out.printf("Package price: %.2f\n",packagePrice);
              System.out.printf("Additional Items: %.2f\n",additionalItems);
              System.out.printf("6%% SST: %.2f\n",sst);
              System.out.printf("Net Price: %.2f\n",total);
        do {


            System.out.print("Do you wish to order anything else [1 - 2] : ");
            reOrder = scan.nextInt();
            if (reOrder == 1) {
                order();
            } else if (reOrder == 2) {
                System.out.println("Thanks for your purchase!");
                System.exit(1);
            } else {
                System.out.println("Invalid Choice");
            }
        }while(reOrder == 1 || reOrder == 2);
    }

}