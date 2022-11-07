package Programmers.올바른괄호;

import java.util.Stack;

public class Sanghoo {

    public static void main(String[] args) {
        solution("()()");
    }

    static boolean solution(String s) {
        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                stack.push(ch);
            } else if (stack.empty()) {
                return false;
            } else {
                stack.pop();
            }
        }

        return stack.empty();
    }

}
