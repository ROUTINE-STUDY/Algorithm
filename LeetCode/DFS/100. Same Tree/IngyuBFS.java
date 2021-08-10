import javax.swing.tree.TreeNode;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        Queue<TreeNode> queue = new LinkedList<>();

        if (p == null && q == null) return true;
        if (p != null) queue.offer(p);
        if (q != null) queue.offer(q);
        if (queue.size() % 2 != 0)  return false;

        while (!queue.isEmpty()) {
            TreeNode temp1 = queue.peek();
            TreeNode temp2 = queue.peek();

            if (temp1.val != temp2.val) return false;

            if (temp1.left != null) queue.offer(temp1.left);
            if (temp2.left != null) queue.offer(temp2.left);
            if (queue.size() % 2 != 0) return false;


            if (temp1.right != null) queue.offer(temp1.right);
            if (temp2.right != null) queue.offer(temp2.right);
            if (queue.size() % 2 != 0) return false;
        }

        return true;
    }
}