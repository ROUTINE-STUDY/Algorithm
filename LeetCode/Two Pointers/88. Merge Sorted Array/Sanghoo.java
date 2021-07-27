package Two_Pointers.Merge_Sorted_Array;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/merge-sorted-array/
 */
public class Sanghoo {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int index=0;

        for(int i=m; i<nums1.length; i++) {
            nums1[i] = nums2[index++];
        }

        Arrays.sort(nums1);
    }

}
