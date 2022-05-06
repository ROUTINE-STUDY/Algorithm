import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.abs

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val T = readLine().toInt()
    // 0이면 계산할 필요가 없다.
    if (T == 0) {
        println("0\n0")
        return
    }

    val absT = abs(T)
    val dp = IntArray(absT + 1)
    dp[1] = 1
    for (i in 2..absT) {
        dp[i] = (dp[i - 1] + dp[i - 2]) % 1_000_000_000
    }

    if (T > 0) {
        println(1)
    } else {
        if (T % 2 == 0) {
            println(-1)
        } else {
            println(1)
        }
    }
    println(abs(dp[absT]))
}

