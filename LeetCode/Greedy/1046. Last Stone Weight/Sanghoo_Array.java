package Greedy.Last_Stone_Weight;

import java.util.Arrays;
import java.util.Stack;

/**
 *  https://leetcode.com/problems/last-stone-weight/
 */
public class Sanghoo_Array {

    // Stack을 이용한 방법을 배열 방식으로 변경, 전체적인 로직은 동일하고 리팩토링 적용
    public static int lastStoneWeight(int[] stones) {
        Arrays.sort(stones);

        while(stones.length > 1) {
            int n = stones[stones.length-1] - stones[stones.length-2];

            stones[stones.length-2] = n;
            stones = Arrays.copyOf(stones, stones.length-1);

            if(stones.length == 0) return 0;
            Arrays.sort(stones);
        }

        return stones[0];
    }

    public static void main(String[] args) {
//        int[] stones = {2,7,4,1,8,1};
        int[] stones = {2,2};
        System.out.println(lastStoneWeight(stones));
    }
}
