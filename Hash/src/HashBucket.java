/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王金涛
 * Date: 2023-12-10
 * Time: 21:02
 */
// key-value 模型
public class HashBucket<K, V> {
    private static class Node<K, V> {
        private K key;
        private V value;

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        Node<K,V> next;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }


    private Node<K, V>[] array;
    private int size;   // 当前的数据个数
    private static final double LOAD_FACTOR = 0.75;
    private static final int DEFAULT_SIZE = 2;//默认桶的大小

    public void put(K key, V value) {
        // 找到对应的hash值
        int hash = key.hashCode();
        int index = hash % array.length;
        Node<K,V> cur = array[index];
        Node<K,V> pre = array[index];
        //遍历index下标的链表，若存在更新，若不存在尾插法插入
        while(cur!=null){
            if(cur.key.equals(key)){
                cur.value =value;
                return ;
            }
            pre=cur;
            cur=cur.next;
        }
        //不存在
        Node<K,V>  newnode = new Node<>(key,value);
        if(pre==null){
            array[index] = newnode;
        }else{
            pre.next= newnode;
        }
        size++;
        if(loadFactor()>LOAD_FACTOR){
            resize();
        }
    }


    private void resize() {
        // write code here
        Node<K,V>[] newArray = (Node<K, V>[]) new Node[2* array.length];
        for (int i = 0; i < array.length; i++) {
            Node<K,V> cur = array[i];
            //遍历链表中每个元素
            while(cur!=null){
                K curKey = cur.getKey();
                int hash = curKey.hashCode();
                int newIndex = hash % newArray.length;
                Node<K,V> node = newArray[newIndex];
                Node<K,V> prenode = newArray[newIndex];
                Node<K,V> nextnode = cur.next;
                //遍历index下标的链表，把对应节点尾插法插入,尾插法的问题在于要把当前节点的尾值0，所以推荐头插
                while(node!=null){
                    prenode=cur;
                    node=node.next;
                }
                if(prenode==null){
                    newArray[newIndex] = cur;
                }else{
                    prenode.next= cur;
                }
                cur.next=null;
                cur=nextnode;
            }
        }
        this.array= newArray;
    }


    private double loadFactor() {
        return size * 1.0 / array.length;
    }


    public HashBucket() {
        this.array = (Node<K, V>[]) new Node[DEFAULT_SIZE];
    }


    public V get(K key) {
        // write code here
        int index =key.hashCode()% array.length;
        Node<K,V> cur = array[index];
        while(cur!=null){
            if(cur.key.equals(key)){
                return cur.value;
            }
            cur=cur.next;
        }
        return null;
    }
}
