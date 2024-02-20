package thread;

import java.util.Random;
import java.util.Timer;

import static javax.management.Query.in;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王金涛
 * Date: 2024-02-20
 * Time: 18:59
 */

class MyThread extends Thread {
    @Override
    public void run() {
        super.run();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Thread1");
    }
}

class MyRunnable implements Runnable {
    public void run() {
        System.out.println("Thread4");
    }
}

public class Main {
    public static void main1(String[] args) {
        //继承并重写
        Thread thread1 = new MyThread();
        //匿名内部类(runnable),重写runnable方法
        Thread thread2 = new Thread(new Runnable() {
            public void run() {
                System.out.println("Thread2");
            }
        });
        //lambda
        Thread thread3 = new Thread(() -> {
            try {
                Thread.sleep(3000);
                System.out.println("thread3");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        });
        //实现runnable接口
        Thread thread4 = new Thread(new MyRunnable());
        //匿名内部类(Thread)
        Thread thread5 = new Thread() {
            @Override
            public void run() {
                System.out.println("Thread5");
            }
        };
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
    }

    //给定一个很长的数组 (长度 1000w), 通过随机数的方式生成 1-100 之间的整数.
//实现代码, 能够创建两个线程, 对这个数组的所有元素求和.
//其中线程1 计算偶数下标元素的和, 线程2 计算奇数下标元素的和.
//最终再汇总两个和, 进行相加
//记录程序的执行时间.
    public static int result = 0;

    public static void main2(String[] args) throws InterruptedException {
        int[] arr = new int[1000_0000];
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(100);
        }
        Long before = System.currentTimeMillis();
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < arr.length; i += 2) {
                synchronized (Main.class) {
                    result += arr[i];
                }
            }
        });
        Thread thread2 = new Thread(() -> {
            for (int i = 1; i < arr.length; i += 2) {
                synchronized (Main.class) {
                    result += arr[i];
                }
            }
        });
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        Long cur = System.currentTimeMillis();
        System.out.println("MultiThread:"+result);
        System.out.println("MultiThread:"+ (cur-before));
    }

    public static void main(String[] args) {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("1");
            }
        });
        t.start();
        System.out.println("2");
    }
}
