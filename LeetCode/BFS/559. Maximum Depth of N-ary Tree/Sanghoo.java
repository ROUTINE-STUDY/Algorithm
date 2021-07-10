package BFS.Maximum_Depth_of_N_ary_Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Node {
    public int val;
    public List<Node> children;

    public Node() {}
    public Node(int _val) {
        val = _val;
    }
    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}
/**
 * https://leetcode.com/problems/maximum-depth-of-n-ary-tree/
 */
public class Sanghoo {

    public static int maxDepth(Node root) {
        if(root == null) return 0;

        int res = 0;
        Queue<Node> q = new LinkedList<>();

        q.offer(root);

        while (!q.isEmpty()) {
            int size = q.size();

            for(int i=0; i<size; i++) {
                Node node = q.poll();

                for(Node n : node.children) {
                    q.offer(n);
                }
            }
            res++;
        }

        return res;
    }

}
