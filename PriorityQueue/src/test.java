/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王金涛
 * Date: 2023-11-15
 * Time: 14:29
 */
public class test {
    public static void main(String[] args) {
        int [] arr =new int[]{27,15,19,18,28,34,65,49,25,37};
        Priortyqueue pq =new Priortyqueue(arr);
        pq.insert(99);
        pq.delete();
    }
}
