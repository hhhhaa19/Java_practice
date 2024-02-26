import java.util.Random;
import java.util.concurrent.CountDownLatch;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Benjamin
 * Date: 2024-02-26
 * Time: 21:07
 */
public class CountDownLatchUse {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(10);
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(()->{
                int delay = (int) (Math.random()*10000+1000);
                try {
                    Thread.sleep(delay);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                countDownLatch.countDown();
                System.out.println(Thread.currentThread().getId());
            });
            thread.start();
        }
        countDownLatch.await();
        System.out.println("the end");
    }
}
