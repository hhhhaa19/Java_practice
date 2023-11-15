/**
 * Created with IntelliJ IDEA.
 * Description:给定两个整数数组 preorder 和 inorder ，其中 preorder 是二叉树的先序遍历（NLR），
 * inorder 是同一棵树的中序遍历(LNR)，请构造二叉树并返回其根节点。
 * User: 王金涛
 * Date: 2023-11-09
 * Time: 20:39
 */
public class BuildTree {
    int i = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return myBuildTree(preorder, inorder, 0, inorder.length-1);
    }

    public TreeNode myBuildTree(int[] preorder, int[] inorder, int inorder_left, int inorder_right) {
        if (inorder_left > inorder_right) {
            return null;
        }
        if (i >= preorder.length) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[i]);
        int in = findindex(preorder[i], inorder);
        i++;
        root.left = myBuildTree(preorder, inorder, inorder_left, in - 1);
        root.right = myBuildTree(preorder, inorder, in + 1, inorder_right);
        return root;
    }

    public int findindex(int tag, int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == tag) {
                return i;
            }
        }
        return -1;
    }

}
