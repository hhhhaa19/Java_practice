import sun.util.resources.cldr.ig.CalendarData_ig_NG;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * Description:给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * User: 王金涛
 * Date: 2023-10-24
 * Time: 19:25
 */
public class Valid_Bracket {
    public boolean isValid(String s) {
        Stack<Character> st =new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char cur =s.charAt(i);
            if(cur=='('||cur=='{'||cur=='['){
                st.push(s.charAt(i));
            }else {
                if(st.isEmpty()){
                    return false;
                }
                char pre = st.peek();
                if (cur=='}'&&pre=='{')
                    st.pop();
                else if (cur==')'&&pre=='(')
                    st.pop();
                else if (cur==']'&&pre=='[')
                    st.pop();
                else
                    return false;
            }
        }
        return st.isEmpty();
    }
}
