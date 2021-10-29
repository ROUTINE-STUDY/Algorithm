import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        // n번째 피보나치 수를 구하여라
        int n = Integer.parseInt(bfr.readLine());
        dp = new int[n+1];
        System.out.println(recursion(n));
    }

    private static int recursion(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        if (dp[n] != 0) return dp[n];

        dp[n] = recursion(n-2) + recursion(n-1);
        return dp[n];
    }
}