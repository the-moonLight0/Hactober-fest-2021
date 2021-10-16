
import java.util.*;

public class ArmstrongNumber {
    static int IsArmstrong(int num) {
        int sum = 0, a, n = num;
        while (n > 0) {
            a = n % 10;
            sum = sum + a * a * a;
            n = n / 10;
        }
        if (sum == num) {
            return 1;
        } else
            return 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num;
        System.out.println("Enter number to be checked if it is Armstrong number or not : ");
        num = sc.nextInt();

        if ( IsArmstrong(num )==1 ) {
            System.out.println(num + "  is a Armstrong number .");
        } else {
            System.out.println(num + "  is not a Armstrong number .");

        }
        sc.close();
    }

}
