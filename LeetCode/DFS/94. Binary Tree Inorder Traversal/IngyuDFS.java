import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;

class Solution {
    List<Integer> answer = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) return answer;

        if (root.left == null && root.right == null) answer.add(root.val);
        if (root.left != null) inorderTraversal(root.left);
        if (root.right != null) inorderTraversal(root.right);

        return answer;
    }
}