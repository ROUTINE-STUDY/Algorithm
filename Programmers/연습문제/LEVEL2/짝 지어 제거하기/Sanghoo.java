package Programmers.짝지어제거하기;

import java.util.Stack;

public class Sanghoo {

    public static void main(String[] args) {
        solution("baabaa");
    }

    public static int solution(String s) {
        int answer = 0;
        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (!stack.empty() && stack.peek() == ch) {
                stack.pop();
            } else {
                stack.push(ch);
            }
        }

        if (stack.empty()) {
            answer = 1;
        }

        return answer;
    }
}
