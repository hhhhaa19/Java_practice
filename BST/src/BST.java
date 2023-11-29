/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王金涛
 * Date: 2023-11-29
 * Time: 14:26
 */
public class BST {
    public static class BSTNode {
        int data;
        BSTNode left;
        BSTNode right;

        public BSTNode(int data) {
            this.data = data;
        }
    }

    public BSTNode root = null;

    public BSTNode Search(int val) {
        BSTNode cur = root;
        while (cur != null) {
            if (val == cur.data) {
                return cur;
            } else if (val < cur.data) {
                cur = cur.left;
            } else {
                cur = cur.right;
            }
        }
        //没找到
        return null;
    }

    public boolean insert(int val) {
        BSTNode newNode = new BSTNode(val);
        if (root == null) {
            root = newNode;
        }
        BSTNode cur = root;
        BSTNode parent = root;
        while (cur != null) {
            if (val == cur.data) {
                //相同数只存一个
                return false;
            } else if (val < cur.data) {
                parent = cur;
                cur = cur.left;
            } else {
                parent = cur;
                cur = cur.right;
            }
        }
        if (val > parent.data) {
            parent.right = newNode;
        } else {
            parent.left = newNode;
        }
        return true;
    }

    public boolean delete(int val) {
        BSTNode cur = root;
        //因为要改变当前节点，所以要parent
        BSTNode parent = null;
        while (cur != null && cur.data != val) {
            if (cur.data > val) {
                parent = cur;
                cur = cur.left;
            } else {
                parent = cur;
                cur = cur.right;
            }
        }
        if (cur == null) {
            //找不
            return false;
        }
        //开始删除
        if (cur.left == null) {
            if (cur == root) {
                root = cur.right;
            } else if (cur == parent.left) {
                parent.left = cur.right;
            } else {
                parent.right = cur.right;
            }
        } else if (cur.right == null) {
            if (cur == root) {
                root = cur.left;
            } else if (cur == parent.right) {
                parent.right = cur.left;
            } else {
                parent.left = cur.left;
            }
        } else {
            //采用替换法，找左边最大或者右边最小，与之交换
            BSTNode min = cur.right;
            BSTNode minParent = cur;

            while (min.left != null) {
                minParent = min;
                min = min.left;
            }
            cur.data = min.data;
            if(minParent.left== min){
                minParent.left = min.right;
            }else{
                //防止min.left直接就是空
                minParent.right = min.right;
            }

        }
        return true;
    }
}