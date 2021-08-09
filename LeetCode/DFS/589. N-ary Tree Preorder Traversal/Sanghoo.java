package DFS.N_ary_Tree_Preorder_Traversal;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/n-ary-tree-preorder-traversal/
 */
public class Sanghoo {

    // return 객체 인스턴스 변수로 생성
    public List<Integer> res = new ArrayList<>();

    // dfs 재귀를 이용하여 구현
    public List<Integer> preorder(Node root) {
        dfs(root);
        return res;
    }

    // 기존 DFS는 방문 노드를 체크하는 로직이 들어가지만,
    // 위 문제에서는 같은 값의 노드가 존재하고 탐색 순서만 묻는 문제이므로, 방문여부 체크로직 삭제
    public void dfs(Node root) {
        if(root == null) return;

        res.add(root.val);

        for(Node node : root.children) {
            dfs(node);
        }
    }

}
