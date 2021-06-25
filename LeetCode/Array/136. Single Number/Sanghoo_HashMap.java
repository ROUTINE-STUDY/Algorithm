package Array.Single_Number;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * https://leetcode.com/problems/single-number/
 */
public class Sanghoo_HashMap {

    // HashMap을 이용한 방법.
    // 각 원소의 개수를 구한 후, 개수가 1인 값 return
    public static int singleNumber(int[] nums) {
        if(nums.length == 1) return nums[0];

        HashMap<Integer, Integer> hs = new HashMap<Integer, Integer>();
        for(int n : nums) {
            hs.put(n, hs.getOrDefault(n, 0)+1);
        }

        // Map 탐색하는 첫 번째 방법
        for (Map.Entry<Integer, Integer> entry : hs.entrySet()) {
            if(entry.getValue() == 1) {
                return entry.getKey().intValue();
            }
        }

        // Map 탐색하는 두 번째 방법
        /*
        Iterator<Map.Entry<Integer, Integer>> it = hs.entrySet().iterator();
        while(it.hasNext()) {
            Map.Entry<Integer, Integer> entry = it.next();
            if(entry.getValue() == 1) {
                return entry.getKey().intValue();
            }
        }
        */

        return 0;
    }
    public static void main(String[] args) {
        int[] nums = {4,1,2,1,2};
        System.out.println(singleNumber(nums));
    }
}
