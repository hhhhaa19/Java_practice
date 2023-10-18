/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王金涛
 * Date: 2023-10-18
 * Time: 19:14
 */
public interface ImySingleLinkedlist {

        //头插法
        public void addFirst(int data);
        //尾插法
        public void addLast(int data);
        //任意位置插入,第一个数据节点为0号下标，在index节点前插入节点，即index节点变成data
        public void addIndex(int index,int data);
        //查找是否包含关键字key是否在单链表当中
        public boolean contains(int key);
        //删除第一次出现关键字为key的节点
        public void remove(int key);
        //删除所有值为key的节点
        public void removeAllKey(int key);
        //得到单链表的长度
        public int size();
        public void display();
        public void clear();
}
