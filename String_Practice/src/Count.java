/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王金涛
 * Date: 2023-10-09
 * Time: 10:33
 */
public class Count {
    public int countSegments(String s) {
        int count = 0;
        int cur = 0;
        while (cur < s.length()) {
            if (s.charAt(cur) != ' ') {
                break;
            }
            cur++;
        }//去掉前面的空格
        for (int i = 0; i < s.length(); i++) {
            if ((i == 0 || s.charAt(i - 1) == ' ') && s.charAt(i) != ' ') {
                count++;
            }
        }
        return count;
    }
}
