package Array.Relative_Sort_Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/relative-sort-array/
 */
public class Sanghoo {

    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        List<Integer> list = new ArrayList<>();

        for(int a2 : arr2) {
            for(int i = 0 ; i < arr1.length; i++) {
                if(arr1[i] == a2) {
                    list.add(arr1[i]);
                    arr1[i] = -1;
                }
            }
        }
        Arrays.sort(arr1);
        for(int i=list.size(); i < arr1.length; i++) {
            list.add(arr1[i]);
        }

        for(int i=0; i<list.size(); i++) {
            arr1[i] = list.get(i);
        }

        return arr1;
//        return list.stream().mapToInt(Integer::intValue).toArray();
    }

}
