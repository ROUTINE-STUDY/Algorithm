import javax.swing.tree.TreeNode;
import java.util.Stack;

class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        Stack<TreeNode> stack = new Stack<>();

        if (p == null && q == null) return true;
        if (p != null) stack.push(p);
        if (q != null) stack.push(q);

        // 짝수 개가 아니면 하나는 null
        if (stack.size() % 2 != 0)  return false;

        while (!stack.isEmpty()) {
            TreeNode temp1 = stack.pop();
            TreeNode temp2 = stack.pop();

            if (temp1.val != temp2.val) return false;

            if (temp1.left != null) stack.push(temp1.left);
            if (temp2.left != null) stack.push(temp2.left);
            if (stack.size() % 2 != 0) return false;

            if (temp1.right != null) stack.push(temp1.right);
            if (temp2.right != null) stack.push(temp2.right);
            if (stack.size() % 2 != 0) return false;
        }

        return true;
    }
}