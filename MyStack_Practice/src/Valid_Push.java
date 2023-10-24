import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * Description:输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。假设压入栈的所有数字均不相等。
 * 例如序列1,2,3,4,5是某栈的压入顺序，序列4,5,3,2,1是该压栈序列对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹出序列。
 * User: 王金涛
 * Date: 2023-10-24
 * Time: 20:08
 */
public class Valid_Push {
    public boolean IsPopOrder(int[] pushV, int[] popV) {
        Stack<Integer> st = new Stack<>();
        int indexpush = 0;
        st.push(pushV[indexpush]);
        indexpush++;
        for (int i = 0; i < popV.length; i++) {
            if (popV[i] == st.peek()) {
                st.pop();
                if(st.isEmpty()&& indexpush < pushV.length){
                    st.push(pushV[indexpush++]);
                }
            } else {
                while (popV[i] != st.peek() && indexpush < pushV.length) {
                    st.push(pushV[indexpush++]);
                }
                if (popV[i] == st.peek()) {
                    st.pop();
                    if(st.isEmpty()&& indexpush < pushV.length){
                        st.push(pushV[indexpush++]);
                    }
                } else if (indexpush == pushV.length - 1) {
                    return false;
                }
            }
        }
        return st.isEmpty();
    }
}
