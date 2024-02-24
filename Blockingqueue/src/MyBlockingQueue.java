/**
 * Created with IntelliJ IDEA.
 * Description:首先这是一个正常的循环队列（直接使用库函数的无法把控阻塞的细节），然后有阻塞功能
 * User: Benjamin
 * Date: 2024-02-23
 * Time: 16:01
 */
public class MyBlockingQueue<T> {
    private int begin = 0;
    private int end = 0;
    private volatile int usedSize = 0;//在多线程用于沟通，volatile
    private Object[] queue = null;//默认size为100
    private final int DEFAULT_SIZE = 100;

    public MyBlockingQueue() {
        queue = new Object[DEFAULT_SIZE];
    }

    public void put(T value) throws InterruptedException {
        synchronized (this) {
            while (DEFAULT_SIZE == usedSize) {
                //满了,要有出去的才能在加进来，等通知
                this.wait();
            }
            queue[begin] = value;
            begin = (begin + 1) % DEFAULT_SIZE;
            usedSize++;
            this.notifyAll();
        }
    }

    public T take() throws InterruptedException {
        synchronized (this) {
            while (usedSize == 0) {
                //空了，
                this.wait();
            }
            T value = (T) queue[end];
            end = (end + 1) % DEFAULT_SIZE;
            usedSize--;
            this.notifyAll();
            return value;
        }
    }
}
