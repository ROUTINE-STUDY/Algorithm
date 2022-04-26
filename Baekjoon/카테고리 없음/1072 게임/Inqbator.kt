import java.io.BufferedReader
import java.io.InputStreamReader


fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (X, Y) = readLine().split(" ").map { it.toInt() }
    var currentWinRate = (Y * 100L / X)
    // 승률이 99이상이면 오를 수가 없음.
    if (currentWinRate >= 99) {
        println(-1)
        return
    }

    var left = 1L
    var right = 1000000000L
    // lower bound를 활용한 이분탐색
    while (left <= right) {
        val center = (left) + (right - left) / 2
        val winRate = ((Y + center) * 100) / (X + center)

        if (winRate > currentWinRate) {
            right = center - 1
        } else {
            left = center + 1
        }
    }

    println(left)
}