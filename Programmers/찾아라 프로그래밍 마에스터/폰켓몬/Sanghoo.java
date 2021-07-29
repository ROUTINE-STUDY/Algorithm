package Programmers.폰켓몬;

import java.util.HashSet;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/1845
 */
public class Sanghoo {

    // 중복을 허용하지 않는 Set이용
    public int solution(int[] nums) {
        HashSet<Integer> set = new HashSet<>();     // set.size() : 폰켓몬 종류의 수
        int maxCount = nums.length/2;

        for(int num : nums) {
            set.add(num);
        }

        // set.size()가 maxCount 보다 크거나 같다면 maxCount -> 종류가 많아도 데려갈 수에 제한
        // set.size()가 maxCount 보다 작다면 set.size() -> 데려갈 수가 많아도 종류에 제한한
       return maxCount <= set.size() ? maxCount : set.size();
    }
}
