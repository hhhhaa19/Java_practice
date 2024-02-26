package CallableUse;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Benjamin
 * Date: 2024-02-26
 * Time: 19:18
 */
public class CallableUse {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //第一种写法
        FutureTask<Integer> futureTask1 = new FutureTask<Integer>(new Callable<Integer>() {
            public Integer call() {
                int sum = 0;
                for (int i = 0; i < 1001; i++) {
                    sum += i;
                }
                return sum;
            }
        });
        Thread thread = new Thread(futureTask1);
        thread.start();
        //第二种写法
        Callable<Integer> callable = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                int sum = 0;
                for (int i = 0; i < 1001; i++) {
                    sum += i;
                }
                return sum;
            }
        };
        FutureTask<Integer> futureTask2 = new FutureTask<>(callable);
        Thread thread2 = new Thread(futureTask2);
        thread2.start();
        System.out.println(futureTask2.get());
    }
}
