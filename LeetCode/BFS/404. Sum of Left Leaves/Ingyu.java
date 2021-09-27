import javax.swing.tree.TreeNode;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root.left == null && root.right == null) return 0;
        int answer = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();

            if (temp.left != null) {
                queue.offer(temp.left);
                if (temp.left.left == null && temp.left.right == null) answer += temp.left.val;
            }
            if (temp.right != null) queue.offer(temp.right);
        }

        return answer;
    }
}