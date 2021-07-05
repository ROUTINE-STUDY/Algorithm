package BFS.Invert_Binary_Tree;

import java.util.LinkedList;
import java.util.Queue;


/**
 * https://leetcode.com/problems/invert-binary-tree/
 */
public class Sanghoo {

    public static TreeNode invertTree(TreeNode root) {
        if(root == null) return null;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            int size = q.size();

            for(int i=0; i<size; i++) {
                TreeNode node = q.poll();

                if(node.left != null && node.right != null) {
                    q.offer(node.right);
                    q.offer(node.left);

                    TreeNode temp = node.left;
                    node.left = node.right;
                    node.right = temp;
                } else if(node.left != null) {
                    q.offer(node.left);

                    node.right = node.left;
                    node.left = null;
                } else if(node.right != null) {
                    q.offer(node.right);

                    node.left = node.right;
                    node.left = null;
                }
            }
        }

        return root;
    }

}
