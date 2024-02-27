import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: ${USER}
 * Date: ${YEAR}-${MONTH}-${DAY}
 * Time: ${TIME}
 */
public class AtomicIntegerUse {
    public static void main(String[] args) throws InterruptedException {
        AtomicInteger count = new AtomicInteger(0);
        CountDownLatch countDownLatch = new CountDownLatch(2);
        Thread thread1 = new Thread(()->{
            for (int i = 0; i < 1000; i++) {
                count.getAndAdd(1);
            }
            countDownLatch.countDown();
        });
        Thread thread2 = new Thread(()->{
            for (int i = 0; i < 1000; i++) {
                count.getAndAdd(1);
            }
            countDownLatch.countDown();
        });
        thread1.start();
        thread2.start();
        countDownLatch.await();
        System.out.println(count);
    }
}