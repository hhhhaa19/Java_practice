import java.util.Locale;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王金涛
 * Date: 2023-10-09
 * Time: 19:49
 */
public class CheckReverse {
    public static boolean isvalid(char a) {
        if (a >= 'a' && a <= 'z' || a >= 'A' && a <= 'Z'||a>='0'&&a<='9') {
            return true;
        } else {
            return false;
        }
    }

    public boolean isPalindrome(String s1) {
        String s=s1.toLowerCase();
        int left = 0;
        int right = s.length() - 1;
        //找到左边有效的数
        while (left < right) {
            while (left < right&&!isvalid(s.charAt(left))) {
                left++;
            }
            //找右边的
            while (left < right&&!isvalid(s.charAt(right))) {
                right--;
            }
            if (s.charAt(right) != s.charAt(left)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
