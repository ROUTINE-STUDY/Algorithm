package BFS.Merge_Two_Binary_Trees;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/merge-two-binary-trees/
 */

public class Sanghoo {

    // 하나의 TreeNode를 기준으로 잡고 비교하여 검사
    public static TreeNode mergeTrees(TreeNode root1, TreeNode root2) {

        if(root1 == null && root2 == null) return null;
        else if(root1 != null && root2 == null) return root1;
        else if(root1 == null && root2 != null) return root2;

        Queue<TreeNode> q = new LinkedList<>();
        Queue<TreeNode> q2 = new LinkedList<>();

        // root 는 무조건 존재하므로 세팅
        q.offer(root1);
        q2.offer(root2);
        root1.val += root2.val;

        while(!q.isEmpty()) {
            int size = q.size();

            for(int i=0; i<size; i++) {
                TreeNode node1 = q.poll();
                TreeNode node2 = q2.poll();

                // 둘 다 있거나 or 한 쪽만 있거나
                // left가 두 Tree에 모두 존재하면 큐에 모두 삽입 후 left.val 세팅
                if(node1.left != null && node2.left != null) {
                    q.offer(node1.left);
                    q2.offer(node2.left);

                    node1.left.val += node2.left.val;
                } else if(node1.left == null) { // 한 쪽만 있으면 있는 쪽 세팅
                    node1.left = node2.left;
                }

                // 로직은 위와 동일함(right)
               if(node1.right != null && node2.right != null) {
                    q.offer(node1.right);
                    q2.offer(node2.right);

                    node1.right.val += node2.right.val;
                } else if(node1.right == null) {
                    node1.right = node2.right;
                }
            }
        }

        return root1;
    }

    public static void main(String[] args) {

    }

}
