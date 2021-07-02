import java.util.HashMap;
import java.util.Map;

class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int answer = nums[0];

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        }

        for (int number : map.keySet()) {
            if (map.get(number) > nums.length/2) {
                answer = number;
                break;
            }
        }

        return answer;
    }
}