
public class Test {
    public static void main(String[] args) {
        double num1= 12.10;
        double num2=0;
        System.out.printf("%-10s %-10s\n", "old total", "new");
        for (int cnt=1; cnt<=20; cnt++) {
            System.out.printf("%-10.2f", num1);
            num2 = Math.round(num1 * 10) / 10.0;
            System.out.printf("%-10.2f\n" , num2);
            num1 = num1+0.01;
        }
    }
}
