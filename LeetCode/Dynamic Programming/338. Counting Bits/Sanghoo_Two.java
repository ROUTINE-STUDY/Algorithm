package Dynamic_Programming.Counting_Bits;

/**
 * https://leetcode.com/problems/counting-bits/
 */
public class Sanghoo_Two {

    public static int[] countBits(int n) {
        int[] arr = new int[n+1];

        for(int i=0; i<=n; i++) {
            String bi = Integer.toBinaryString(i);          // i를 온전한 2진수 String으로 반환해주는 메서드
            bi = bi.replaceAll("0", "");                    // 위 메서드와 0을 없애기 위해 replaceAll 활용

            arr[i] = bi.length();                           // 0을 없앴기때문에 문자열의 길이가 곧 1의 개수
        }

        return arr;
    }

}
