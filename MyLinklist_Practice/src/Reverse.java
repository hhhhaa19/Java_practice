/**
 * Created with IntelliJ IDEA.
 * Description:给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 * User: 王金涛
 * Date: 2023-10-20
 * Time: 16:33
 */
public class Reverse {
    public ListNode reverseList(ListNode head) {
        ListNode pre = head;
        if (pre == null)
            return null;
        if (pre.next != null) {
            ListNode next = head.next;
            ListNode nextcur = next.next;
            while (nextcur != null) {
                next.next = pre;
                if (pre == head) {
                    pre.next = null;
                }
                pre = next;
                next = nextcur;
                nextcur = nextcur.next;
            }
            next.next = pre;
            if (pre == head) {
                pre.next = null;
            }
            return next;
        } else {
            return head;
        }
    }
}
