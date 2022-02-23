import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()
    val dp = IntArray(n+11){Int.MAX_VALUE}
    dp[2] = 1
    dp[5] = 1

    for (idxOfDP in 3..n) {
        if (idxOfDP-2 > 0 && dp[idxOfDP-2] != Int.MAX_VALUE) {
            dp[idxOfDP] = dp[idxOfDP-2]+1
        }
        if (idxOfDP-5 > 0 && dp[idxOfDP-5] != Int.MAX_VALUE) {
            dp[idxOfDP] = dp[idxOfDP].coerceAtMost(dp[idxOfDP-5]+1)
        }
    }

    if (dp[n] != Int.MAX_VALUE) println(dp[n])
    else println(-1)
}