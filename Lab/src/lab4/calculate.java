package lab4;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Benjamin
 * Date: 2024-03-14
 * Time: 16:27
 */
public class calculate {
    public static void main(String[] args) {
        int n = 0;
        while (Math.pow(n, 3) >= Integer.MIN_VALUE) {
            n--;
        }
        System.out.println(n);
    }
}
