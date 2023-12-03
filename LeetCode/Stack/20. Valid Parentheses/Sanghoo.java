package LeetCode.easy.ValidParentheses;

import java.util.Stack;

public class Sanghoo {

    public static void main(String[] args) {
        isValid("{[]}");
    }

    public static boolean isValid(String s) {
        if (s.length() % 2 == 1) return false;

        Stack<Character> openStack = new Stack<>();

        for (char ch : s.toCharArray()) {
            if ("{[(".contains(String.valueOf(ch))) {
                openStack.push(ch);
            } else {
                if (openStack.isEmpty()) return false;

                Character openChar = openStack.peek();
                if (openChar == '{' && ch == '}') {
                    openStack.pop();
                } else if (openChar == '(' && ch == ')') {
                    openStack.pop();
                } else if (openChar == '[' && ch == ']') {
                    openStack.pop();
                } else {
                    return false;
                }
            }
        }

        return openStack.isEmpty();
    }
}
