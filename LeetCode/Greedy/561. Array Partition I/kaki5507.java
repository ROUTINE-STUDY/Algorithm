class Solution {
    public int arrayPairSum(int[] nums) {
        // 정렬을 하면 최소값이 앞으로 온다.
		Arrays.sort(nums);
		
		//return 해줄 answer 만들어 줍니다.
		int answer = 0;
		
		for(int i=0; i<nums.length; i+=2) {
			answer += nums[i];
		}
        
        return answer;
		
		// 4면 1 , 3
		// 6이면 1 , 3 , 5
		// 8이면 1 , 3 , 5 ,7
    }
}