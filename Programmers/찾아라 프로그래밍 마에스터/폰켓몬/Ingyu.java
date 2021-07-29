import java.util.HashSet;
import java.util.Set;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        final int countLimit = nums.length/2;
        Set<Integer> set = new HashSet<>();

        //nums를 set에 넣는다.
        for (int num : nums) {
            set.add(num);
        }

        //set의 사이즈보다 countLimit가 같거나 크면 set의 사이즈가 정답.
        //set의 사이즈보다 countLimit가 작으면 countLimit가 정답.
        answer = set.size() <= countLimit ? set.size() : countLimit;

        return answer;
    }
}