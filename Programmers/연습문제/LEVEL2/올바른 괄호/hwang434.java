import java.util.Stack;

class Solution {
    boolean solution(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(c);
                continue;
            }

            if (stack.isEmpty() || stack.pop() != '(') {
                return false;
            }
        }

        return stack.size() == 0;
    }
}