package leetcodeLv2;

import java.util.Arrays;
import java.util.HashMap;

public class MajorityElement {

	public static void main(String[] args) {
		
		
		// 첫 번째 방법
		// 정렬 후, 배열 중간에는 가장 많이나오는 인덱스가 존재.
		Arrays.sort(nums);
		return nums[nums.length / 2];
		
		// 두 번째 방법
		// map을 이용하여 map밸류가 nums의 길이의 반 보다 크면, 가장 많이나오는 인덱스가 존재.
		/*
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        int count = 0;
        for(int i : nums){
            if(map.containsKey(i)){
                count = map.get(i);
                map.put(i, count+1);
            }else{
                map.put(i , 1);
            }
            
            if(map.get(i) > nums.length/2){
                return i;
            }
        }
        
        return 999;
		*/
	}

}
