/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王金涛
 * Date: 2023-11-02
 * Time: 19:36
 */
public class isSubtree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if(p==null){
            return false;
        }
        if(q==null){
            return false;
        }
        return q.val==p.val&&
                isSameTree(p.left,q.left)
                &&isSameTree(p.right,q.right);
    }
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
    if(subRoot==null){
        return true;
    }
    if(root==null){
        return false;
    }
    return isSameTree(root,subRoot)||
            isSubtree(root.left,subRoot)||
            isSubtree(root.right,subRoot);
    }
}
