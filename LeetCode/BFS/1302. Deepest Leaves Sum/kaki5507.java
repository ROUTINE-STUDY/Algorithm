/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int deepestLeavesSum(TreeNode root) {
        int total = 0;
        if(root == null){return 0;}
        
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        
        q.offer(root);
        
        while(!q.isEmpty()){
            int size = q.size();
            total=0;
            for(int i=0; i<size; i++){
                TreeNode node = q.poll();
                total+=node.val;
                if(node.left != null){q.offer(node.left);}
                if(node.right != null){q.offer(node.right);}
            }
        }
        
        return total;
    }
}