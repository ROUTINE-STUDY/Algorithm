package BFS.Sum_of_Nodes_with_Even_Valued_Grandparent;

import java.util.LinkedList;
import java.util.Queue;

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

/**
 * https://leetcode.com/problems/sum-of-nodes-with-even-valued-grandparent/
 */
public class Sanghoo {

    public int sumEvenGrandparent(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        Queue<TreeNode> q2 = new LinkedList<>();
        int res = 0;
        q.add(root);
        
        // 현재 노드가 짝수이면 그 자식을 q2에 담는다
        while (!q.isEmpty()) {
            int size = q.size();
            for(int i=0; i<size; i++) {
                TreeNode node = q.poll();

                if(node.left != null) q.add(node.left);
                if(node.right != null) q.add(node.right);
                
                if(node.val % 2 == 0) {
                    if(node.left != null) q.add(node.left);
                    if(node.right != null) q.add(node.right);
                }
            }
        }
        
        // q2 노드들을 다 꺼내서 그 자식들의 val을 더한다
        while(!q2.isEmpty()) {
            TreeNode node = q2.poll();

            if(node.left != null) res += node.left.val;
            if(node.right != null) res += node.right.val;
        }

        return res;
    }

}
