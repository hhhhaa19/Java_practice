import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王金涛
 * Date: 2023-11-02
 * Time: 14:49
 */
public class BinaryTree {
    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    '}';
        }
    }
    //节点个数
    int size(Node root) {
        if (root == null) {
            return 0;
        }
        return size(root.left) + size(root.right) + 1;
    }
    //叶子节点个数
    int getLeafNodeCount(Node root)
    {
        if(root==null){
            return 0;
        }
        if(root.right==null&&root.left==null){
            return 1;
        }
        return getLeafNodeCount(root.right)+getLeafNodeCount(root.left);
    }
    //第k层节点个数
    int getKLevelNodeCount(Node root,int k){
        if(root==null){
            return 0;
        }
        if(k==1){
            return 1;
        }
        return getKLevelNodeCount(root.left,k-1)+getKLevelNodeCount(root.right,k-1);
    }
    private int Max (int a, int b){
        return a>b?a:b;
    }
    //求二叉树的高
    int getHeight(Node root){
        if(root==null){
            return 0;
        }
        return Max(getHeight(root.left),getHeight(root.right))+1;
    }
    //找到值为value的元素
    Node find(Node root,int val){
        if(root==null){
            return null;
        }
        if(root.data==val){
            return root;
        }
        Node left=find(root.left,val);
        if(left!=null){
            return left;
        }
        Node right=find(root.right,val);
        if(right!=null){
            return right;
        }
        return null;
    }
    //前序遍历
    public List<Integer> preorderTraversal(Node root) {
        List<Integer> list = new ArrayList<>();
        if(root == null) {
            return list;
        }
        list.add(root.data);
        List<Integer> leftTree = preorderTraversal(root.left);
        list.addAll(leftTree);
        List<Integer> rightTree = preorderTraversal(root.right);
        list.addAll(rightTree);
        return list;
    }
}
