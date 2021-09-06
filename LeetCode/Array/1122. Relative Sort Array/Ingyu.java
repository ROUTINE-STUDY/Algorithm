import java.util.*;

class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] answer = new int[arr1.length];
        Map<Integer, Integer> map = new TreeMap<>();
        for (int num :  arr1){
            map.put(num, map.getOrDefault(map.get(num),0)+1);
        }

        int index = 0;
        for (int num : arr2) {
            int size = map.get(num);
            for (int i = 1; i <= size; i++) {
                answer[index++] = num;
            }
            map.remove(num);
        }

        for (int num : map.keySet()) {
            for (int i = 0; i < map.get(num); i++) {
                answer[index++] = map.get(num);
            }
        }

        return answer;
    }
}