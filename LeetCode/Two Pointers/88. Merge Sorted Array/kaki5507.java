class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        
        for(int i=m; i<nums1.length; i++) {
			nums1[i] = nums2[i-m];
		}
        
		Arrays.sort(nums1);
        
    }
}