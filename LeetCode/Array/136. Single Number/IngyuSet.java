import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

class Solution {
    public int singleNumber(int[] nums) {
        //Set에다 넣는 건 어떨까?
        //Set에 중복 비허용을 이용해서 일치하지 않으면 pop하는걸로.
        //Set에는 마지막 넣은 원소를 빼는 기능이 있나?
        //동시에 넣는데 set.add()메서드가 false면 -> 이미 있는 원소니까 뱉어 

        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num)){
                set.remove(num);
            }
        }

        return set.iterator().next();
    }
}