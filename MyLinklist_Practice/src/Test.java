/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王金涛
 * Date: 2023-10-20
 * Time: 16:07
 */
public class Test {
    public static void main(String[] args) {
        ListNode node1 =new ListNode(1);
        ListNode node2 =new ListNode(3);
        ListNode node3 =new ListNode(3);
        ListNode node4 =new ListNode(1);
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        System.out.println(new palindrome().chkPalindrome(node1));

    }
}
