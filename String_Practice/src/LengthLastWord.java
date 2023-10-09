import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王金涛
 * Date: 2023-10-09
 * Time: 19:30
 */
public class LengthLastWord {
    public static int LengthLastWord() {
        Scanner in = new Scanner(System.in);
        int slow = 0;
        int fast = 0;
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            String str = in.nextLine();
            //快慢指针
            slow = 0;
            fast = 0;
            while (fast < str.length()) {
                if (str.charAt(fast) == ' ') {
                    fast++;
                    slow = fast;
                } else {
                    fast++;
                }
            }
        }
        return fast - slow;
    }
}
