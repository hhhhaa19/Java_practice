package ReentrantlockUse;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Benjamin
 * Date: 2024-02-26
 * Time: 19:36
 */
public class ReentrantLockUse {
    public static int sum = 0;
    public static void main(String[] args) {
        ReentrantLock reentrantLock = new ReentrantLock(true);
        Thread thread = new Thread(()->{
            for (int i = 0; i < 1000; i++) {
                reentrantLock.lock();
                sum += i;
                reentrantLock.unlock();
            }


        });
    }
}
