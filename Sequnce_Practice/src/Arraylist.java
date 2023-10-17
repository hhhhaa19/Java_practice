import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;
/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王金涛
 * Date: 2023-10-16
 * Time: 22:34
 */
public class Arraylist {
    public static void TestforIterator() {
        List<Integer> l1 = new ArrayList<>();
        l1.add(23);
        Iterator<Integer> ir = l1.iterator();//注意Iterator是个接口，所以不能直接生成对象，而我们list调用并实现了这个接口对应的方法，所以可以直接生成
    }
}
