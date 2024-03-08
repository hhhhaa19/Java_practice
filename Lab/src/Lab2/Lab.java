package Lab2;

import java.util.concurrent.CountDownLatch;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Benjamin
 * Date: 2024-02-26
 * Time: 14:34
 */
class DieDemo {
    public int roll() {
        return (int) (Math.random() * 6 + 1);
    }

}

class USMoney {
    private int dollar;
    private int cent;

    public int getCent() {
        return cent;
    }

    public int getDollar() {
        return dollar;
    }

    public USMoney(int dollar, int cent) {
        //先不考虑负数
        this.dollar = dollar + cent / 100;
        this.cent = cent % 100;
    }

    public USMoney plus(USMoney usMoney) {
        return new USMoney(usMoney.getDollar() + this.getDollar(), usMoney.getCent() + this.getCent());
    }
}

public class Lab {
    public static void main1(String[] args) {
        double count = 0;
        for (int i = 0; i < 10; i++) {
            if ((Math.random() - 0.5) > 0) {
                count++;
            }
        }
        System.out.println(count / 10);
        count = 0;
        for (int i = 0; i < 100; i++) {
            if ((Math.random() - 0.5) > 0) {
                count++;
            }
        }
        System.out.println(count / 100);
        count = 0;
        for (int i = 0; i < 1000; i++) {
            if ((Math.random() - 0.5) > 0) {
                count++;
            }
        }
        System.out.println(count / 1000);
    }

    public static int factorial(int number) {
        if (number == 0) {
            return 0;
        }
        if (number == 1) {
            return 1;
        }
        return factorial(number - 1) + factorial(number - 2);
    }

    public static void main2(String[] args) {
        System.out.println(factorial(8));

    }

    public static volatile int score = 0;
    public static volatile int count = 0;

    public static void main3(String[] args) throws InterruptedException {
        DieDemo die1 = new DieDemo();
        DieDemo die2 = new DieDemo();
        Object locker = new Object();
        CountDownLatch countDownLatch = new CountDownLatch(2);
        Thread thread1 = new Thread(() -> {
            while (score < 1000) {
                synchronized (locker) {
                    score += die1.roll();
                    score += die2.roll();
                    count++;
                }
            }
            countDownLatch.countDown();
        });
        Thread thread2 = new Thread(() -> {
            while (score < 1000) {
                synchronized (locker) {
                    score += die1.roll();
                    score += die2.roll();
                    count++;
                }
            }
            countDownLatch.countDown();
        });
        thread1.start();
        thread2.start();
        countDownLatch.await();
        System.out.println(count);
    }

    public static int sum = 0;

    public static void countDown(int n) {
        if (n == 0) {
            //System.out.println("Blast off!"+"recursive");
            return;
        }
        sum += n;

        //System.out.println("Recursive "+ n);
        countDown(n - 1);
    }

    public static void main4(String[] args) {
        Object locker = new Object();
        Thread thread1 = new Thread(() -> {
            Long beforeTime = System.currentTimeMillis();
            countDown(3000);
            Long curTime = System.currentTimeMillis();
            System.out.println(sum);
            System.out.println("recursive时间" + (curTime - beforeTime));

        });
        Thread thread2 = new Thread(() -> {
            Long beforeTime = System.currentTimeMillis();
            int sum2 = 0;
            for (int i = 3000; i > 0; i--) {
                // System.out.println("Iteration "+ i);
                sum2 += i;
            }
            //System.out.println("Blast off!"+"Iteration");
            Long curTime = System.currentTimeMillis();
            System.out.println(sum2);
            System.out.println("Iteration时间" + (curTime - beforeTime));
        });
        thread1.start();
        thread2.start();
    }

    public static void main5(String[] args) {
        USMoney usMoney = new USMoney(88, 109);
        USMoney usMoney2 = new USMoney(343, 9);
        System.out.println(usMoney.getDollar());
        System.out.println(usMoney.getCent());
        USMoney usMoney3 = usMoney.plus(usMoney2);
        System.out.println(usMoney3.getDollar());
        System.out.println(usMoney3.getCent());
    }

    public static void main6(String[] args) {
        int[] arr1 = {40, 50, 60};
        int[] arr2 = {5, 8, 12};
        int budget = 60;
        int max = 0;
        int maxArr1 = 0;
        int maxArr2 = 0;
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2.length; j++) {
                int temp = arr1[i] + arr2[j];
                if (temp > max && temp <= budget) {
                    max = temp;
                    maxArr1 = i;
                    maxArr2 = j;
                }
            }
        }
        System.out.println(maxArr1);
        System.out.println(maxArr2);
    }

    public static void main10(String[] args) {
        try {
            try {
                System.out.println("Before");
                throw new ArithmeticException();
            } catch (ArithmeticException exc) {
                System.out.println("Exception caught");
            }
        } catch (ArithmeticException exc) {
            System.out.println("outer");
        }
    }

    public static char prompt(String str) throws IOException {
        System.out.println(str + ":");
        return (char) System.in.read();
    }

    public static void main9(String[] args) {
        char ch = 'X';
        try {
            ch = prompt("Enter a letter");
        } catch (IOException exc) {
            System.out.println("I/o exception occurred.");
            System.out.println("You pressed " + ch);
        }
    }






}
class Outer {
    public int x = 10;

    private class Inner {
        public int y = 5;
    }
}