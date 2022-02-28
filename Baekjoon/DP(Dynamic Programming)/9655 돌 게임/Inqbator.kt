import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val N = readLine().toInt()
    val dp = IntArray(N+4)
    dp[1] = 1
    dp[2] = 2
    dp[3] = 1

    for (a in 4..N) {
        dp[a] = dp[a-((a-1)/3)*3] + dp[((a-1)/3)*3]
    }

    // 짝수면 CY승, 홀수면 SK승
    if (dp[N] % 2 == 0) {
        println("CY")
    } else {
        println("SK")
    }
}