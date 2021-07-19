class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
o
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> answerList = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) {
            queue.offer(root);

            while (!queue.isEmpty()) {
                int size = queue.size();

                List<Integer> answer = new ArrayList<>();
                while (size-- > 0) {
                    TreeNode node = queue.poll();
                    answer.add(node.val);

                    if (node.left != null) queue.offer(node.left);
                    if (node.right != null) queue.offer(node.right);
                }

                answerList.add(answer);
            }
        }

        return answerList;
    }
}