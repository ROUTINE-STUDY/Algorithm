package Array.Minimize_Maximum_Pair_Sum_in_Array;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/minimize-maximum-pair-sum-in-array/
 */
public class Sanghoo {

    public int minPairSum(int[] nums) {
        int res = 0;
        int sum = 0;

        Arrays.sort(nums);

        // 각 끝 값들 중 최대값 반환
        for(int i=0; i<nums.length/2; i++) {
            sum = nums[i] + nums[nums.length-1-i];
            if(res < sum) res = sum;
        }

        return res;
    }

}
