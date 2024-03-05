package ReverseLinkedList;

/**
 * Created with IntelliJ IDEA.
 * Description:给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 * User: Benjamin
 * Date: 2024-03-04
 * Time: 10:06
 */
class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

/**
 * 递归写法
 */
public class ReverseLinkedList {
    public static ListNode curHead = null;
    public static ListNode helpReverse(ListNode head) {
        if (head.next == null) {
            curHead = head;
            return head;
        }
        helpReverse(head.next).next = head;
        head.next =null;
        return head;
    }

    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        helpReverse(head);
        return curHead;
    }
}

class test {
    public static void main(String[] args) {
        ListNode cur1 = new ListNode(-9);
        cur1.next = new ListNode(3);
        new ReverseLinkedList().reverseList(cur1);
    }
}