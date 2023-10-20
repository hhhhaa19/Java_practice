/**
 * Created with IntelliJ IDEA.
 * Description:输入一个链表，输出该链表中倒数第k个结点。
 * 思路：倒数k,即正数n-k,那么我只要先走k（其中一个下标），然后让两个下标一起走，先走的那个到了n,那后面那个就是n-k了
 * User: 王金涛
 * Date: 2023-10-20
 * Time: 18:18
 */
public class Backwardsnode {
    public ListNode FindKthToTail(ListNode head, int k) {
        if(head==null)
            return null;
        ListNode fast = head;
        while (k != 0&&fast!=null) {
            fast = fast.next;
            k--;
        }
        if(k>0)
            return null;
        ListNode slow = head;
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
