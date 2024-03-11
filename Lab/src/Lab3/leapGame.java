package Lab3;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Benjamin
 * Date: 2024-03-11
 * Time: 9:59
 */

public class leapGame {
    private int goal;//目标下标
    private int[] list;
    private int step;

    public leapGame(int[] arr, int step) {
        this.list = arr;
        goal = arr.length - 1;
        this.step = step;
    }

    public boolean isGoal(int state) {
        return state >= goal;
    }

    public Set<Integer> getSuccessor(int state) {
        Set<Integer> ret = new HashSet<>();
        int i = state;
        //第一种情况，向前遍历所有0，这边不应该用循环->一个action只变一个
        if (i < list.length && list[++i] == 0) {
            ret.add(i);
        }
        i = state;
        //向后遍历
        if (i > 0 && list[--i] == 0) {
            ret.add(i);
        }
        //跳跃n
        i = state;
        if ((i + step) <= list.length - 1 && list[i + step] == 0) {
            i += step;
            ret.add(i);
        }
        if (i + step > list.length) {
            ret.add(i + step);
        }

        //返回所有 棋子 所在下标的可能性,用set避免重复
        return ret;
    }

    class Node {
        int state;
        Node parent;

        public Node(int state) {
            this.state = state;
        }

        public Node(int state, Node parent) {
            this.state = state;
            this.parent = parent;
        }
    }

    public Node BFS(int init) {
        Queue<Node> queue = new ArrayDeque<>();
        //Set<Integer> set = new HashSet<>();//用一个集合记录达到过的state
        queue.add(new Node(init));
        while (!queue.isEmpty()) {
            Node curnode = queue.poll();
            //set.add(curnode.state);
            if (isGoal(curnode.state)) {
                return curnode;
            }
            Set<Integer> successors = getSuccessor(curnode.state);
            for (Integer successor : successors) {
//                if (!set.contains(successor)) {
//                    queue.add(new Node(successor, curnode));
//                }
                queue.add(new Node(successor, curnode));
            }
        }
        return null;
    }
    public Node DFS(int init) {
        Stack<Node> stack = new Stack<>();
        Set<Integer> set = new HashSet<>();//用一个集合记录达到过的state
        stack.add(new Node(init));
        while (!stack.isEmpty()) {
            Node curnode = stack.pop();
            set.add(curnode.state);
            if (isGoal(curnode.state)) {
                return curnode;
            }
            Set<Integer> successors = getSuccessor(curnode.state);
            for (Integer successor : successors) {
                if (!set.contains(successor)) {
                    stack.add(new Node(successor, curnode));
                }
            }
        }
        return null;
    }
    public List<Integer> getPath(Node node) {
        List<Integer> ret = new ArrayList<>();
        while (node != null) {
            ret.add(node.state);
            node = node.parent;
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] arr = {0, 0, 1, 1, 0, 1, 0, 0, 1, 0, 0, 0, 1};
        leapGame leapGame1 = new leapGame(arr, 3);
        Node leaf = leapGame1.BFS(0);
        for (Integer cur : leapGame1.getPath(leaf)) {
            System.out.print(cur + " ");
        }
    }
}
