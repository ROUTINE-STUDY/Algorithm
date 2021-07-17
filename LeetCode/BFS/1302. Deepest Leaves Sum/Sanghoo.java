package BFS.Deepest_Leaves_Sum;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/deepest-leaves-sum/
 */
public class Sanghoo {

    public int deepestLeavesSum(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        int res = 0;

        q.add(root);

        while(!q.isEmpty()) {
            int size = q.size();
            res = 0;    // 마지막 depth를 위해 초기화

            for(int i=0; i<size; i++) {
                TreeNode node = q.poll();

                if(node.left != null) q.add(node.left);
                if(node.right != null) q.add(node.right);

                res += node.val;
            }
        }
        return res;
    }

}
