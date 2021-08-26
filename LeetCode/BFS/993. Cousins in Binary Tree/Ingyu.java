import javax.swing.tree.TreeNode;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        boolean isExist = false;
        int sum = x + y;
        Set<TreeNode> set = new HashSet<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                TreeNode temp = queue.poll();

                if (temp.left != null) {
                    queue.offer(temp.left);
                    if (temp.left.val == x || temp.left.val == y) {
                        set.add(temp);
                        isExist = true;
                        sum -= temp.left.val;
                    }
                }
                if (temp.right != null) {
                    queue.offer(temp.right);
                    if (temp.right.val == x || temp.right.val == y) {
                        set.add(temp);
                        isExist = true;
                        sum -= temp.right.val;
                    }
                }
            }
            if (isExist == true && sum != 0) return false;
            else if (isExist == true && sum == 0 && set.size() == 2) return true;
        }

        return false;
    }
}