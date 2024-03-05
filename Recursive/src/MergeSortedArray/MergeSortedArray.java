package MergeSortedArray;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * User: Benjamin
 * Date: 2024-03-04
 * Time: 9:45
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

public class MergeSortedArray {


    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode();
        ListNode recur = head;
        ListNode cur1 = list1;
        ListNode cur2 = list2;
        while (cur1 != null && cur2 != null) {
            ListNode next1 = cur1.next;
            ListNode next2 = cur2.next;
            if (cur1.val > cur2.val) {
                recur.next = cur2;
                cur2 = next2;
            } else {
                recur.next = cur1;
                cur1 = next1;
            }
            recur = recur.next;
        }
        while (cur1 != null) {
            recur.next = cur1;
            cur1 = cur1.next;
            recur = recur.next;
        }
        while (cur2 != null) {
            recur.next = cur2;
            cur2 = cur2.next;
            recur = recur.next;
        }
        return head ;
    }
}
class test {
    public static void main(String[] args) {
        ListNode cur1 = new ListNode(-9);
        cur1.next = new ListNode(3);
        ListNode cur2 = new ListNode(5);
        cur2.next = new ListNode(7);
        new MergeSortedArray().mergeTwoLists(cur1,cur2);
    }
}
