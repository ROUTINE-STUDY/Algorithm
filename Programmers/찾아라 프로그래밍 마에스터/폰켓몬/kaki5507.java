import java.util.*;

class Solution {
    public int solution(int[] nums) {
		
	// 포켓몬 도감 어느 포켓몬이 많은지
	HashMap map = new HashMap();
		
	for(int i=0; i<nums.length; i++) {
		if(map.containsKey(nums[i])) { //map에 같은 키가 있으면 get을 가져와서 +1 해줌. 
			int count = (int)map.get(nums[i]);
			map.put(nums[i], count + 1);
		}else {
			map.put(nums[i], 1);
		}
	}
        
        int answer=Math.min(nums.length/2,map.size());
        return answer;
    }
}