package ThreadDome4;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王金涛
 * Date: 2024-02-21
 * Time: 19:48
 */
public class ThreadDome4 {
    public static void main(String[] args) {
        Object locker1 = new Object();
        Object locker2 = new Object();
        Thread thread1 = new Thread(()->{
            synchronized (locker1) {
                System.out.println("Thread1+ lock1");
                synchronized (locker2) {
                    System.out.println("Thread1+ lock2");
                }
            }
        });
        Thread thread2 = new Thread(()->{
            synchronized (locker2) {
                System.out.println("Thread2+ lock1");
                synchronized (locker1) {
                    System.out.println("Thread2+ lock2");
                }
            }
        });
        thread1.start();
        thread2.start();
    }
}
