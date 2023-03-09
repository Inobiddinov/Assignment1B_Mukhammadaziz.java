
    import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Date;

    public class Main {
        public static void main(String[] args) {

            boolean choosingSession;
            int Session;

            int neworder =0;
            boolean Neworder;

            do {
                Scanner scan = new Scanner(System.in);
                SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss"); //Calling Local time using the DateFormat
                Date date = new Date();
                System.out.println("Welcome to Yummy steamboat Buffet Restaurant");
                System.out.println("Ordered on " + (formatter.format(date)));
                System.out.println("1. Lunch session");
                System.out.println("2. Dinner session");

                //Creating keyword for Calculating number of Buyer
                double adult = 0;
                double child = 0;
                String sessions = null;
                int adults =0;
                int childs =0;
                int family =0;


                //I am going to use Do while loop for Return if the user input invalid value.
                // User required to input session 1 or 2 if user input value x<1 || x>2 this loop ask the user to input valid value which are  1--2.
                do {
                    System.out.println("Enter a meal session (1 or 2): ");
                    Session= scan.nextInt();

                    if (Session==1){
                        sessions = "Lunch session";
                        choosingSession=true;
                        child=15;
                        adult=25;
                        if (adult==2 && child==2){
                            family=70;
                        }  }
                    else if (Session==2){
                        choosingSession= true;
                        sessions = "Dinner session";
                        child=20;
                        adult=35;
                        if (adults==2 && childs==2){
                            family=100;
                        }
                    }

                    else {
                        System.out.print( Session + " is not a valid session.  ");
                        choosingSession = false;
                    }


                }   while (!(choosingSession));

                //Session is done now We have to ask user input number of Child or Adult
                System.out.print("Enter number of adult: ");
                adults = scan.nextInt();
                System.out.print("Enter number of child: ");
                childs = scan.nextInt();

                Boolean SoupMenu;
                int SOUP;
                String choosenSoup=null;

                //In this part user have to choose soup option and there are only 3 option avaible. If user input value which is x<1 or x>2 it will reason the user input valid value.
                Scanner Soup = new Scanner(System.in);
                System.out.println("1. Chicken soup (Free of charge) ");
                System.out.println("2. Herbal soup (+RM2 per Adult) ");
                System.out.println("3. Tomyam soup (+RM3 per Adult) ");

                do {
                    System.out.print("Enter a soup type[1..3]: ");
                    SOUP = Soup.nextInt();

                    if(SOUP ==1){
                        SoupMenu=true;
                        choosenSoup="Herbal Soup";

                    }
                    else if (SOUP==2){
                        SoupMenu= true;
                        SOUP= (adults * 2 );
                        choosenSoup="Chicken Soup";
                    }
                    else if (SOUP==3){
                        SoupMenu=true;
                        SOUP= (adults * 3);
                        choosenSoup="Tomyam Soup";
                    }
                    else {
                        System.out.print(SOUP+" is not valid soup option. ");
                        SoupMenu=false;
                    }

                }
                while (!(SoupMenu));

                Boolean Addon;
                int addon;
                Scanner anyThingElse = new Scanner(System.in);
                int adult1 =0;
                int  child1=0;
                // This part ask the user if he/she want to add buyer more.
                do{
                    System.out.println("Anything else You would like to add(1-yes 2-no):  " );
                    addon = anyThingElse.nextInt();

                    if (addon==1){
                        Addon =true;
                        System.out.print("Enter number of adult: ");
                        adult1 = scan.nextInt();
                        System.out.print("Enter number of child: ");
                        child1 = scan.nextInt();
                    }
                    else if (addon==2){
                        Addon=true;
                    }
                    else {
                        System.out.print( Session + " is not a valid session.  ");
                        Addon = false;
                    }
                }  while (!(Addon));

                // This part ask the user if he/she want to add more consumer.
                Boolean Addon1;
                int addon1;
                int adult2 =0;
                int  child2=0;
                do{
                    System.out.print("Anything else You would like to add(1-yes 2-no):  " );
                    addon1 = anyThingElse.nextInt();

                    if (addon1==1){
                        Addon1 =true;
                        System.out.print("Enter number of adult: ");
                        adult2 = scan.nextInt();
                        System.out.print("Enter number of child: ");
                        child2 = scan.nextInt();
                    }
                    else if (addon1==2){
                        Addon1=true;
                    }
                    else {
                        System.out.print( Session + " is not a valid session.  ");
                        Addon1 = false;
                    }
                }  while (!(Addon1));



                int numOfAdults = (adults +adult1+adult2); //calculating the total number of Adults
                int numOfChildren =(childs+child1+adult2); //Calculating the Total number of Child

                //This is for Calculate total spending for food per adult && child
                double sumAdults =(adults + (adult1)+adult2) *adult;
                double sumChildren= (childs+(child1)+childs) *child;
                double total = (sumAdults + sumChildren +SOUP);
                double sst = 0;
                double totalOver200 =0;

                //This part for calculating the SST.
                if (sst<total){
                    sst=total/100*6;
                }


                //This part is final part which will show the user how many child or adult are there and total sum of Food.
                System.out.println("========================================================= ");
                System.out.println("Ordered on " + (formatter.format(date)));
                System.out.println(sessions);
                if(sumChildren ==2 && sumAdults==2 ){
                    System.out.println(("Family: 2adults + 2children"));}

                System.out.println("No of adults: "+numOfAdults);
                System.out.println("No of childs: "+numOfChildren);
                System.out.println("Soup: " +choosenSoup);
                System.out.println();
                System.out.format("Total Price:          RM%.2f",total);
                System.out.println();



                if ( total >200) {

                    totalOver200 = total / 100 *10;
                    double afterDiscount = total - totalOver200;
                    System.out.format("Discount 10%%:         RM%.2f",totalOver200);
                    System.out.println();
                    System.out.format("After discount:       RM%.2f",afterDiscount);
                    System.out.println();
                }
                double finals = (total  + sst);

                double format =finals-totalOver200;

                System.out.format("SST:                  RM%.2f  ", sst);
                System.out.println();
                System.out.format("Net price:            RM %.2f",format);
                System.out.println();

                System.out.println("========================================================= ");
                System.out.println();
                System.out.println();
                System.out.println();


                System.out.print("Do you want to add new order? (1-yes  2-no):  ");
                neworder= scan.nextInt();

                if (neworder==1){
                    Neworder=false;
                    System.out.println();
                }
                else if (neworder==2){
                    System.out.println("Thank you for Purchase from our Restaurant. Enjoy your Meal! ");
                    System.out.println();
                    Neworder=true;
                }
                else {
                    System.out.println(neworder+" is invalid. Thank you for Purchase from our Restaurant. Enjoy your Meal! ");
                    Neworder = true;
                }
            } while (!(Neworder));


        }}

