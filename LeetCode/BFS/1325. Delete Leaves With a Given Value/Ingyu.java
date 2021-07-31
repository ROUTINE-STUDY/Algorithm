import javax.swing.tree.TreeNode;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class Solution {
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        Queue<TreeNode> q = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        q.offer(root);

        while (!q.isEmpty()) {
            TreeNode temp = q.poll();

            if (temp.left != null) {
                q.offer(temp.left);
                if (temp.left.val == target) stack.push(temp);
            }
            if (temp.right != null) {
                q.offer(temp.right);
                if (temp.right.val == target) stack.push(temp);
            }
        }

        while (!stack.isEmpty()) {
            TreeNode temp = stack.pop();

            if (temp.left != null && temp.left.val == target) {
                if (temp.left.left == null && temp.left.right == null) {
                    temp.left = null;
                }
            }
            if (temp.right != null && temp.right.val == target) {
                if (temp.right.left == null && temp.right.right == null) {
                    temp.right = null;
                }
            }
        }

        if (root.left == null && root.right == null && root.val == target) {
            root = null;
        }

        return root;
    }
}