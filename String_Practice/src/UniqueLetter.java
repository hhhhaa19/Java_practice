/**
 * Created with IntelliJ IDEA.
 * Description:桶排
 * User: 王金涛
 * Date: 2023-10-09
 * Time: 18:50
 */
public class UniqueLetter {
    public int firstUniqChar(String s) {
        int[] arr = new int[26];
        for (int i = 0; i < s.length(); i++) {
            arr[(int) s.charAt(i) - 97]++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (arr[(int) s.charAt(i) - 97] == 1) {
                return i;
            }
        }
        return -1;
    }
}
