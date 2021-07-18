package BFS.Binary_Tree_Level_Order_Traversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Sanghoo {

    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list;

        if(root == null) return res;        // 비어있는 노드라면 return

        q.offer(root);

        // 기본 BFS 탐색 로직 유지, return 타입에 맞게 탐색 depth 당 list를 초기화 후 데이터를 담고, res에 추가하는 방식
        while(!q.isEmpty()) {
            int size = q.size();
            list = new ArrayList<>();

            for(int i=0; i<size; i++) {
                TreeNode node = q.poll();
                list.add(node.val);

                if(node.left != null) q.offer(node.left);
                if(node.right != null) q.offer(node.right);
            }

            res.add(list);
        }

        return res;
    }

}
