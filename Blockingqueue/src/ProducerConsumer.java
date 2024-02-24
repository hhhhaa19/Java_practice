/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Benjamin
 * Date: 2024-02-24
 * Time: 11:23
 */
public class ProducerConsumer {
    public static void main(String[] args) {
        MyBlockingQueue<Runnable> blockingQueue = new MyBlockingQueue<>();
        Thread thread1 = new Thread(() -> {
            //在这个两个线程中负责出队列，及处理任务,加锁？->不需要，在这个多线程案例中，只有blockingqueue发生了读写，而其中的读写方法已经加了锁
            while (true) {
                try {
                    Runnable task = blockingQueue.take();
                    task.run();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread thread2 = new Thread(() -> {
            //在这个两个线程中负责出队列，及处理任务,加锁？
            while (true) {
                try {
                    Runnable task = blockingQueue.take();
                    task.run();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread1.start();
        thread2.start();
        //在主线程中负责入队列，及增加任务
        for (int i = 0; i < 100; i++) {
            int n = i;
            try {
                blockingQueue.put(() -> {
                    //放实际需要完成的任务
                    System.out.println("任务编号" + n + "线程编号" + Thread.currentThread().getId());
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
