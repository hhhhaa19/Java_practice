/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王金涛
 * Date: 2023-11-02
 * Time: 20:37
 */
public class invertTree {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode temp = root.left;
        root.left=root.right;
        root.right=temp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
    //反转并产生新的二叉树，可以当复制二叉树用
    public TreeNode invertTree2(TreeNode root) {
        if(root==null){
            return null;
        }
        TreeNode newnode = new TreeNode(root.val);
        newnode.left=invertTree(root.right);
        newnode.right=invertTree(root.left);
        return newnode;
    }
}
