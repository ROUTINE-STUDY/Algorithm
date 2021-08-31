import javax.swing.tree.TreeNode;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public boolean isUnivalTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int value = queue.peek().val;
        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.val != value) return false;

            if (node.left != null) queue.offer(node.left);
            if (node.right != null) queue.offer(node.right);
        }

        return true;
    }
}