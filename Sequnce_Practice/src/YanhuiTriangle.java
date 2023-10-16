
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王金涛
 * Date: 2023-10-16
 * Time: 20:26
 */
public class YanhuiTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<Integer> List1 = new ArrayList<>();
        List1.add(1);
        List<List<Integer>> ret = new ArrayList<>();
        ret.add(List1);
        for (int i = 1; i < numRows; i++) {
            List<Integer> cur = new ArrayList<>();
            List<Integer> before=ret.get(i-1);
            cur.add(1);
            for (int j = 1; j <= i - 1; j++) {
                cur.add(before.get(j)+before.get(j-1));
            }
            cur.add(1);
            ret.add(cur);
        }
        return ret;
    }
}
