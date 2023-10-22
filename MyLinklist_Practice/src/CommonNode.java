/**
 * Created with IntelliJ IDEA.
 * Description:给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表不存在相交节点，返回 null 。
 * <p>
 * 思路：如果到了终点还没有相遇 那重走ta走的路~,但即使你走过ta的路，也不能擅自加入ta的人生
 * <p>
 * User: 王金涛
 * Date: 2023-10-22
 * Time: 11:02
 */
public class CommonNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode curA = headA;
        ListNode curB = headB;
        while (curB != curA) {
            curA = curA.next;
            curB = curB.next;
            if(curB==null){
                if(curA==null){
                    break;
                }
                curB=headA;
            }
            if(curA==null){
                if(curB==null){
                    break;
                }
                curA=headB;
            }
        }
        return curA;
    }
}
