/**
 * Created with IntelliJ IDEA.
 * Description:给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
 * 你不需要 保留 每个分区中各节点的初始相对位置。
 * 思路1：可以排序吗，即节点不变，只变val
 * User: 王金涛
 * Date: 2023-10-22
 * Time: 10:30
 */
public class DivideLinkList {
    public ListNode partition(ListNode head, int x) {
        ListNode head1 = new ListNode(1);
        ListNode cur1 = head1;
        ListNode head2 = new ListNode(2);
        ListNode cur2 = head2;
        ListNode cur = head;
        while (cur != null) {
            if (cur.val < x) {
                cur1.next = cur;
                cur1 = cur1.next;
                cur = cur.next;
            } else {
                cur2.next = cur;
                cur2 = cur2.next;
                cur = cur.next;
            }
        }
        cur1.next = head2.next;
        cur2.next=null;
        return head1.next;
    }
}
