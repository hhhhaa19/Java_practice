/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王金涛
 * Date: 2023-11-02
 * Time: 19:31
 */
public class isSame {
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
}
