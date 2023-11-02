/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王金涛
 * Date: 2023-11-02
 * Time: 20:28
 */
public class isSymmetric {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null) {
            return false;
        }
        if (q == null) {
            return false;
        }
        return q.val == p.val &&
                isSameTree(p.left, q.left)
                && isSameTree(p.right, q.right);
    }
    //反转并产生新的二叉树
    public TreeNode invertTree(TreeNode root) {
        if(root==null){
            return null;
        }
        TreeNode newnode = new TreeNode(root.val);
        newnode.left=invertTree(root.right);
        newnode.right=invertTree(root.left);
        return newnode;
    }

    public boolean isSymmetric(TreeNode root) {
       if (root == null) {
            return true;
        }
        //好想法，利用了轴对称图形翻转后是其本身的特点，但可惜之前的invertTree是对原二叉树进行改变的
        return isSameTree(root,invertTree(root));
    }
}
