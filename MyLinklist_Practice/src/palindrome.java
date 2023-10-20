/**
 * Created with IntelliJ IDEA.
 * Description:给定一个链表的 头节点 head ，请判断其是否为回文链表。
 * 如果一个链表是回文，那么链表节点序列从前往后看和从后往前看是相同的
 * 思路：先用快慢指针得到中间节点
 * User: 王金涛
 * Date: 2023-10-20
 * Time: 19:25
 */
public class palindrome {
    public boolean chkPalindrome(ListNode A) {
        ListNode slow = A;
        ListNode fast = A;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode mid=null;
        if (fast == null) {
             mid = slow;
        }else {
             mid=slow.next;
        }
        ListNode newNode = new Reverse().reverseList(mid);
        while (newNode!=null){
            if(newNode.val!=A.val)
                return false;
            A=A.next;
            newNode=newNode.next;
        }
        return true;
    }
}
