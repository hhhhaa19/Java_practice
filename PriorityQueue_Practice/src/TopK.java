import java.security.Key;
import java.util.Comparator;
import java.util.PriorityQueue;
/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王金涛
 * Date: 2023-11-17
 * Time: 17:30
 */
public class TopK {
    public int[] smallestK(int[] arr, int k) {
        if(k==0||arr.length==0){
            return null;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        int i = 0;
        for (; i < k; i++) {
            pq.add(arr[i]);
        }
        for (; i < arr.length; i++) {
            if (arr[i] < pq.peek()) {
                pq.poll();
                pq.add(arr[i]);
            }
        }
        int[] ret = new int[k];
        for (i = 0; i < k; i++) {
            ret[i]= pq.poll();
        }
        return ret;
    }
}
