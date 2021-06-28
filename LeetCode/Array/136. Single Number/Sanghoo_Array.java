package Array.Single_Number;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/single-number/
 */
public class Sanghoo_Array {

    // 최고의 답은 뭘까요.. 여러분..
    public static int singleNumber(int[] nums) {
        if(nums.length == 1) return nums[0];

        // 배열을 정렬해서 양 옆과 모두 다르다면 Single Number
        Arrays.sort(nums);
        for(int i=1; i<nums.length-1; i++) {
            int n = nums[i];
            if(n != nums[i-1] && n != nums[i+1]) {
                return nums[i];
            }
        }

        // 위의 로직을 통과했다면, 양 끝값 중 하나
        return (nums[0] == nums[1]) ? nums[nums.length-1] : nums[0];

    }
    public static void main(String[] args) {
        int[] nums = {-4,1,2,1,2};
        System.out.println(singleNumber(nums));
    }
}
