package Dynamic_Programming.Climbing_Stairs;

/**
 * https://leetcode.com/problems/climbing-stairs/
 */
public class Sanghoo {

    // 1 2 3 = 1 2 3 으로 고정값
    // 4 = 2의 경우의 수 + 3의 경우의 수
    // 5 = 3의 경우의 수 + 4의 경우의 수
    // 위 패턴을 발견
    public int climbStairs(int n) {
        if(n<=3) return n;
        int[] arr = new int[n];

        arr[0] = 1;
        arr[1] = 2;
        arr[2] = 3;

        for(int i=3; i<n; i++) {
            arr[i] = arr[i-1] + arr[i-2];
        }

        return arr[n-1];
    }

}
