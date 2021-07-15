package Dynamic_Programming.Counting_Bits;

/**
 * https://leetcode.com/problems/counting-bits/
 */
public class Sanghoo {

    public static int[] countBits(int n) {
        int[] arr = new int[n+1];

        for(int i=0; i<=n; i++) {
            arr[i] = Integer.bitCount(i);   // i를 2진수로 변환 후 1의 수를 세주는 메서드
        }

        return arr;
    }

}
