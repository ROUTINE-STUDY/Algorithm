package BFS.Cousins_in_Binary_Tree;

import java.util.*;

/**
 * https://leetcode.com/problems/cousins-in-binary-tree/
 */
public class Sanghoo {

    // Set의 특징을 이용한 풀이(중복을 허용하지 않음)
    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode> q = new LinkedList<>();
        Set<TreeNode> setParent = new HashSet<>();
        Set<Integer> setDepth = new HashSet<>();
        int depth = 0;

        q.add(root);

        while(!q.isEmpty()) {
            int size = q.size();

            for(int i=0; i<size; i++) {
                TreeNode node = q.poll();

                if(node.left != null) {
                    if(node.left.val == x || node.left.val == y) {
                        setParent.add(node);
                        setDepth.add(depth);
                    }
                    q.add(node.left);
                }

                if(node.right != null) {
                    if(node.right.val == x || node.right.val == y) {
                        setParent.add(node);
                        setDepth.add(depth);
                    }
                    q.add(node.right);
                }
            }
            depth++;
        }

        // 부모가 달라야한다, 깊이는 같아야한다
        if(setParent.size() < 2 || setDepth.size() > 1) return false;

        return true;
    }

}
