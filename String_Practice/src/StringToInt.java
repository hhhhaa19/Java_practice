/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王金涛
 * Date: 2023-10-09
 * Time: 15:34
 */
public class StringToInt {
    public int StrToInt(String str) {
        int ret = 0;
        int sign = 1;
        int i = 0;
        if (str.isEmpty()){
            return 0;
        }
        if (str.charAt(i) == '-') {
            sign = -sign;
        } else if (str.charAt(i) == '+') {
        } else if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
            ret += (int) str.charAt(i) - 48;
        } else {
            return 0;
        }
        for (i = 1; i < str.length(); i++) {

            if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                ret *= 10;
                ret += (int) str.charAt(i) - 48;
            } else {
                return 0;
            }
        }
        return ret*sign;
    }
}
