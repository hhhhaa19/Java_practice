/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王金涛
 * Date: 2023-11-29
 * Time: 15:43
 */
public class test {
    public static void main(String[] args) {
        BST bst = new BST();
        int[] arr ={5,3,4,1,7,8,2,6,0,9};
        for (int i = 0; i < arr.length; i++) {
            bst.insert(arr[i]);
        }
        bst.delete(5);
        System.out.println("hh");
    }

    public static void main1(String[] args) {
        TreeNode node1 =new TreeNode(5);
        TreeNode node2 =new TreeNode(4);
        TreeNode node3 =new TreeNode(3);
        TreeNode node4 =new TreeNode(2);
        TreeNode node5 =new TreeNode(1);
       node3.left=node4;
       node3.right=node2;
       node4.left=node5;
       node2.right= node1;

        TreeNode node6 = new BSTPractice().Convert(node3);
    }
}
