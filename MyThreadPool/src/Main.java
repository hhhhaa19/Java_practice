/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: ${USER}
 * Date: ${YEAR}-${MONTH}-${DAY}
 * Time: ${TIME}
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        MyThreadPool myThreadPool = new MyThreadPool();
        for (int i = 0; i < 100; i++) {
            int n= i;
            myThreadPool.submit(()->{
                System.out.println("任务编码"+n+"线程编码"+Thread.currentThread().getId());
            });

        }
    }
}