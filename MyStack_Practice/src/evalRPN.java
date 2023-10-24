import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * Description:给你一个字符串数组 tokens ，表示一个根据 逆波兰表示法 表示的算术表达式。
 * User: 王金涛
 * Date: 2023-10-24
 * Time: 19:22
 */
public class evalRPN {
    public static boolean Isdigit(String s) {
        if (s.equals("*") || s.equals("/") || s.equals("-") || s.equals("+")) {
            return false;
        } else {
            return true;
        }
    }

    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            if (Isdigit(tokens[i])) {
                st.push(Integer.valueOf(tokens[i]));
            } else {
                int num1 = 0;//左边操作数
                int num2 = 0;//右边
                switch (tokens[i]) {
                    case "+":
                        num1 = st.pop();//左边操作数
                        num2 = st.pop();//右边
                        st.push(num1 + num2);
                        break;
                    case "-":
                        num1 = st.pop();//左边操作数
                        num2 = st.pop();//右边
                        st.push(num2 - num1);
                        break;
                    case "*":
                        num1 = st.pop();//左边操作数
                        num2 = st.pop();//右边
                        st.push(num2 * num1);
                        break;
                    case "/":
                        num1 = st.pop();//左边操作数
                        num2 = st.pop();//右边
                        st.push(num2 / num1);
                        break;
                }
            }
        }
        return st.pop();
    }
}
