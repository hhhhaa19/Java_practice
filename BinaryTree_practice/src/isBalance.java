/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王金涛
 * Date: 2023-11-02
 * Time: 19:11
 */
public class isBalance {
    private int Max (int a, int b){
        return a>b?a:b;
    }
    int getHeight(TreeNode root){
        if(root==null){
            return 0;
        }
        return Max(getHeight(root.left),getHeight(root.right))+1;
    }
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }

        return (Math.abs(getHeight(root.left) - getHeight(root.right)) <= 1) &&
                isBalanced(root.left) &&
                isBalanced(root.right);
    }
}
