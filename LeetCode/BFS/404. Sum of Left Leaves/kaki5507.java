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
    public int sumOfLeftLeaves(TreeNode root) {
        if(root == null){
            return 0;
        }
        
        Queue<TreeNode> q = new LinkedList();
        
        q.offer(root);
        
        int sum=0;
        
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0; i<size; i++){
                TreeNode node = q.poll();
                if(node.left.left == null && node.left.right == null){
                    sum+=node.left.val;   
                }
                
                if(node.left != null){ q.offer(node.left);}
                if(node.right != null){q.offer(node.right);}
                
            }
        }
        
        return sum;
    }
}