import java.io.BufferedReader
import java.io.InputStreamReader


fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    val N = readLine().toInt()
    val dp = IntArray(N+4)
    dp[0] = 1
    dp[1] = 1
    dp[2] = 2
    dp[3] = 3

    for (i in 4..N) {
        dp[i] = (dp[i-1] + dp[i-2]) % 10
    }

    println(dp[N])
}