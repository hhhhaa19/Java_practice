/**
 * Created with IntelliJ IDEA.
 * Description:队列
 * User: 王金涛
 * Date: 2023-10-25
 * Time: 10:45
 */
public class Myqueque {
    static class Node {
        int data;
        Node next;
        Node pre;

        public Node(int data) {
            this.data = data;
        }
    }

    Node head = null;
    Node last = null;

    public void offer(int data) {
        Node newnode = new Node(data);
        if (head == null){
            head=newnode;

        }
    }
}
