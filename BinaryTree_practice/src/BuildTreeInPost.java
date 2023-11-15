/**
 * Created with IntelliJ IDEA.
 * Description:给定两个整数数组 inorder 和 postorder ，其中 inorder 是二叉树的中序遍历（NLR），
 * postorder 是同一棵树的后序遍历(LRN)，请你构造并返回这颗 二叉树
 * User: 王金涛
 * Date: 2023-11-13
 * Time: 14:24
 */
//思想总结：二叉树的总体思路，先确定根节点,在确定左右节点
public class BuildTreeInPost {
    public int i ;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        i = postorder.length-1;
        //inverse(inorder);
        return myBuildTree(postorder, inorder, 0, inorder.length-1);
    }

    public TreeNode myBuildTree(int[] postorder, int[] inorder, int inorder_left, int inorder_right) {
        if (inorder_left > inorder_right) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[i]);
        int in = findIndexRoot(inorder,postorder[i]);
        i--;
        root.right = myBuildTree(postorder, inorder, in + 1, inorder_right);
        root.left = myBuildTree(postorder, inorder, inorder_left, in - 1);
        return root;
    }
    private int findIndexRoot(int[] arr,int key){
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) {
                return i;
            }
        }
        return -1;
    }
}
