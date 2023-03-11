import java.util.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Main {
    public static void main (String [] args) {
        Scanner scan = new Scanner (System.in);
        DateFormat dateFormat = new SimpleDateFormat("HH:mm a dd/MM/yyyy");

        Date date = new Date();
        String dFormat = dateFormat.format(date);

        int time = 0, tadult=0,  tchild=0, soup=0, familyC = 0, soupCost=0, family=0;
        final int lunchAdult=25, lunchChild=15, lunchFamily=70, dinnerAdult=35, dinnerChild=20, dinnerFamily=100;
        double total = 0, sst=0, discount=0, afterDiscount=0, netPrice=0, finalTotal=0;
        String session="", soupName="";
        char ans = ' ';
        boolean valid=true;
        boolean valid1=true;
        boolean validSession= true;
        boolean validSoup= true;

        System.out.println("Welcome to Yummy steamboat Buffet restaurant, current time: " + dFormat);
        do {
            do {validSession= true;
                System.out.println("1- Lunch session(12-3 pm)");
                System.out.println("2- Dinner session(4-10 pm)");
                System.out.print("Please enter the session time(1 or 2): ");
                time = scan.nextInt();
                System.out.println();

                if (time==1)
                    session= "Lunch session";
                else if (time==2)
                    session= "Dinner session";
                else {
                    System.out.println("Invalid input, please try again.");
                    validSession= false;
                    System.out.println();
                }
            }while (!validSession);

            do {
                System.out.print("Number of adults: ");
                tadult += scan.nextInt();
                System.out.println();


                System.out.print("Number of children: ");
                tchild += scan.nextInt();
                System.out.println();

                do {validSoup= true;
                    System.out.println("1- Chicken Soup(free)");
                    System.out.println("2- Herbal Soup(+2 per adult)");
                    System.out.println("3- Tomyam Soup(+3 per adult)");

                    System.out.print("Choose the soup type(1, 2 or 3): ");
                    soup = scan.nextInt();
                    scan.nextLine();
                    switch (soup) {
                        case 1: soupCost=0; soupName= "Chicken soup" ;break;
                        case 2: soupCost=2; soupName= "Herbal soup" ;break;
                        case 3: soupCost=3; soupName= "Tomyam soup" ;break;
                        default: System.out.println("Invalid soup type, please try again."); validSoup=false;break;
                    }

                    System.out.println();
                }while(!validSoup);


                do {
                    System.out.print("Do you want to enter additional adults or children(Y-yes, N-no)?: ");


                    ans = scan.nextLine().charAt(0);

                    if(ans=='y'|| ans=='Y'||ans== 'n'||ans== 'N') {}

                    switch(ans) {
                        case 'y', 'Y', 'n', 'N': valid = true;break;
                        default: valid = false;
                            System.out.println("Invalid input. pleas try again");

                    }
                }while(!valid);
            }while (ans=='y'||ans=='Y');


            //to find out the number of families


            for ( family=0; tadult>1 && tchild>1;tadult-=2 , tchild-=2, family++);


            System.out.println();
            if (time==1)
                total= (family*lunchFamily)+(tadult*lunchAdult)+(tadult*soupCost)+(tchild*lunchChild);
            else
                total= (family*dinnerFamily)+(tadult*dinnerAdult)+((tadult+(family*2))*soupCost)+(tchild*dinnerChild);



            System.out.println("==========================================");
            System.out.println("Order on " + dFormat);
            System.out.println(session);
            if(family!=0)
                System.out.println("Family: "+ (family*2)+ " adults + "+ (family*2)+ " children");

            System.out.println("Number of adults: "+ (tadult));
            System.out.println("Number of children: "+ (tchild));
            System.out.println("Soup: " + soupName);
            System.out.println();
            System.out.println("Total price: RM"+ total);
            if (total>200) {

                discount=total/10;
                sst= (total-discount)*0.06;


                System.out.format("10%% discount: RM%.2f \n", discount);
                System.out.format("After discount: RM%.2f \n" ,(total-discount));
            }else {
                discount=0;
                sst= total*0.06;
            }
            System.out.format("6%% SST     :RM%.2f \n", sst);
            System.out.format("Net price   :RM%.2f \n", (total+sst-discount));
            System.out.println("==========================================");
            do {
                System.out.print("Do you want to input another order(Y-yes,N-no)? ");

                time = 0; tadult=0; tchild=0; soup=0; familyC = 0; ans = ' '; family=0; total=0;


                ans = scan.nextLine().charAt(0);



                switch(ans) {
                    case 'y', 'Y', 'n', 'N': valid1 = true;break ;

                    default: valid1 = false;
                        System.out.println("Invalid input. pleas try again");
                }
            }while(!valid1);

        }while (ans=='Y'||ans=='y');
    }
}


