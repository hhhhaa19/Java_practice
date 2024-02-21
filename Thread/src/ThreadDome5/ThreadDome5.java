package ThreadDome5;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王金涛
 * Date: 2024-02-21
 * Time: 20:20
 */
class MyThread extends Thread {
    Object locker = new Object();
    public MyThread(String name){
        super(name);
    }
    @Override
    public void run() {
        synchronized (locker) {
            String curName = this.getName();
            if (!curName.equals("c")) {
                try {
                    locker.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(curName);
            }
            if (!curName.equals("a")) {
                System.out.println(curName);
                locker.notify();
            }
        }
    }
}

public class ThreadDome5 {
    /**
     * 这种方法我想不出来,相信后人的智慧!!
     *
     * @param args
     */
    public static void main1(String[] args) {
        Object locker = new Object();
        Thread thread1 = new Thread(() -> {
            synchronized (locker) {
                System.out.println(Thread.currentThread().getName());
            }
        }, "a");
        Thread thread2 = new Thread(() -> {
            synchronized (locker) {
                System.out.println(Thread.currentThread().getName());
            }
        }, "b");
        Thread thread3 = new Thread(() -> {
            synchronized (locker) {
                System.out.println(Thread.currentThread().getName());
            }//先执行
        }, "c");
        thread1.start();
        thread2.start();
        thread3.start();
    }

    public static void main(String[] args) {
        MyThread thread1 = new MyThread("a");
        MyThread thread2 = new MyThread("b");
        MyThread thread3 = new MyThread("c");
        thread1.start();
        thread2.start();
        thread3.start();
    }
}

