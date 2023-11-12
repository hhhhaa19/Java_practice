

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王金涛
 * Date: 2023-11-09
 * Time: 19:33
 */
public class LowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null){
            return null;
        }

        if(root==p||root==q ) {
            TreeNode left = lowestCommonAncestor(root.left, p, q);
            TreeNode right = lowestCommonAncestor(root.right, p, q);
            if (left != null || right != null) {
                return root;
            }
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(left!=null&& right!=null){
            return root;
        }
        if(left!=null){
            return left;
        }
        if(right !=null){
            return right;
        }
        if(root == p||root ==q){
            return root;
        }
        return null;
    }
}
