package DFS.Binary_Tree_Inorder_Traversal;

import java.util.ArrayList;
import java.util.List;

public class Sanghoo {

    // return 을 위한 인스턴스 변수 선언
    public List<Integer> res = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        if(root == null) return res;

        if(root.left != null) inorderTraversal(root.left);
        res.add(root.val);  // 중위 순회이므로 왼쪽 노드 체크 후 값 추가
        if(root.right != null) inorderTraversal(root.right);

        return res;
    }

}
