package Q2;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Benjamin
 * Date: 2024-05-19
 * Time: 14:59
 */
public abstract class AbstractTreeNode {
    int value;
    AbstractTreeNode parent;

    public AbstractTreeNode(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

    public AbstractTreeNode getParent() {
        return this.parent;
    }

    // return the list of child nodes
    public abstract AbstractTreeNode[] getChildren();
}

class MyBTreeNode extends AbstractTreeNode {
    MyBTreeNode[] children=new MyBTreeNode[2];
    int childLength = 0;
    public MyBTreeNode(int value) {
        super(value);
    }

    public void setChildren(MyBTreeNode[] children) {
        if (children.length > 2) {
            System.out.println("to many children");
            return;
        }
        this.children = children;
        this.childLength = children.length;
    }

    public AbstractTreeNode[] getChildren() {
        return this.children;
    }

    public boolean addChild(AbstractTreeNode node) {
        if (this.childLength >= 2) {
            return false;
        }
        children[this.childLength] = (MyBTreeNode) node;
        this.childLength++;
        return true;
    }

    public boolean hasValue(int value) {
        if (this.value == value) {
            return true;
        }
        Queue<MyBTreeNode> queue = new LinkedList<MyBTreeNode>();
        queue.add(this);
        while (!queue.isEmpty()) {
            MyBTreeNode curNode = queue.poll();
            if (curNode.value == value) {
                return true;
            }
            for (int i = 0; i < curNode.childLength; i++) {
                queue.add(curNode.children[i]);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        MyBTreeNode root = new MyBTreeNode(1);
        root.addChild(new MyBTreeNode(2));
        root.addChild(new MyBTreeNode(3));
        System.out.println(root.addChild(new MyBTreeNode(4)));
        root.children[0].addChild(new MyBTreeNode(2));
        root.children[1].addChild(new MyBTreeNode(4));
        System.out.println(root.hasValue(3));
        System.out.println(root.hasValue(5));
    }
}
