package BFS.Univalued_Binary_Tree;

import BFS.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * https://leetcode.com/problems/univalued-binary-tree/
 */
public class Sanghoo {

    public boolean isUnivalTree(TreeNode root) {
        Queue<TreeNode> q = new ArrayDeque<>();
        int value = 0;

        q.add(root);
        value = root.val;

        while(!q.isEmpty()) {
            TreeNode node = q.poll();

            if(value != root.val) return false;

            if(node.left != null) q.add(node.left);
            if(node.right != null) q.add(node.right);
        }

        return true;
    }

}
