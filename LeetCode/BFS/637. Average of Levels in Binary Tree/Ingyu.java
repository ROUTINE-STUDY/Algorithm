class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> answerList = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()) {
            int size = q.size();
            int temp = size;
            double sum = 0;
            while (temp-- > 0) {
                TreeNode node = q.poll();
                sum += node.val;
                if (node.left != null) {
                    q.offer(node.left);
                }
                if (node.right != null) {
                    q.offer(node.right);
                }
            }
            answerList.add(sum/size);
        }

        return answerList;
    }
}
