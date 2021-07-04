package Array.Majority_Element;

import java.util.HashMap;
import java.util.Iterator;

/**
 * https://leetcode.com/problems/majority-element/
 */
public class Sanghoo_HashMap {

    // 자주 사용하는 hashmap과 hashmap의 getOrDefault 활용하여 각 원소의 개수를 저장
    // 가장 많은 원소의 개수는 nums의 길이 / 2 보다 많다는 성질을 이용하여 처리
    public static int majorityElement(int[] nums) {
        HashMap<Integer, Integer> hs = new HashMap();
        int standard = nums.length / 2;
        int res = 0;

        for(int n : nums) {
            hs.put(n, hs.getOrDefault(n, 0)+1);
        }

        Iterator it = hs.keySet().iterator();
        while(it.hasNext()) {
            int key = (int)it.next();
            if(standard < hs.get(key)) {
                res = key;
                break;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(majorityElement(new int[]{1,1,2,2,2}));
    }
}
