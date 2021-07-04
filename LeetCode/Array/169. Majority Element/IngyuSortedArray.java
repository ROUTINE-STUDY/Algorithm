import java.util.Arrays;

class Solution {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        int tempNum = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            tempNum = nums[i];
            if (tempNum == nums[i + n/2]) {
                break;
            }
        }

        return tempNum;
    }
}