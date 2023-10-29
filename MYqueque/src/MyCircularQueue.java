/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王金涛
 * Date: 2023-10-29
 * Time: 13:06
 */
public class MyCircularQueue {
    public int[] data = null;
    public int first;
    public int last;
    public int size;

    //MyCircularQueue(k): 构造器，设置队列长度为 k 。
    public MyCircularQueue(int k) {
        data = new int[k + 1];
        first = last = 0;
        size = k+1;
    }

    //enQueue(value): 向循环队列插入一个元素。如果成功插入则返回真。
    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }
        data[last] = value;
        last = (last + 1) % size;
        return true;
    }

    //deQueue(): 从循环队列中删除一个元素。如果成功删除则返回真。
    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }
        first = (first + 1) % size;
        return true;
    }

    //Front: 从队首获取元素。如果队列为空，返回 -1 。
    public int Front() {
        if (isEmpty()) {
            return -1;
        }
        return data[first];
    }

    //Rear: 获取队尾元素。如果队列为空，返回 -1 。
    public int Rear() {
        if (isEmpty()) {
            return -1;
        }
        int lastindex =(last-1+size)%size;
        return data[lastindex];
    }

    //isEmpty(): 检查循环队列是否为空。
    public boolean isEmpty() {
        return first == last;
    }

    //isFull(): 检查循环队列是否已满
    public boolean isFull() {
        return (last + 1) % size == first;
    }
}
