import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};

class Solution {
    public List<Integer> preorder(Node root) {
        List<Integer> answer =  new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        if (root == null) return answer;
        stack.push(root);

        while (!stack.isEmpty()) {
            Node temp = stack.pop();
            answer.add(temp.val);

            for (int i = temp.children.size() - 1; i >= 0; i--) {
                stack.push(temp.children.get(i));
            }
        }

        return answer;
    }
}