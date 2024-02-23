package ThreadDome5;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王金涛
 * Date: 2024-02-21
 * Time: 20:20
 */
public class ThreadDome5 {
    /**
     * 有三个线程，线程名称分别为：a，b，c。
     * 每个线程打印自己的名称。
     *
     * @param args
     */
    public static int count= 0;
    public static void main(String[] args) {
        Object locker = new Object();
        Thread thread3 = new Thread(() -> {
            synchronized (locker) {
                while (count!=0) {
                    try {
                        locker.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.println(Thread.currentThread().getName());
                count++;
                locker.notifyAll();
            }
        }, "c");

        Thread thread2 = new Thread(() -> {
            synchronized (locker) {
                while (count!=1) {
                    try {
                        locker.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.println(Thread.currentThread().getName());
                count++;
                locker.notifyAll();
            }
        }, "b");
        Thread thread1 = new Thread(() -> {
            synchronized (locker) {
                while (count!=2) {
                    try {
                        locker.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.println(Thread.currentThread().getName());
                count++;
                locker.notifyAll();
            }
        }, "a");
        thread1.start();
        thread2.start();
        thread3.start();
    }


}

