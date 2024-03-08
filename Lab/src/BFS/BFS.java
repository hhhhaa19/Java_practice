package BFS;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Benjamin
 * Date: 2024-03-08
 * Time: 13:32
 */
class Coordinate {
    public int x;
    public int y;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val) {
        children = new ArrayList<>();
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};

public class BFS {
    private final static Coordinate[] ACTION = new Coordinate[]{
            new Coordinate(0, 1),
            new Coordinate(1, 0),
            new Coordinate(0, -1),
            new Coordinate(-1, 0)
    };

//    private static Queue<Node> getSuccessor(Coordinate state) {
//        Queue<Node> NodeQue = new ArrayDeque<Node>();
//        for (Coordinate curAction :
//                ACTION) {
//            int x = state.x;
//            int y = state.y;
//            int updateX = curAction.x + x;
//            int updateY = curAction.y + y;
//            if (updateY >= 0 && updateY <= 5 ) {
//
//            }
//        }
//
//    }

    //    public static Node breadthFirstSearch(Coordinate state) {
//
//    }
    public List<List<Integer>> levelOrder(Node root) {
        Queue<Node> queue = new ArrayDeque<Node>();
        Queue<Node> nextqueue = new ArrayDeque<Node>();
        queue.add(root);
        List<List<Integer>> ret = new ArrayList<>();
        while (!queue.isEmpty()) {
            List<Integer> curLevel = new ArrayList<>();
            nextqueue.clear();
            while (!queue.isEmpty()) {
                Node curnode = queue.poll();
                curLevel.add(curnode.val);
                for (Node curLevelNode : curnode.children) {
                    nextqueue.add(curLevelNode);
                }
            }
            ret.add(curLevel);
            queue.addAll(nextqueue);
        }
        return ret;
    }

    public static void main(String[] args) {
        Node a = new Node(1);
        Node b = new Node(3);
        Node c = new Node(2);
        Node d = new Node(4);
        Node e = new Node(5);
        Node f = new Node(6);
        a.children.add(b);
        a.children.add(c);
        a.children.add(d);
        b.children.add(e);
        b.children.add(f);
        new BFS().levelOrder(a);
    }
}
