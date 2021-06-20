package Greedy.Last_Stone_Weight;

import java.util.Arrays;
import java.util.Stack;

/**
 *  https://leetcode.com/problems/last-stone-weight/
 */
public class Sanghoo_Stack {

    public static int lastStoneWeight(int[] stones) {
        Stack<Integer> stack = new Stack<Integer>();

        Arrays.sort(stones);
        for(int i:stones) {
            stack.push(i);
        }

        while(stack.size() > 1) {
            stack.push(stack.pop() - stack.pop());
            stack = sortStack(stack); // 재정렬 후 반복(스택|배열 재정렬)
        }

        return stack.pop();
    }

    public static Stack<Integer> sortStack(Stack<Integer> origin) {
        Stack<Integer> sortedStack = new Stack<Integer>();

        while(!origin.isEmpty()) {
            int n = origin.pop();

            while(!sortedStack.isEmpty() && (sortedStack.peek() > n)) {
                origin.push(sortedStack.pop());
            }
            sortedStack.push(n);
        }

        return sortedStack;
    }

    public static void main(String[] args) {
        int[] stones = {2,7,4,1,8,1};
        System.out.println(lastStoneWeight(stones));
    }

}
