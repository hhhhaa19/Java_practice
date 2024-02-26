import javafx.concurrent.Task;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * Created with IntelliJ IDEA.
 * Description:实现一个固定线程数的线程池
 * User: Benjamin
 * Date: 2024-02-24
 * Time: 19:17
 */
public class MyThreadPool {
    private final int DEFAULT_Thread_SIZE = 4;
    private final int DEFAULT_Task_SIZE = 10;
    private BlockingDeque<Runnable> blockingDeque = new LinkedBlockingDeque<>(DEFAULT_Task_SIZE);
    private List<Thread> Threadlist = new ArrayList<>();

    public MyThreadPool() {
        //创建线程,执行任务
        for (int i = 0; i < DEFAULT_Thread_SIZE; i++) {
            Thread thread = new Thread(() -> {
                //不用wait，为空自动阻塞
                while (true) {
                    //让线程继续
                    try {
                        blockingDeque.take().run();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
            Threadlist.add(thread);
            thread.start();
        }
        //这段怪怪的，感觉线程的创建也会被阻塞
        //无论是使用 Thread 类的构造方法还是通过 Runnable 接口实现线程任务，线程的创建都不会等待任务执行完成。这是 Java 线程模型的基本特性。
        //具体地说，当你调用 new Thread(...) 构造方法时，会创建一个新的线程对象，并且通过调用 start() 方法来启动该线程执行 run() 方法。
        // 而在 Runnable 接口中，也是通过实现 run() 方法来定义线程的执行逻辑，同样地，线程的创建不会等待 run() 方法执行完毕
    }

    public void submit(Runnable task) throws InterruptedException {
        blockingDeque.put(task);
    }
}
