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

        //Declare variables & Initialize them
        String packageForDisplay = null;

        int checkLastDigit = 0, reOrder = 0, choosenPackage = 0, numOfPackage = 0, addArrows = 0, extraArrows = 0, drinks = 0, arrowForPackage = 0;

        final double PRICE_FOR_ONE = 19.90, PRICE_FOR_TWO = 39.90, PRICE_FOR_FAMILY = 69.90, PRICE_FOR_DRINK = 2, PRICE_FOR_ARROW = 10;

        double total = 0, packagePrice = 0, sst = 0,sstRound = 0, additionalItems = 0;

        boolean validSession = true, validPackage = true, validArrows = true, extraArr = true, extraDrink = true, newOrder = true;

        //Use of loop until valid input from user
        do {
            do {
                System.out.println("Welcome to SuperFun Archery");
                System.out.println((formatter.format(date)));
                System.out.println("1. One Player Package [RM19.90]");
                System.out.println("2. Two Players Package [RM39.90]");
                System.out.println("3. Family Package [RM69.90]");
                System.out.print("\nEnter Your Choice[1-3]: ");
                choosenPackage = scan.nextInt();
                if (choosenPackage == 1 || choosenPackage == 2 || choosenPackage == 3) {
                    validSession = true;
                } else {
                    validSession = false;
                    System.out.println("Invalid input. please try again\n");
                }

            } while (!validSession);

            switch (choosenPackage) {

                //One player Package
                case 1: {
                    System.out.println("You have Selected One Player Package\n");
                    break;
                }
                //Two-players package
                case 2: {
                    System.out.println("You have Selected Two Player Package\n");
                    break;
                }
                //Family -Package
                case 3: {
                    System.out.println("You have Selected Family Package\n");
                    break;
                }
                default:
                    break;
            }
            do {
                // Prompts user for package details
                System.out.println("Enter number of package: ");
                numOfPackage = scan.nextInt();
                if (numOfPackage > 0) {
                    validPackage = true;
                } else {
                    validPackage = false;
                    System.out.println("Invalid input. please try again\n");
                }
            } while (!validPackage);

            do {
                System.out.println("Do you want to add extra arrows[1-yes , 2-no] : ");
                addArrows = scan.nextInt();
                if (addArrows == 1) {
                    validArrows = true;
                } else if (addArrows == 2) {
                    validArrows = true;
                } else {
                    validArrows = false;
                    System.out.println("Invalid input. please try again\n");
                }
            } while (!(validArrows));
            if (addArrows == 1) {
                do {
                    System.out.println("How many arrows do you want to add [1- Set = 10-arrows [RM10]]: ");
                    extraArrows = scan.nextInt();
                    if (extraArrows > 0) {
                        extraArr = true;
                    } else if (extraArrows == 0) {
                        extraArr = true;
                        extraArrows = 0;
                    } else {
                        extraArr = false;
                        System.out.println("Invalid input. please try again\n");
                    }
                } while (!extraArr);
            }
            do {
                System.out.println("How many drinks you want to buy[RM2 per person]: ");
                drinks = scan.nextInt();
                if (drinks > 0) {
                    extraDrink = true;
                } else if (drinks == 0) {
                    extraDrink = true;
                    drinks = 0;
                } else {
                    extraDrink = false;
                    System.out.println("Invalid input. please try again\n");
                }
            } while (!extraDrink);

            if (addArrows == 2) {
                extraArrows = 0;
            }
            //calculates total cost, sst, number of Archery,drink and package name
            if (choosenPackage == 1) {
                packagePrice = (numOfPackage * PRICE_FOR_ONE);
            } else if (choosenPackage == 2) {
                packagePrice = (numOfPackage * PRICE_FOR_TWO);
            } else if (choosenPackage == 3) {
                packagePrice = (numOfPackage * PRICE_FOR_FAMILY);
            }
            additionalItems = (extraArrows * PRICE_FOR_ARROW) + (drinks * PRICE_FOR_DRINK);
            extraArrows = (int) (extraArrows * PRICE_FOR_ARROW);
            sst = (((packagePrice + additionalItems) / 100) * 6);

//            //modulus remainder method to get last digit for example (2.19 *100 = 219) (219 % 10 = 9)
//            checkLastDigit = (int) (sst * 100) % 10;
//
//            //rounding up it to 0 if it is 9 or if it's 4 it will round it to 5 by adding .0.01
//            if (checkLastDigit == 9 || checkLastDigit == 4) {
//                sstRound = sst + 0.01;
//            } else if (checkLastDigit == 1 || checkLastDigit == 6) {
//                sstRound = sst - 0.01;
//            } else if (checkLastDigit == 7 || checkLastDigit == 2) {
//                sstRound = sst - 0.03;
//            } else if (checkLastDigit == 8 || checkLastDigit == 3) {
//                sstRound = sst + 0.02;
//            } else if (checkLastDigit == 5 || checkLastDigit == 0) {
//                sstRound = sst + 0.00;
//            }
            total = (packagePrice + additionalItems + sst);


            //display package name
            if (choosenPackage == 1) {
                packageForDisplay = "one-player package *" + numOfPackage;
                arrowForPackage = 20;
            } else if (choosenPackage == 2) {
                packageForDisplay = "two-player package *" + numOfPackage;
                arrowForPackage = 50;
            } else if (choosenPackage == 3) {
                packageForDisplay = "family package *" + numOfPackage;
                arrowForPackage = 100;
            }

            arrowForPackage = ((arrowForPackage * numOfPackage) + extraArrows);

            //Final Bill Creator
            System.out.println("***SuperFun Archery***");
            System.out.println((formatter.format(date)));
            System.out.println(packageForDisplay);
            //checks if drink and extra arrow is 0 then it will ignore this output
            if (extraArrows == 0 && drinks == 0) {
                System.out.printf("Total Arrows:  %d\n", arrowForPackage);
            } else if (extraArrows == 0 && drinks > 0) {
                System.out.printf("Number of Drinks: %d\n", drinks);
                System.out.printf("\nTotal Arrows:  %d\n", arrowForPackage);
            } else if (extraArrows > 0 && drinks == 0) {
                System.out.printf("Number of additional arrow: %d\n", extraArrows);
                System.out.printf("Total Arrows:  %d\n", arrowForPackage);
            } else {
                System.out.printf("\nNumber of additional arrow: %d\n", extraArrows);
                System.out.printf("Number of Drinks: %d\n", drinks);
                System.out.printf("Total Arrows:  %d\n", arrowForPackage);
            }

            System.out.printf("\nPackage price: %.2f\n", packagePrice);
            if (extraArrows >= 0 && drinks > 0) {
                System.out.printf("Additional Items: %.2f\n", additionalItems);
            }
            System.out.printf("6%% SST: %.2f\n", sst);
            System.out.printf("Net Price: %.2f\n", total);

            //prompt user to start new order or finish the program. user should input 1-2 in order to continue
            do {
                System.out.print("\nDo you wish to order anything else [1=Yes - 2=No] :  ");
                reOrder = scan.nextInt();

                switch (reOrder) {
                    case 1:
                        System.out.println("\n\n");
                        newOrder = true;
                        break;
                    case 2:
                        System.out.println("Thanks for your purchase");
                        newOrder = true;
                        break;

                    default:
                        newOrder = false;
                        System.out.println("Invalid input. please try again");
                }
            } while (!newOrder);
        } while (reOrder == 1);
    }
}