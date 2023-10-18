/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王金涛
 * Date: 2023-10-18
 * Time: 19:15
 */
public class MySingleLinklist implements ImySingleLinkedlist {
    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    Node head = null;

    @Override
    public void addFirst(int data) {
        Node newnode = new Node(data);
        if (head == null) {
            head = newnode;
        } else {
            Node next = head;
            head = newnode;
            newnode.next = next;
        }
    }

    @Override
    public void addLast(int data) {
        Node newnode = new Node(data);
        Node cur = head;
        if (head == null) {
            head = newnode;
        } else {
            while (cur.next != null) {
                cur = cur.next;
            }//找到最后一个节点
            cur.next = newnode;
        }
    }

    //找到目标,是index所处的节点
    private Node findnodebyindex(int index) {
        try {
            CheckIndex(index);
        } catch (SingleLinklistindexException e) {
            e.printStackTrace();
            System.exit(-1);
        }
        Node cur = head;
        while (index > 0) {
            cur = cur.next;
            index--;
        }
        return cur;
    }

    //找到目标,是index前一个的节点，这样才能找到key
    //找不到要抛异常吗
    private Node findnodebykey(int key) {
        Node cur = head;
        if (cur.data == key) {
            return head;
        }
        while (cur.next != null) {
            if (cur.next.data == key) {
                return cur;
            } else {
                cur = cur.next;
            }
        }
        return null;
    }

    private void CheckIndex(int index) throws SingleLinklistindexException {
        if (index < 0 || index > this.size()) {
            throw new SingleLinklistindexException();
        }
    }

    @Override
    public void addIndex(int index, int data) {
        Node newnode = new Node(data);
        try {
            CheckIndex(index);

        } catch (SingleLinklistindexException e) {
            e.printStackTrace();
            System.exit(-1);
        }
        if (index == 0) {
            Node next = head;
            head = newnode;
            newnode.next = next;
        } else {
            Node pre = findnodebyindex(index - 1);//找到前面的那个节点
            Node next = findnodebyindex(index);//找到当前节点即next节点
            pre.next = newnode;
            newnode.next = next;
        }
    }

    @Override
    public boolean contains(int key) {
        return !(findnodebykey(key) == null);
    }

    @Override
    public void remove(int key) {
        Node pre = findnodebykey(key);
        if (pre == null) {
            return;
        }
        if (pre != head) {
            Node next = pre.next.next;
            pre.next = next;
        } else {
            Node next = pre.next;
            head = next;
        }
    }

    @Override
    public void removeAllKey(int key) {
        while (head != null && head.data == key) {
            head = head.next;
        }//找到第一个不是key的数
        //只有有pre,才能把cur删除
        Node pre = head;
        if (pre != null) {
            Node cur = head.next;
            while (cur != null) {
                if (cur.data == key) {
                    pre.next = cur.next;
                }
                cur = cur.next;
                pre = pre.next;
            }
        }

    }

    @Override
    public int size() {
        Node cur = head;
        int count = 0;
        while (cur != null) {
            cur = cur.next;
            count++;
        }
        return count;
    }

    @Override
    public void display() {
        Node cur = head;
        while (cur != null) {
            System.out.println(cur.data);
            cur = cur.next;
        }
    }

    @Override
    public void clear() {
        Node cur = head;
        while (cur != null) {
            Node next = cur.next;
            cur.next = null;
            cur = next;
        }
        head = null;
    }
}
