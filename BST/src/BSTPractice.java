/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王金涛
 * Date: 2023-12-10
 * Time: 14:34
 */
public class BSTPractice {
    public TreeNode Convert(TreeNode pRootOfTree) {
        return RightHelp(pRootOfTree);
    }

    private TreeNode LeftHelp(TreeNode pRootOfTree) {
        if (pRootOfTree == null) {
            return null;
        }
        TreeNode preNode = LeftHelp(pRootOfTree.left);
        if (preNode == null) {
            preNode = pRootOfTree;
        } else {
            preNode.right = pRootOfTree;
            pRootOfTree.left = preNode;
        }
        TreeNode nextNode = RightHelp(pRootOfTree.right);
        if (nextNode == null) {
            nextNode = pRootOfTree;
        } else {
            nextNode.left = pRootOfTree;
            pRootOfTree.right = nextNode;
        }
        return nextNode;
    }

    private TreeNode RightHelp(TreeNode pRootOfTree) {
        if (pRootOfTree == null) {
            return null;
        }
        TreeNode nextNode = RightHelp(pRootOfTree.right);
        if (nextNode == null) {
            nextNode = pRootOfTree;
        } else {
            nextNode.left= pRootOfTree;
            pRootOfTree.right = nextNode;
        }
        TreeNode preNode = LeftHelp(pRootOfTree.left);
        if (preNode == null) {
            preNode = pRootOfTree;
        } else {
            preNode.right = pRootOfTree;
            pRootOfTree.left = preNode;
        }
        return preNode;
    }

}
