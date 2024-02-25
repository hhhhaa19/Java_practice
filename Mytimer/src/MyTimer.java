import java.util.PriorityQueue;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Benjamin
 * Date: 2024-02-24
 * Time: 17:40
 */
class Task implements Comparable<Task> {
    Runnable runnable = null;
    long time;//记录的是实际发生事件的时间戳

    @Override
    public int compareTo(Task o) {
        return (int) (this.time - o.time);
        //比大小，试一试
    }

    //PriorityQueue基于比较，要给一个实现comparable的对象
    public Task(Runnable runnable, long delay) {
        this.runnable = runnable;
        this.time = System.currentTimeMillis() + delay;
    }
}

public class MyTimer {
    //这里要用一个数据结构来存储实现runnable接口的对象，以及其发生的时间，直觉上我们可以使用TreeMap(有key与value),但查找需要O（logN）
    //于是，我们使用PriorityQueue来实现，我一开始想的是里面存的可以是一个hashMap（用hashMap来封装），但这样相当于只为了一个Map，创建了过多的空间
    //那我们不如把runnable对象与时间直接封装
    //这里不直接调用阻塞队列->？
    private Object locker = new Object();
    //数据结构不过关，优先级队列大小无限
    PriorityQueue<Task> priorityQueue = new PriorityQueue<>();

    //线程在哪创建比较合理？1.Timer的构造方法 2.第一次调用 schedule
    //这里使用1
    //在构造方法中创建线程，并执行线程的任务
    public MyTimer() {
        Thread thread = new Thread(() -> {
            while (true) {
                synchronized (locker) {
                    //为空，等待,有加入就唤醒
                    while (priorityQueue.isEmpty()) {
                        try {
                            locker.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    Task curtask = priorityQueue.peek();
                    //时间不到，等待，有加入就唤醒（可能有更新的时间）
                    curtask = priorityQueue.peek();
                    while (curtask.time > System.currentTimeMillis()) {
                        long delta = curtask.time - System.currentTimeMillis();
                        try {
                            locker.wait(delta);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        curtask = priorityQueue.peek();
                    }
                    curtask.runnable.run();
                    priorityQueue.poll();
                    //locker.notifyAll();
                }
            }
        });
        thread.start();
    }


    //在schedule方法中加入runnable对象
    public void schedule(Runnable runnable, long delay) {
        Task task = new Task(runnable, delay);
        //为满，就等待,不存在为满
        synchronized (locker) {
            //locker.wait
            priorityQueue.add(task);
            locker.notifyAll();
        }
    }
}
