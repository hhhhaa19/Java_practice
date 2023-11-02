/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王金涛
 * Date: 2023-11-02
 * Time: 20:19
 */
public class test {
    public static void main(String[] args) {
        TreeNode node1=new TreeNode(1);
        TreeNode node2=new TreeNode(2);
        TreeNode node3=new TreeNode(2);
        TreeNode node4=new TreeNode(3);
        TreeNode node5=new TreeNode(3);
        node1.right=node3;
        node1.left=node2;
        node2.right=node4;
        node3.right=node5;
        TreeNode node6=new TreeNode(1);
        TreeNode node7=new TreeNode(1);
        TreeNode node8=new TreeNode(2);
        node6.left=node7;
        node6.right=node8;
        System.out.println(new isSymmetric().isSymmetric(node1));
    }


}
