import javax.xml.soap.Node;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王金涛
 * Date: 2023-11-02
 * Time: 14:51
 */
public class test {
    public static void main1(String[] args) {
        BinaryTree bt = new BinaryTree();
        BinaryTree.Node node1 =new BinaryTree.Node(32);
        BinaryTree.Node node2 =new BinaryTree.Node(31);
        BinaryTree.Node node3 =new BinaryTree.Node(30);
        BinaryTree.Node node4 =new BinaryTree.Node(29);
        BinaryTree.Node node5 =new BinaryTree.Node(28);
        node1.left=node2;
        node1.right=node3;
        node2.left=node4;
        node3.right=node5;
        System.out.println(bt.size(node1));
        System.out.println(bt.getLeafNodeCount(node1));
        System.out.println(bt.getKLevelNodeCount(node1, 3));
        System.out.println(bt.getHeight(node1));
        System.out.println(bt.find(node1,32));
        System.out.println(bt.preorderTraversal(node1));
    }

    public static void main2(String[] args) {
        BinaryTree bt = new BinaryTree();
        BinaryTree.Node node1 =new BinaryTree.Node(32);
        BinaryTree.Node node2 =new BinaryTree.Node(31);
        BinaryTree.Node node3 =new BinaryTree.Node(30);
        BinaryTree.Node node4 =new BinaryTree.Node(29);
        BinaryTree.Node node5 =new BinaryTree.Node(28);
        node1.left=node2;
        node1.right=node3;
        node2.left=node4;
        node3.right=node5;
        System.out.println(bt.levelOrder(node1));
    }


}
