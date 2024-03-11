package lab4;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Benjamin
 * Date: 2024-03-11
 * Time: 14:06
 */
public class InputDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = 1;
        while (num != 0) {
            try {
                System.out.println("Enter an integer number:");
                num = scanner.nextInt();
                System.out.printf("The input integer number is %d\n", num);
            } catch (InputMismatchException e) {
                System.out.println("The input should be an integer");
                scanner.next();//把不符合的拿走
                continue;
            }
        }
        scanner.close();
    }
}
