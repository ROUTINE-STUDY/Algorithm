package BFS.Binary_Tree_Zigzag_Level_Order_Traversal;

import java.util.*;

/**
 * https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
 */
public class Sanghoo {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root == null) return new ArrayList<>();

        List<Integer> list = null;
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        Queue<TreeNode> q2 = new LinkedList<>();

        int count = 0;
        q.offer(root);
        q2.offer(root);

        while(!q.isEmpty()) {
            list = new ArrayList<>();
            int size = q.size();

            for(int i=0; i<size; i++) {
                TreeNode node = q.poll();
                TreeNode node2 = q2.poll();

                // depth가 짝수일땐 정상, 홀수일땐 역으로 탐색하여 지그재그 구현
                if(count%2 == 0) {
                    list.add(node.val);
                } else {
                    list.add(node2.val);
                }

                // 첫 번째 큐에는 정상 BFS 탐색 흐름
                if(node.left != null) q.offer(node.left);
                if(node.right != null) q.offer(node.right);

                // 두 번째 큐에는 역 BFS 탐색 흐름
                if(node2.right != null) q2.offer(node2.right);
                if(node2.left != null) q2.offer(node2.left);
            }
            count++;
            res.add(list);
        }

        return res;
    }

}
