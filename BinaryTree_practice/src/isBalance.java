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
    int HeightDIff (TreeNode root){
        if(root==null){
            return 0;
        }
        int left =HeightDIff(root.left);
        int right =HeightDIff(root.right);
        if(left>=0&&right>=0&&Math.abs(left-right)<=1){
            return Math.max(left,right)+1;
        }else{
            return -1;
        }
    }
    public boolean isBalanced1(TreeNode root){
        if(root==null){
            return true;
        }
       if(HeightDIff(root)>0){
           return true;
       }else{
           return false;
       }
    }
}
