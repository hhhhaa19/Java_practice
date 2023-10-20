/**
 * Created with IntelliJ IDEA.
 * Description:将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的
 * User: 王金涛
 * Date: 2023-10-20
 * Time: 18:42
 */
public class Merge {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1==null)
            return list2;
        if(list2==null)
            return list1;
        ListNode head1 = list1;
        ListNode head2 = list2;
        ListNode head = null;
        ListNode cur = null;
        if (head == null) {
            if (head1.val >= head2.val) {
                head = head2;
                head2=head2.next;
                cur = head;
            } else {
                head = head1;
                head1=head1.next;
                cur = head;
            }
            while (head1 != null && head2 != null) {
                if (head1.val >= head2.val) {
                    cur.next = head2;
                    cur = cur.next;
                    head2 = head2.next;
                } else {
                    cur.next = head1;
                    cur = cur.next;
                    head1 = head1.next;
                }
            }
            while (head1 != null) {
                cur.next = head1;
                cur = cur.next;
                head1 = head1.next;
            }
            while (head2 != null) {
                cur.next = head2;
                cur = cur.next;
                head2 = head2.next;
            }
        }
        return head;
    }
}
