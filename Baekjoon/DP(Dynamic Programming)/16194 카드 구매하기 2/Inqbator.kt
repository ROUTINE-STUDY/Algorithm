import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    // 입력
    val N = readLine().toInt()
    val p = IntArray(N+1)
    val dp = IntArray(N+1)
    readLine().split(" ").map { it.toInt() }.forEachIndexed { index, i ->
        p[index] = i
        dp[index] = p[index]
    }

    for (i in 0 until N) {
        for (j in 0 .. i) {
            dp[i+1] = (dp[j] + p[i-j]).coerceAtMost(dp[i+1])
        }
    }

    println(dp[N-1])
}