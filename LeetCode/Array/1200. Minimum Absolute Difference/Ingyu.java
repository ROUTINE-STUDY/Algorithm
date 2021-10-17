import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> answer = new LinkedList();
        Arrays.sort(arr);
        int pivot = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i+1] - arr[i] < pivot) pivot = arr[i] - arr[i+1];
        }

        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i+1] - arr[i] == pivot) {
                List temp = new LinkedList();
                temp.add(arr[i]);
                temp.add(arr[i+1]);
                answer.add(temp);
            }
        }

        return answer;
    }
}