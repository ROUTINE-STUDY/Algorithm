import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    var (N, left, right) = readLine().split(" ").map { it.toInt() }
    var stage = 0

    while (left != right) {
        left -= left / 2
        right -= right / 2
        stage++
    }

    println(stage)
}