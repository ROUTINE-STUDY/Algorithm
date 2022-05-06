import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.Math.abs


fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val T = readLine().toInt()
    // 0이면 계산할 필요가 없다.
    if (T == 0) {
        println("0\n0")
        return
    }

    val absT = kotlin.math.abs(T)
    val dp = IntArray(2 * absT + 1)
    dp[absT + 1] = 1
    if (T < 0) {
        for (i in -1 downTo T) {
            dp[i + absT] = (dp[i + 2 + absT] - dp[i + 1 + absT]) % 1_000_000_000
        }
    } else {
        for (i in 2..T) {
            dp[i + absT] = (dp[i - 1 + absT] + dp[i - 2 + absT]) % 1_000_000_000
        }
    }

    val fibonacciNum = dp[absT + T]
    if (fibonacciNum > 0) {
        println(1)
    } else {
        println(-1)
    }
    println(kotlin.math.abs(dp[absT + T]))
}

