class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int nums1Pointer = 0;
        int nums2Pointer = 0;

        while (nums1Pointer <= nums1.length-1 && nums2Pointer <= nums2.length-1) {
            if (nums2[nums2Pointer] < nums1[nums1Pointer] || nums1Pointer >= m) {
                swipeArrays(nums1Pointer,m++, nums1);
                nums1[nums1Pointer] = nums2[nums2Pointer++];
            }
            nums1Pointer++;
        }
    }

    public void swipeArrays(int swipedStartPoint,int swipedEndPoint, int[] array) {
        while (swipedStartPoint <= swipedEndPoint) {
            if (swipedEndPoint != array.length - 1) {
                array[swipedEndPoint+1] = array[swipedEndPoint];
            }
            swipedEndPoint--;
        }
    }
}