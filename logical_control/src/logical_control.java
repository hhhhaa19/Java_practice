
import java.util.Scanner;

public class logical_control {
/*    public static void main(String[] args) {
        int a = 10;
        String b = String.valueOf(a);
        String c = a + "20";
        System.out.println(c);
        int f = Integer.valueOf(c);
        System.out.println(f);
        System.out.println(b);
    }*/

    public static void main2(String[] args) {
        //编写程序数一下 1到 100 的所有整数中出现多少个数字9
     /*   int i = 1;
        int count = 0;
        while (i <= 100) {
            if (i % 10 == 9 || i / 10 == 9)
                count++;
            i++;
        }*/
        //上述方式有问题：99少算了一个9因此如下
        int i = 1;
        int count = 0;
        while (i <= 100) {
            if (i % 10 == 9)
                count++;
            if (i / 10 == 9)
                count++;
            i++;
        }
        //思考：这两种if的区别
        // System.out.println(count);
    }

    public static void main3(String[] args) {
        //判定素数
        Scanner sc = new Scanner(System.in);
        System.out.println("please input the number you want to test if it is a prime number");
        int number = sc.nextInt();
        int i = 0;
        for (i = 2; i < number; i++) {
            if (number % i == 0) {
                System.out.println("it is not a prime number");
                break;
            }
        }
        if (i == number) {
            System.out.println("it is a prime number");
        }
        sc.close();
    }

    public static void main4(String[] args) {
        //求2个整数的最大公约数
        Scanner sc = new Scanner(System.in);
        System.out.println("input two numbers and output the greatest common divisor");
        int a = sc.nextInt();
        int b = sc.nextInt();
        //辗转相减
        while (a != b) {
            if (a > b) {
                a -= b;
            } else {
                b -= a;
            }
        }
        System.out.println(a);
        sc.close();
    }

    public static void main5(String[] args) {
        //计算分数的值
        double number = 1.0;
        double sum = 0.0;
        for (int i = 2; i <= 100; i++) {
            number++;
            if (i % 2 == 0)
                sum -= 1 / number;
            else
                sum += 1 / number;
        }
        System.out.println(sum);
    }

    public static void main6(String[] args) {
        //打印 X 图形
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int num = sc.nextInt();
            int i = 0;
            while (i < num) {
                int j = 0;
                while (j < num) {
                    if (j == i || j == num - i - 1)
                        System.out.print("*");
                    else
                        System.out.print(" ");
                    j++;
                }
                System.out.println();
                i++;
            }
        }
    }

    public static void main7(String[] args) {
        //编写代码模拟三次密码输入的场景。 最多能输入三次密码，密码正确，提示“登录成功”,密码错误，
        // 可以重新输 入，最多输入三次。三次均错，则提示退出程序
        int count = 3;
        String password = "Wjt164673";
        while (count > 0) {
            Scanner sc = new Scanner(System.in);
            String input = sc.nextLine();
            if (input.equals(password)) {
                System.out.println("密码正确");
                break;
            }
            else {
                count--;
                System.out.println("密码错误，还剩"+count+"次");
            }
        }
    }

    public static void main8(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        for (int i = 1; i <= num; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.printf("%d*%d\t", j, i);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        //. 写一个函数返回参数二进制中 1 的个数
        //提供两种写的方式
        //一、一位一位来
/*        Scanner sc=new Scanner(System.in);
        int num=sc.nextInt();
        int count=0;
        while(num!=0){
            if((num&1)==1){
                count++;
            }
            num >>=1;
        }
        System.out.println(count);
        sc.close();*/
        //二、n&(n-1)
        Scanner sc=new Scanner(System.in);
        int num=sc.nextInt();
        int count=0;
        while(num!=0){
            num &=num-1;
            count++;
        }
        System.out.println(count);
        sc.close();
    }
}
