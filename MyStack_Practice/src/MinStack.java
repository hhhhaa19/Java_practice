import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王金涛
 * Date: 2023-10-24
 * Time: 21:18
 */
public class MinStack {
    Stack<Integer> stack;
    Stack<Integer> minstack;

    public MinStack() {
        stack = new Stack<>();
        minstack = new Stack<>();
    }

    public void push(int val) {
        stack.push(val);
        if (minstack.isEmpty() || minstack.peek() >= val) {
            minstack.push(val);
        }
    }

    public void pop() {
        int temp = stack.pop();
        if (temp == minstack.peek()) {
            minstack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minstack.peek();
    }
}
