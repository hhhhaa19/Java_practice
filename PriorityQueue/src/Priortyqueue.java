import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王金涛
 * Date: 2023-11-15
 * Time: 14:05
 */
public class Priortyqueue {
    public int[] heap;
    public int usedsize;
    public static final int DEFAULT_SIZE = 10;

    public Priortyqueue(int[] arr) {
        heap = new int[DEFAULT_SIZE];
        usedsize = 0;
        for (int i = 0; i < arr.length; i++) {
            heap[i] = arr[i];
            usedsize++;
            checkCapacity();
        }
        int parentBegin = (usedsize - 1 - 1) / 2;
        for (int i = parentBegin; i >= 0; i--) {
            shiftDown(i);
        }
    }

    private void shiftDown(int parent) {
        //左节点
        int child = parent * 2 + 1;
        while (child < usedsize) {
            //存在右节点
            if (child + 1 < usedsize) {
                child = heap[child] > heap[child + 1] ? child : child + 1;
            }
            //找到子节点中的最大值
            if (heap[child] > heap[parent]) {
                swap(child, parent);
            }
            parent = child;
            child = parent * 2 + 1;
        }
    }

    private void swap(int a, int b) {
        int temp = heap[a];
        heap[a] = heap[b];
        heap[b] = temp;
    }

    private void checkCapacity() {
        if (heap.length == usedsize) {
            heap = Arrays.copyOf(heap, 2 * heap.length);
        }
    }

    public void insert(int data) {
        checkCapacity();
        heap[usedsize] = data;
        int child = usedsize;
        usedsize++;
        shiftUp(child);
    }

    private void shiftUp(int child) {
        while (child > 0) {
            int parent = (child - 1) / 2;
            if(heap[child]>heap[parent]){
                swap(child,parent);
                child =parent;
            }else{
                break;
            }
        }
    }
    public void delete(){
        if(usedsize==0){
            return;
        }
        heap[0]=heap[--usedsize];
        shiftDown(0);
    }
}
