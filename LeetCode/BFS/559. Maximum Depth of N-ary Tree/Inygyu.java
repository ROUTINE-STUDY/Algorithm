import org.w3c.dom.Node;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int maxDepth(Node root) {
        Queue<Node> q = new LinkedList<>();
        int depth = 0;
        if (root == null) return 0;
        q.offer(root);


        while (!q.isEmpty()) {
            depth++;
            int size = q.size();

            while (size-- > 0) {
                Node node = q.poll();
                for (Node child : node.children) {
                    q.offer(child);
                }
            }
        }

        return depth;
    }
}