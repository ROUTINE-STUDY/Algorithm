package Greedy.Array_Partition_I;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/array-partition-i/
 */
public class Sanghoo {

    public int arrayPairSum(int[] nums) {
        int maxSum = 0;

        Arrays.sort(nums);

        for(int i=0; i<nums.length; i+=2) {
            maxSum += nums[i];
        }

        return maxSum;
    }

}
