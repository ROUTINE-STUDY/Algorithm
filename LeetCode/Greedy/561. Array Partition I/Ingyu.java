import java.util.Arrays;

class Solution {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;

        //nums.length-2까지 가야 마지막 두번째로 큰 숫자임.
        for (int i = nums.length-2; i >= 0 ; i-=2) {
            sum += nums[i];
        }

        return sum;
    }
}