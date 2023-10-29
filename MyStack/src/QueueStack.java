import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * Description:请你仅使用两个栈实现先入先出队列。队列应当支持一般队列支持的所有操作（push、pop、peek、empty）：
 * 思路：我这里没有区分两个栈的区别，也可以把其直接分为input 栈与output栈，当output栈为空时，就把input栈放进去，相当于一组一组输出，来保持相对顺序一致
 * User: 王金涛
 * Date: 2023-10-29
 * Time: 17:56
 */
public class QueueStack {
    Stack<Integer> s1;
    Stack<Integer> s2;

    public QueueStack() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    public void push(int x) {
        Stack<Integer> snempty = s1;
        if (s1.empty()) {
            snempty = s2;
        }
        snempty.push(x);
    }

    public int pop() {
        Stack<Integer> snempty = s1;
        Stack<Integer> sempty = s2;
        if (s1.empty()) {
            snempty = s2;
            sempty = s1;
        }
        while (snempty.size() != 1) {
            sempty.push(snempty.pop());
        }
        int ret = snempty.pop();
        while (!sempty.isEmpty()) {
            snempty.push(sempty.pop());
        }
        return ret;
    }

    public int peek() {
        Stack<Integer> snempty = s1;
        Stack<Integer> sempty = s2;
        if (s1.empty()) {
            snempty = s2;
            sempty = s1;
        }
        while (snempty.size() != 1) {
            sempty.push(snempty.pop());
        }
        int ret = snempty.peek();
        while (!sempty.isEmpty()) {
            snempty.push(sempty.pop());
        }
        return ret;
    }

    public boolean empty() {
        return s1.empty() && s2.empty();
    }
}
