import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:用数组的形式创建自己的栈
 * User: 王金涛
 * Date: 2023-10-24
 * Time: 19:00
 */
public class Mystack {
    private int[] arr;
    private int usedsize;
    public final static int DEFAULT_SIZE = 10;

    public Mystack() {
        this.arr = new int[DEFAULT_SIZE];
        this.usedsize = 0;
    }

    public void checkCapacity() {
        if (usedsize == arr.length) {
            arr = Arrays.copyOf(arr, 2 * arr.length);
        }
    }

    public void push(int data) {
        checkCapacity();
        arr[usedsize] = data;
        usedsize++;
    }

    public Boolean isempty() {
        return usedsize == 0;
    }

    public int pop() throws StackException{
        if (!isempty())
            return arr[--usedsize];
        else
            throw new StackException();
    }
    public int peek()throws StackException{
        if(!isempty()){
            return arr[usedsize-1];
        }else
            throw new StackException();
    }
}
