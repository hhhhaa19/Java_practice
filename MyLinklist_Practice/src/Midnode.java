/**
 * Created with IntelliJ IDEA.
 * Description:给你单链表的头结点 head ，请你找出并返回链表的中间结点。
 * 如果有两个中间结点，则返回第二个中间结点
 * User: 王金涛
 * Date: 2023-10-20
 * Time: 18:06
 */
public class Midnode {
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
