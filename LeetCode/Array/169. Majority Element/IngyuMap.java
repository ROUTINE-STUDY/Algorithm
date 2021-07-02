import java.util.HashMap;
import java.util.Map;

class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int answer = nums[0];
        int maxNumCount = 0;

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);

            if (i >= nums.length/2) {
                if (map.get(nums[i]) > maxNumCount) {
                    maxNumCount = map.get(nums[i]);
                    answer = nums[i];
                }
            }
        }

        return answer;
    }
}
