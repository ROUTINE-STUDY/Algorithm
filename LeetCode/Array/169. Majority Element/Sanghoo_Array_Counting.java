package Array.Majority_Element;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;

public class Sanghoo_Array_Counting {

    // 배열 정렬 후 순서대로 카운팅하여 nums.length/2 보다 많이 카운팅 되는 수 반환
    public static int majorityElement(int[] nums) {
        int res = 0;
        int count = 0;
        int count_number = nums[0];

        Arrays.sort(nums);

        for(int n : nums) {
            if(count_number == n) {
                count++;
                if(count > nums.length / 2) {
                    res = count_number;
                    break;
                }
            } else {
                count_number = n;
                count = 1;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(majorityElement(new int[]{-1,100,2,100,100,4,100}));
    }
}
