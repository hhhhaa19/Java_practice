import java.util.LinkedList;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 * Description:请你仅使用两个队列实现一个后入先出（LIFO）的栈，并支持普通栈的全部四种操作（push、top、pop 和 empty）。
 * 思路：其中一个用于存储，另一个用于出栈
 * User: 王金涛
 * Date: 2023-10-29
 * Time: 13:41
 */
public class Stackqueque {
    Queue<Integer> q1;
    Queue<Integer> q2;

    public Stackqueque() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }

    public void push(int x) {
        if (q1.isEmpty())
            q1.offer(x);
        else
            q2.offer(x);
    }

    public int pop() {
        Queue<Integer> qempty = q1;
        Queue<Integer> qnempty = q2;
        if (q2.isEmpty()) {
            qempty = q2;
            qnempty = q1;
        }
        while (qnempty.size() != 1) {
            qempty.offer(qnempty.poll());
        }
        return qnempty.poll();
    }

    public int top() {
        Queue<Integer> qempty = q1;
        Queue<Integer> qnempty = q2;
        if (q2.isEmpty()) {
            qempty = q2;
            qnempty = q1;
        }
        while (qnempty.size() != 1) {
            qempty.offer(qnempty.poll());
        }
        int ret = qnempty.peek();
        qempty.offer(qnempty.poll());
        return ret;
    }

    public boolean empty() {
        return (q1.isEmpty() && q2.isEmpty());
    }
}
