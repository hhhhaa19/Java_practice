import java.util.*;

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
    //从上到下，从左到右
    public List<List<Integer>> levelOrder(Node root) {
        Queue<Node> q1 =new LinkedList<>();
        List<List<Integer>> ret =new ArrayList<>();
        if(root ==null){
            return ret;
        }
        q1.add(root);
        while(!q1.isEmpty()){
            List<Integer> curl = new ArrayList<>();
            Queue<Node> next =new LinkedList<>();
            while(!q1.isEmpty()){
                Node cur = q1.peek();
                curl.add(q1.poll().data);

                if(cur.left!=null){
                    next.add(cur.left);
                }
                if(cur.right !=null){
                    next.add(cur.right);
                }
            }
            ret.add(curl);
            q1=next;
        }
        return ret;
    }
    //从下到上，从左到右
    public List<List<Integer>> levelOrderBottom(Node root) {
        Queue<Node> q1 =new LinkedList<>();
        List<List<Integer>> ret =new ArrayList<>();
        if(root ==null){
            return ret;
        }
        q1.add(root);
            List<Integer> curl = new ArrayList<>();

        return ret;
    }
    boolean isCompleteTree1 (Node root){
        Queue<Node> q1 =new LinkedList<>();
        q1.add(root);
        while(!q1.isEmpty()){
            Node cur = q1.peek();
            if(cur.left!=null){
                q1.add(cur.left);
            }
            if(cur.right!=null){
                q1.add(cur.right);
            }
            if(cur.left==null&&cur.right!=null){
                return false;
            }
            q1.poll();
        }
        return true;
    }
    boolean isCompleteTree (Node root){
        if(root==null){
            return true;
        }
        Queue<Node> q1 =new LinkedList<>();
        q1.add(root);
        while(!q1.isEmpty()){
            Node cur = q1.peek();
            if(cur==null){
                break;
            }else{
                q1.add(cur.left);
                q1.add(cur.right);
            }
            q1.poll();
        }
        //需要判断队列当中 是否有非空的元素
        while (!q1.isEmpty()) {
            //一个元素 一个元素 出队来判断 是不是空
            Node tmp = q1.peek();
            if(tmp == null) {
                q1.poll();
            }else {
                return false;
            }
        }
        return true;
    }
}
