import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.sqrt


fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val N = readLine().toInt()
    val dp = IntArray(N + 1) { it }

    for (n in 1..N) {
        val sqrted = sqrt(n.toDouble()).toInt()

        for (num in 1..sqrted) {
            dp[n] = dp[n].coerceAtMost(dp[n - num * num] + 1)
        }
    }
    println(dp[N])
}