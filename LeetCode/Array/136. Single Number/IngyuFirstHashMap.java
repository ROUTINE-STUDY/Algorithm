import java.util.HashMap;
import java.util.Map;

class Solution {
    public int singleNumber(int[] nums) {
	//숫자 개수 이용해서 푼 거.
        int answer = -1;
        Map<Integer, Integer> map = new HashMap<>();

	//숫자를 키로 숫자 개수를 값으로 넣어서 
	//숫자가 반복해서 나올 때마다 +1해줌.
        for (int num : nums) {
            map.put(num, (map.getOrDefault(num,0)+1) );
        }

	//key로 값을 찾아서 그 값이 1이면 
	//1번만 나온 수이므로 answer에 담아줌.
        for (int num : map.keySet()) {
            if (map.get(num) == 1) {
                answer = num;
                break;
            }
        }

        return answer;
    }
}