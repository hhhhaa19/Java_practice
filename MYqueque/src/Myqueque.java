/**
 * Created with IntelliJ IDEA.
 * Description:队列,链表实现
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
    //头节点
    Node head = null;
    //倒数第一个不为空的节点
    Node last = null;

    public void offer(int data) {
        Node newnode = new Node(data);
        if (head == null){
            head=newnode;
            head.next=null;
            head.pre=null;
            last=head;
        }else{
            Node pre =last;
            pre.next=newnode;
            newnode.pre=pre;
            newnode.next=null;
        }
    }
    public int poll(){
        int ret =0;
        if(head==null){
            System.out.println("为空不能去除");
            System.exit(-1);
        } else if (head==last) {
            head=last=null;
        }else{
            ret =head.data;
            Node next =head.next;
            head=next;
            head.pre=null;
        }
        return ret;
    }
    public int peek(){
        if(head==null){
            System.out.println("队列为空");
            System.exit(-1);
        }
        return head.data;
    }

}
