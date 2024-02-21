package Threaddemo2;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王金涛
 * Date: 2024-02-20
 * Time: 21:30
 */
public class ThreadDemo2 {
    public static int count = 0;

    public static void main(String[] args) throws InterruptedException {
        Object locker = new Object();
        Thread thread1 = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    synchronized (locker) {
                        count++;
                    }
                }
            }
        };
        Thread thread2 = new Thread(){
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    //这里不能用this,this指的是thread2这个对象
                    synchronized (locker) {
                        count++;
                    }
                }
            }
        };
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println(count);
    }
}
