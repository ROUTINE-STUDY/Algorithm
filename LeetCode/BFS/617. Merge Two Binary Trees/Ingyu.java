import javax.swing.tree.TreeNode;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        Queue q = new LinkedList();
        if (root1 == null && root2 == null) {
            return null;
        }

        if (root2 == null) {
            return root1;
        } else if (root1 == null) {
            return root2;
        }

        q.offer(root1);
        q.offer(root2);



        while (!q.isEmpty()) {
            TreeNode temp1 = (TreeNode)q.poll();
            TreeNode temp2 = (TreeNode)q.poll();

            temp1.val += temp2.val;

            if (temp2.left == null) {

            } else if (temp1.left == null) {
                temp1.left = temp2.left;
            } else if (temp1 != null && temp2 != null) {
                q.offer(temp1.left);
                q.offer(temp2.left);
            }

            if (temp2.right == null) {
                continue;
            } else if (temp1.right == null) {
                temp1.right = temp2.right;
            } else if (temp1.right != null && temp2.right != null) {
                q.offer(temp1.right);
                q.offer(temp2.right);
            }
        }

        return root1;
    }
}