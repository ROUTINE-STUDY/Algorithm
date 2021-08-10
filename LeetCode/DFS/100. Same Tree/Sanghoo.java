package DFS.Same_Tree;

import java.util.Stack;

/**
 * https://leetcode.com/problems/same-tree/
 */
public class Sanghoo {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        // 모두 null이면 true
        if(p == null && q == null) return true;
        // 위에서 모두 null이 아님을 확인했으니, 하나라도 null이면 false
        if(p == null || q == null) return false;

        Stack<TreeNode> stack = new Stack<>();

        stack.push(p);
        stack.push(q);

        while(!stack.isEmpty()) {
            TreeNode p1 = stack.pop();
            TreeNode p2 = stack.pop();

            // 값이 다르면 당연히 false
            if(p1.val != p2.val) return false;

            // 좌측 자식노드가 존재하면 넣음
            // 이때 두 트리 모두 존재햐아하므로 삽입 후 스택의 크기로 검증(두 트리 모두 자식이 있는지)
            if(p1.left != null) stack.push(p1.left);
            if(p2.left != null) stack.push(p2.left);
            if(stack.size() % 2 != 0) return false;

            // 우측도 위와 동일
            if(p1.righ != null) stack.push(p1.right);
            if(p2.right != null) stack.push(p2.right);
            if(stack.size() % 2 != 0) return false;
        }

        return true;
    }

}
