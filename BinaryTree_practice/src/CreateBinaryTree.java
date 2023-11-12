import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王金涛
 * Date: 2023-11-07
 * Time: 20:33
 */
public class CreateBinaryTree {
    int i =0;
    public TreeNode Create (String str){

        char cur =str.charAt(i);
        TreeNode newnode = null;
        if(cur =='#'){
            i++;
            return null;
        }else{
            newnode = new TreeNode(cur);
            i++;
            newnode.left=Create(str);
            newnode.right=Create(str);
        }
        return newnode;
    }
}
