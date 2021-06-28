package Array.Single_Number;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/single-number/
 */
public class Sanghoo_For {

    // 방법 다양할 것으로 예상.
    // 가장 기본적인 for문을 이용하여 구현(배열을 2중으로 탐색하므로 성능 저하)
    public static int singleNumber(int[] nums) {
        if(nums.length == 1) return nums[0];

        for(int i=0; i<nums.length; i++) {
            int standard = nums[i];
            boolean isSingle = true;
            for(int j=0; j<nums.length; j++) {
                int num = nums[j];
                if(standard == num && i != j) {
                    isSingle = false;
                    break;
                }
            }
            if(isSingle) return nums[i];
        }

        return 0;
    }
    public static void main(String[] args) {
        int[] nums = {4,1,2,1,2};
        System.out.println(singleNumber(nums));
    }
}
