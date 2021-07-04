package BFS.Maximum_Depth_of_Binary_Tree;

import java.util.ArrayDeque;
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

public class Sanghoo {

    public static int maxDepth(TreeNode root) {
        if(root == null) return 0;

        Queue<TreeNode> queue = new ArrayDeque();
        int count = 0;

        queue.offer(root);  // root 노드 삽입

        while(!queue.isEmpty()) {
            int size = queue.size();    // 큐 사이즈는 안쪽 for문 안에서 변하므로 안쪽 for문 전 고정

            // 노드를 하나씩 꺼내(선입선출) 자식 노드들이 있으면 큐에 삽입
            for(int i=0; i<size; i++) {
                TreeNode node = queue.poll();
                if(node.left != null) {
                    queue.offer(node.left);
                }
                if(node.right != null) {
                    queue.offer(node.right);
                }
            }

            count++; // 안쪽 for문 당 1 depth 추가, 그림으로 이해하는게 빠른듯
        }
        return count;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3,
                        new TreeNode(9, null, null),
                        new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        System.out.println(maxDepth(root));
    }
}
