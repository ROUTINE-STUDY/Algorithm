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

            if (head.left != null) {
                q.offer(head.left);
            }
            if (head.right != null) {
                q.offer(head.right);
            }
        }

        return root;
    }

}
