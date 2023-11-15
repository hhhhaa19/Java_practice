import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * Description:给你二叉树的根节点 root ，
 * 请你采用前序遍历的方式，将二叉树转化为一个由括号和整数组成的字符串，返回构造出的字符串。
 * https://leetcode.cn/problems/construct-string-from-binary-tree/
 * User: 王金涛
 * Date: 2023-11-13
 * Time: 20:11
 */
public class BuildString {
    public String tree2str(TreeNode root) {
        StringBuffer ret = new StringBuffer();
        helpTree2str(root, ret);
        return new String(ret);
    }

    private void helpTree2str(TreeNode root, StringBuffer str) {
        if (root ==null){
            return;
        }
        str.append(root.val);
        if(root.left==null&& root.right ==null){
            return;
        }
        if(root.left!= null&& root.right==null){
            str.append("(");
            helpTree2str(root.left,str);
            str.append(")");
        }
        if(root.left!=null&& root.right !=null){
            str.append("(");
            helpTree2str(root.left,str);
            str.append(")");
            str.append("(");
            helpTree2str(root.right,str);
            str.append(")");
        }
        if(root.left==null&& root.right!=null){
            str.append("()");
            str.append("(");
            helpTree2str(root.right,str);
            str.append(")");
        }
    }

}
