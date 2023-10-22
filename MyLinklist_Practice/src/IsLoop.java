/**
 * Created with IntelliJ IDEA.
 * Description:环形链表
 * User: 王金涛
 * Date: 2023-10-22
 * Time: 11:38
 */
public class IsLoop {
    //给你一个链表的头节点 head ，判断链表中是否有环。
    public static boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }

        }
        return false;
    }

    //给定一个链表的头节点  head ，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
    //思路：一个指针从链表起始位置运行，一个指针从相遇点环绕，每次都走一步，两个指针最终汇总入口处相遇
    public static ListNode detectCycle(ListNode head) {
        if (hasCycle(head)) {
            ListNode slow = head;
            ListNode fast = head;
            ListNode meet = head;
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
                if (slow == fast) {
                    meet = slow;
                    break;
                }
            }
            ListNode cur = head;
            while (meet != null) {
                if (cur == meet) {
                    return cur;
                }
                meet = meet.next;
                cur = cur.next;
            }
        }else{
            return null;
        }
        return null;
    }
}
