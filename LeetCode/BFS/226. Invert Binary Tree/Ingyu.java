class Solution {
    public TreeNode invertTree(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        if (root == null) {
            return null;
        }
        q.offer(root);

        while (!q.isEmpty()) {
            TreeNode head = q.poll();

            TreeNode temp = head.left;
            head.left = head.right;
            head.right = temp;

            if (!isNull(head.left)) {
                q.offer(head.left);
            }
            if (!isNull(head.right)) {
                q.offer(head.right);
            }
        }

        return root;
    }

    public boolean isNull(TreeNode node) {
        if (node == null) {
            return true;
        }

        return false;
    }
}
