import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class FoodOrder {
    Scanner scan = new Scanner(System.in);
    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

    Date date = new Date();
    int choosenPackage = 0, numOfPackage = 0,addArrows = 0,
            extraArrows = 0, drinks = 0,reOrder = 0,arrowForPackage = 0,extraArr= 0;
    final double PRICEFORONE = 19.90, PRICEFORTWO = 39.90, PRICEFORFAMILY = 69.90,PRICEFORDRINK = 2,
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
         do {
             displayMenu();
             System.out.print("\nEnter Your Choice[1-3]: ");
             choosenPackage = scan.nextInt();
         } while(!(choosenPackage >= 1 && choosenPackage <= 3));
            switch (choosenPackage) {
                case 1 : {
                        System.out.println("You have Selected One Player Package\n");
                    do {
                        System.out.println("Enter number of package: ");
                        numOfPackage = scan.nextInt();
                    } while(!(numOfPackage > 0));
                    do{
                        System.out.println("Do you want to add extra arrows[1-yes , 2-no] : ");
                        addArrows = scan.nextInt();} while (!(addArrows == 1 || addArrows ==2));
                    if(addArrows != 2){ do{
                        System.out.println("How many arrows do you want to add [10-arrows [RM10]]: ");
                        extraArrows = scan.nextInt();}while(!(extraArrows > 0));}
                    do {
                        System.out.println("How many drinks you want to buy[RM2 per person]: ");
                        drinks = scan.nextInt();}while (!(drinks >= 0));
                    packagePrice =(numOfPackage * PRICEFORONE);
                    additionalItems = (extraArrows * PRICEFORARROW)+(drinks * PRICEFORDRINK);
                    extraArrows = (int) (extraArrows * PRICEFORARROW);
                    sst = (((packagePrice + additionalItems)/100)*6);
                    sst = Math.ceil(sst * 100) / 100.0;
                    total =(packagePrice + additionalItems + sst);
                    packageForDisplay = "one-player package *"+numOfPackage;
                    arrowForPackage = 20;
                  //  extraArr = (int) (extraArrows * PRICEFORARROW);
                    arrowForPackage = ((arrowForPackage * numOfPackage) + extraArrows);

                } break;
                case 2 : {
                    System.out.println("You have Selected Two Player Package\n");
                    do {
                        System.out.println("Enter number of package: ");
                        numOfPackage = scan.nextInt();
                    } while(!(numOfPackage > 0));
                    do{
                        System.out.println("Do you want to add extra arrows[1-yes , 2-no] : ");
                        addArrows = scan.nextInt();} while (!(addArrows == 1 || addArrows ==2));
                    if(addArrows != 2){ do{
                        System.out.println("How many arrows do you want to add [10-arrows [RM10]]: ");
                        extraArrows = scan.nextInt();}while(!(extraArrows > 0));}
                    do {
                        System.out.println("How many drinks you want to buy[RM2 per person]: ");
                        drinks = scan.nextInt();}while (!(drinks >= 0));
                    packagePrice =(numOfPackage * PRICEFORTWO);
                    additionalItems = (extraArrows *PRICEFORARROW)+(drinks*PRICEFORDRINK);
                    extraArrows = (int) (extraArrows * PRICEFORARROW);
                    sst = (((packagePrice + additionalItems)/100)*6);
                    sst = Math.ceil(sst * 100) / 100.0;
                    total =(packagePrice + additionalItems +sst);
                    packageForDisplay = "two-player package *"+numOfPackage;
                    arrowForPackage = 50;
                 //   extraArr = (int) (extraArrows * PRICEFORARROW);
                    arrowForPackage = ((arrowForPackage * numOfPackage) + extraArrows);

                }break;
                case 3 : {
                    System.out.println("You have Selected Family Package\n");
                    do {
                        System.out.println("Enter number of package: ");
                        numOfPackage = scan.nextInt();
                    } while(!(numOfPackage > 0));
                    do{
                        System.out.println("Do you want to add extra arrows[1-yes , 2-no] : ");
                        addArrows = scan.nextInt();} while (!(addArrows == 1 || addArrows ==2));
                    if(addArrows != 2){ do{
                        System.out.println("How many arrows do you want to add [10-arrows [RM10]]: ");
                        extraArrows = scan.nextInt();}while(!(extraArrows > 0));}
                    do {
                        System.out.println("How many drinks you want to buy[RM2 per person]: ");
                        drinks = scan.nextInt();}while (!(drinks >= 0));
                    packagePrice =(numOfPackage * PRICEFORFAMILY);
                    additionalItems = (extraArrows *PRICEFORARROW)+(drinks*PRICEFORDRINK);
                    arrowForPackage = 100;
                    extraArrows = (int) (extraArrows * PRICEFORARROW);
                    sst = (((packagePrice + additionalItems)/100)*6);
                    sst = Math.ceil(sst * 100) / 100.0;
                    total =(packagePrice + additionalItems +sst);
                    packageForDisplay = "Family package *"+numOfPackage;
                //    extraArr = (int) (extraArrows * PRICEFORARROW);
                    arrowForPackage = ((arrowForPackage * numOfPackage) + extraArrows);
                } break;
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
            System.out.printf("Total Arrows:  %d\n",arrowForPackage);
        }
        else if(extraArrows == 0 && drinks > 0) {
            System.out.printf("Number of Drinks: %d\n",drinks);
            System.out.printf("\nTotal Arrows:  %d\n",arrowForPackage);
        }
        else{
            System.out.printf("\nNumber of additional arrow: %d\n",extraArrows);
            System.out.printf("Number of Drinks: %d\n",drinks);
            System.out.printf("Total Arrows:  %d\n",arrowForPackage);
        }

              System.out.printf("\nPackage price: %.2f\n",packagePrice);
                if(extraArrows !=0 && drinks != 0 ){
              System.out.printf("Additional Items: %.2f\n",additionalItems);}
              System.out.printf("6%% SST: %.2f\n",sst);
               System.out.printf("Net Price: %.2f\n",total);
        do {
            System.out.print("\nDo you wish to order anything else [1 - 2] : ");
            reOrder = scan.nextInt();
            if (reOrder == 1) {
                order();
            } else if (reOrder == 2) {
                System.out.println("Thanks for your purchase!");
                System.exit(1);
            } else {
                System.out.println("Invalid Choice");
            }
        }while(!(reOrder == 1 || reOrder == 2));
    }

}