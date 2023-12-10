/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王金涛
 * Date: 2023-12-10
 * Time: 17:08
 */
// key-value 模型
public class HashBucket {
    private static class Node {
        private int key;
        private int value;
        Node next;


        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }


    private Node[]  array;
    private int size;   // 当前的数据个数
    private static final double LOAD_FACTOR = 0.75;
    private static final int DEFAULT_SIZE = 8;//默认桶的大小

    public int put(int key, int value) {
        // write code here
        return -1;
    }


    private void resize() {
        // write code here
    }


    private double loadFactor() {
        return size * 1.0 / array.length;
    }


    public HashBucket() {
        // write code here
    }


    public int get(int key) {
        // write code here
    }
}
