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
    public static void main(String[] args) {
//        FutureTask<Integer> futureTask = new FutureTask<Integer>(new Callable<Integer>() {
//            public Integer call() {
//                int sum = 0;
//                for (int i = 0; i < 1001; i++) {
//                    sum += i;
//                }
//                return sum;
//            }
//        });
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
        FutureTask<Integer> futureTask = new FutureTask<>(callable);
        Thread thread = new Thread(futureTask);

    }
}
