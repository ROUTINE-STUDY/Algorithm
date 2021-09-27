package Array.Minimum_Absolute_Difference;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/minimum-absolute-difference/
 */
public class Sanghoo {

    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> answer = new ArrayList<>();

        // 최소 값 구하기
        Arrays.sort(arr);
        int MIN = arr[1] - arr[0];
        for(int i=1; i<arr.length-1; i++) {
            if(MIN > arr[i+1] - arr[i]) MIN = arr[i+1] - arr[i];
        }

        // 최소값과 일치하는 배열의 쌍 구하여 List에 넣기
        for(int i=0; i<arr.length-1; i++) {
            List<Integer> list = new ArrayList<>();
            if(arr[i+1] - arr[i] == MIN) {
                list.add(arr[i]);
                list.add(arr[i+1]);
                answer.add(list);
            }
        }

        return answer;
    }

}
