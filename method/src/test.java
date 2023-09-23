/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王金涛
 * Date: 2023-09-18
 * Time: 22:13
 */
public class test {
    public static void main(String[] args) {
        System.out.println(max(2, 3));
        System.out.println(max(2.4, 2.5, 2.9));
    }

    public static int max2(int a, int b) {
        return (a > b ? a : b);
    }

    public static int fac(int n) {
        int ret = 1;
        while (n > 0) {
            ret *= n;
            n--;
        }
        return ret;
    }

    public static int sumfac(int n) {
        int sum = 0;
        while (n > 0) {
            sum += fac(n);
            n--;
        }
        return sum;
    }

    public static int max3(int a, int b, int c) {
        return max2(max2(a, b), c);
    }

    public static int fibonacci(int n) {
        if (n <= 2) {
            return 1;
        }
        int num1 = 1;
        int num2 = 1;
        int ret = 0;
        while (n >= 3) {
            ret = num1 + num2;
            int temp = num2;
            num2 = ret;
            num1 = temp;
            n--;
        }
        return ret;
    }

    public static int add(int a, int b) {
        return a + b;
    }

    public static double add(double a, double b, double c) {
        return a + b + c;
    }

    public static int max(int a, int b) {
        return a > b ? a : b;
    }

    public static double max(double a, double b, double c) {
        return (a > b ? a : b) > c ? (a > b ? a : b) : c;
    }
}
