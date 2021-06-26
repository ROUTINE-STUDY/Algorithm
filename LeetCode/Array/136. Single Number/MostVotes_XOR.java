class Solution {
    int singleNumber(int A[], int n) {
        int result = 0;

        for (int i = 0; i<n; i++) {
            result ^=A[i];
        }

        return result;
    }
}