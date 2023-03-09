//Libraries
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;


public class Assignment1B_Mukhammadaziz {
    public static void main(String[] args) {

        //Initialize Scanner and date
        Scanner scan = new Scanner(System.in);
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();

        // Initialize & Declare variables for use in the class
        int choosenPackage = 0, numOfPackage = 0, addArrows = 0, extraArrows = 0, drinks = 0, reOrder = 0, arrowForPackage = 0;

        final double PRICEFORONE = 19.90, PRICEFORTWO = 39.90, PRICEFORFAMILY = 69.90, PRICEFORDRINK = 2, PRICEFORARROW = 10;

        double total = 0, packagePrice = 0, sst = 0, additionalItems = 0;

        String packageForDisplay = null;

        boolean newOrder = false;

        //Use of loop until valid input from user
        do {
            do {
                System.out.println("Welcome to Sunway Archery");
                System.out.println((formatter.format(date)));
                System.out.println("1. One Player Package [RM19.90]");
                System.out.println("2. Two Players Package [RM39.90]");
                System.out.println("3. Family Package [RM69.90]");
                System.out.print("\nEnter Your Choice[1-3]: ");
                choosenPackage = scan.nextInt();
            } while (!(choosenPackage >= 1 && choosenPackage <= 3));
            switch (choosenPackage) {

                //One player Package
                case 1: {
                    System.out.println("You have Selected One Player Package\n");
                    do {
                        // Prompts user for package details
                        System.out.println("Enter number of package: ");
                        numOfPackage = scan.nextInt();
                    } while (!(numOfPackage > 0));
                    do {
                        System.out.println("Do you want to add extra arrows[1-yes , 2-no] : ");
                        addArrows = scan.nextInt();
                    } while (!(addArrows == 1 || addArrows == 2));
                    if (addArrows != 2) {
                        do {
                            System.out.println("How many arrows do you want to add [1- Set = 10-arrows [RM10]]: ");
                            extraArrows = scan.nextInt();
                        } while (!(extraArrows > 0));
                    }
                    do {
                        System.out.println("How many drinks you want to buy[RM2 per person]: ");
                        drinks = scan.nextInt();
                    } while (!(drinks >= 0));
                    ////calculates total cost, sst, number of Archery,drink and package name
                    packagePrice = (numOfPackage * PRICEFORONE);
                    additionalItems = (extraArrows * PRICEFORARROW) + (drinks * PRICEFORDRINK);
                    extraArrows = (int) (extraArrows * PRICEFORARROW);
                    sst = (((packagePrice + additionalItems) / 100) * 6);
                    total = (packagePrice + additionalItems + sst);
                    //Math.round function returns the rounded value for example 21.09 * 10 = 210.9 if we divide into / 10 = answer will be
                    //21.09 but since I am using round up it will round it to 10 if it's 21.04 it will round it to 0
                    total = Math.round(total * 10) / 10.0;
                    packageForDisplay = "one-player package *" + numOfPackage;
                    arrowForPackage = 20;
                    arrowForPackage = ((arrowForPackage * numOfPackage) + extraArrows);
                    break;
                }

                //Two-players package
                case 2: {
                    System.out.println("You have Selected Two Player Package\n");
                    do {
                        // Prompts user for package details
                        System.out.println("Enter number of package: ");
                        numOfPackage = scan.nextInt();
                    } while (!(numOfPackage > 0));
                    do {
                        System.out.println("Do you want to add extra arrows[1-yes , 2-no] : ");
                        addArrows = scan.nextInt();
                    } while (!(addArrows == 1 || addArrows == 2));
                    if (addArrows != 2) {
                        do {
                            System.out.println("How many arrows do you want to add [1- Set = 10-arrows [RM10]]: ");
                            extraArrows = scan.nextInt();
                        } while (!(extraArrows > 0));
                    }
                    do {
                        System.out.println("How many drinks you want to buy[RM2 per person]: ");
                        drinks = scan.nextInt();
                    } while (!(drinks >= 0));
                    //calculates total cost, sst, number of Archery,drink and package name
                    packagePrice = (numOfPackage * PRICEFORTWO);
                    additionalItems = (extraArrows * PRICEFORARROW) + (drinks * PRICEFORDRINK);
                    extraArrows = (int) (extraArrows * PRICEFORARROW);
                    sst = (((packagePrice + additionalItems) / 100) * 6);
                    total = (packagePrice + additionalItems + sst);
                    //Math.round function returns the rounded value for example 42.29 * 10 = 422.9 if we divide into /10 = answer will be
                    //42.29 but since I am using round up it will round it to 10 if it's 42.24 it will round it to 20
                    total = Math.round(total * 10) / 10.0;
                    packageForDisplay = "two-player package *" + numOfPackage;
                    arrowForPackage = 50;
                    arrowForPackage = ((arrowForPackage * numOfPackage) + extraArrows);
                    break;
                }
                //Family -Package
                case 3: {
                    System.out.println("You have Selected Family Package\n");
                    do {
                        // Prompts user for package details
                        System.out.println("Enter number of package: ");
                        numOfPackage = scan.nextInt();
                    } while (!(numOfPackage > 0));
                    do {
                        System.out.println("Do you want to add extra arrows[1-yes , 2-no] : ");
                        addArrows = scan.nextInt();
                    } while (!(addArrows == 1 || addArrows == 2));
                    if (addArrows != 2) {
                        do {
                            System.out.println("How many arrows do you want to add [1- Set = 10-arrows [RM10]]: ");
                            extraArrows = scan.nextInt();
                        } while (!(extraArrows > 0));
                    }
                    do {
                        System.out.println("How many drinks you want to buy[RM2 per person]: ");
                        drinks = scan.nextInt();
                    } while (!(drinks >= 0));
                    //calculates total cost, sst, number of Archery,drink and package name
                    packagePrice = (numOfPackage * PRICEFORFAMILY);
                    additionalItems = (extraArrows * PRICEFORARROW) + (drinks * PRICEFORDRINK);
                    arrowForPackage = 100;
                    extraArrows = (int) (extraArrows * PRICEFORARROW);
                    sst = (((packagePrice + additionalItems) / 100) * 6);
                    total = (packagePrice + additionalItems + sst);
                    //Math.round function returns the rounded value for example 73.09 * 10 = 730.9 if we divide into /10 = answer will be
                    //79.09 but since I am using round up it will round it to 10 if it's 79.04 it will round it to 0
                    total = Math.round(total * 10) / 10.0;
                    packageForDisplay = "Family package *" + numOfPackage;
                    arrowForPackage = ((arrowForPackage * numOfPackage) + extraArrows);
                    break;
                }
                default:
                    break;
            }
            //Final Bill Creator
            System.out.println("***Sunway Archery***");
            System.out.println((formatter.format(date)));
            System.out.println(packageForDisplay);
            //checks if drink and extra arrow is 0 then it will ignore this output
            if (extraArrows == 0 && drinks == 0) {
                System.out.printf("Total Arrows:  %d\n", arrowForPackage);
            } else if (extraArrows == 0 && drinks > 0) {
                System.out.printf("Number of Drinks: %d\n", drinks);
                System.out.printf("\nTotal Arrows:  %d\n", arrowForPackage);
            } else {
                System.out.printf("\nNumber of additional arrow: %d\n", extraArrows);
                System.out.printf("Number of Drinks: %d\n", drinks);
                System.out.printf("Total Arrows:  %d\n", arrowForPackage);
            }

            System.out.printf("\nPackage price: %.2f\n", packagePrice);
            if (extraArrows != 0 && drinks != 0) {
                System.out.printf("Additional Items: %.2f\n", additionalItems);
            }
            System.out.printf("6%% SST: %.2f\n", sst);
            System.out.printf("Net Price: %.2f\n", total);
            do {
                //prompt user to start new order or finish the program. user should input 1-2 in order to continue
                System.out.print("\nDo you wish to order anything else [1 - 2] : ");
                reOrder = scan.nextInt();
                //reorder
                if (reOrder == 1) {
                    newOrder = true;
		    System.out.println("\n");
                } else if (reOrder == 2) {
                    System.out.println("Thanks for your purchase!");
                    System.exit(1);
                } else {
                    System.out.println("Invalid Choice");
                    newOrder = false;
                }
            } while (!(newOrder));
        } while ((newOrder));
    }
}
